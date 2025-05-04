package dagrion.the_world_rift.item.custom;

import dagrion.the_world_rift.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BloodyHammer extends SwordItem {
    public static final float KNOCKBACK_RANGE = 3.5F;
    private static final float KNOCKBACK_POWER = 0.7F;

    public BloodyHammer(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
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
                attacker.setVelocity(attacker.getVelocity().x, 2, attacker.getVelocity().z);
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
        if (user.getMainHandStack().getItem() == ModItems.BLOODY_HAMMER) {
            user.setVelocity (0, 1.25, 0);
            user.getItemCooldownManager().set(user.getMainHandStack().getItem(), 300);
        }
        return super.use(world, user, hand);
    }
}

