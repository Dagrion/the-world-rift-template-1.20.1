package dagrion.the_world_rift.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import dagrion.the_world_rift.component.weapons.WeaponChargeComponent;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class HammerItem extends SwordItem {
    public static final float KNOCKBACK_RANGE = 3.5F;
    private static final float KNOCKBACK_POWER = 0.7F;
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public HammerItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", toolMaterial.getAttackDamage() + attackDamage + 0, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(slot);
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return !miner.isCreative();
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (shouldDealAdditionalDamage(attacker)) {
            ServerWorld serverWorld = (ServerWorld) attacker.getWorld();
            if (attacker.fallDistance > 1.5) {
                attacker.setVelocity(attacker.getVelocity().x, 1, attacker.getVelocity().z);
            } else {
                attacker.setVelocity(attacker.getVelocity().multiply(1, 0.1, 1));
            }
            if (attacker instanceof ServerPlayerEntity serverPlayer) {
                serverPlayer.networkHandler.sendPacket(new EntityVelocityUpdateS2CPacket(serverPlayer));
            }

            target.damage(target.getDamageSources().generic(), 0.5f*attacker.fallDistance);
            for (float i = attacker.fallDistance; i > 0; i--) {
                if (i > 7) {
                    target.damage(target.getDamageSources().playerAttack((PlayerEntity) attacker), 2f);
                } else if (i > 3) {
                    target.damage(target.getDamageSources().playerAttack((PlayerEntity) attacker), 4.0f);
                } else {
                    target.damage(target.getDamageSources().playerAttack((PlayerEntity) attacker), 8.0f);
                }
            }

            knockbackNearbyEntities(serverWorld, attacker, target);
        }
        postDamageEntity(stack,target,attacker);
        WeaponChargeComponent.IncrementHAMMER(2);
        return true;
    }

    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        if (shouldDealAdditionalDamage(attacker)) {
            attacker.onLanding();
        }
    }

    public static boolean shouldDealAdditionalDamage(LivingEntity attacker) {
        return attacker.fallDistance > 1.5F && !attacker.isFallFlying();
    }

    private static void knockbackNearbyEntities(World world, Entity attacker, Entity attacked) {
        world.getEntitiesByClass(LivingEntity.class, attacked.getBoundingBox().expand(KNOCKBACK_RANGE), entity -> entity != attacker && entity != attacked)
                .forEach(entity -> {
                    Vec3d vec = entity.getPos().subtract(attacked.getPos()).normalize().multiply(KNOCKBACK_POWER);
                    entity.addVelocity(vec.x, 0.7, vec.z);
                    if (entity instanceof ServerPlayerEntity serverPlayer) {
                        serverPlayer.networkHandler.sendPacket(new EntityVelocityUpdateS2CPacket(serverPlayer));
                    }
                });
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient) {
            if (WeaponChargeComponent.HAMMER >= WeaponChargeComponent.MAX_HAMMER) {
                Vec3d attackerPos = user.getPos();
                WeaponChargeComponent.UseHAMMER(100);

                double radius = 3.5;
                Box box = new Box(
                        attackerPos.x - radius, attackerPos.y + -1, attackerPos.z - radius,
                        attackerPos.x + radius, attackerPos.y + 2, attackerPos.z + radius
                );
                List<LivingEntity> nearby = world.getEntitiesByClass(LivingEntity.class, box,
                        e -> e != user);

                float sweepDamage = 6.0f;

                for (LivingEntity entity : nearby) {
                    entity.damage(entity.getDamageSources().mobAttack(user), sweepDamage);
                    Vec3d pushDir = entity.getPos().subtract(user.getPos()).normalize();
                    entity.setVelocity(
                            pushDir.x * 1.5,
                            1.0, // vertical boost
                            pushDir.z * 1.5
                    );
                    if (entity instanceof ServerPlayerEntity serverPlayer) {
                        serverPlayer.networkHandler.sendPacket(new EntityVelocityUpdateS2CPacket(serverPlayer));
                    }
                }

                world.playSound(null, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.PLAYERS, 1.0f, 1.0f);

                ((ServerWorld) world).spawnParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
                        user.getX(), user.getY() + 1.0, user.getZ(),
                        150, 3.5, 1.5, 3.5, 0.025);
            }
        }
        return TypedActionResult.consume(stack);
    }

    @Override
    public boolean isItemBarVisible(ItemStack stack) {
        return true;
    }
    @Override
    public int getItemBarStep(ItemStack stack) {
        return Math.round((float) WeaponChargeComponent.HAMMER / WeaponChargeComponent.MAX_HAMMER * 13); // full bar = max charge
    }
    @Override
    public int getItemBarColor(ItemStack stack) {
        int red = (int) (255);
        int blue = (int) (36);
        int green = (int) (0);
        return (red << 16) | (green << 8) | blue; // RGB mix
    }
}