package dagrion.the_world_rift.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import dagrion.the_world_rift.component.weapons.WeaponChargeComponent;
import dagrion.the_world_rift.effect.ModEffect;
import dagrion.the_world_rift.item.ModItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import java.util.List;
import java.util.UUID;

public class ScytheItem extends SwordItem {
    protected static final UUID ATTACK_REACH_MODIFIER_ID = UUID.fromString("66dbd500-02d6-46a9-b510-699af6ac0936");
    protected static final UUID REACH_MODIFIER_ID = UUID.fromString("e7509cce-5ee6-4bb2-97e7-39a01aa58913");
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    final double RANGE = 9;
    final float BASE_DAMAGE = 14;
    double boost = 2;

    public ScytheItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
            ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
            builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", toolMaterial.getAttackDamage() + attackDamage + 0, EntityAttributeModifier.Operation.ADDITION));
            builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION));
            builder.put(ReachEntityAttributes.ATTACK_RANGE, new EntityAttributeModifier(ATTACK_REACH_MODIFIER_ID, "Weapon modifier", 0.75, EntityAttributeModifier.Operation.ADDITION));
            builder.put(ReachEntityAttributes.REACH, new EntityAttributeModifier(REACH_MODIFIER_ID, "Weapon modifier", 1.5, EntityAttributeModifier.Operation.ADDITION));
            this.attributeModifiers = builder.build();
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(slot);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (Math.random() < 0.15 && attacker.getMainHandStack().getItem() == ModItems.BLOODSTAINED_SCYTHE) {
            target.addStatusEffect(new StatusEffectInstance(ModEffect.BLOODLOSS,20 * 5,0)); }
        if (Math.random() < 0.01 && attacker.getMainHandStack().getItem() == ModItems.FAULTY_DEVICE_CADEUCEUS) {
            target.addStatusEffect(new StatusEffectInstance(ModEffect.ARMOR_CRUSH,20 * 5,0)); }
        if (Math.random() < 0.15 && attacker.getMainHandStack().getItem() == ModItems.LATCHING_EMPTINESS) {
            target.addStatusEffect(new StatusEffectInstance(ModEffect.BLACKOUT,20 * 5,0)); }
        if (attacker instanceof PlayerEntity p) {
            WeaponChargeComponent charge = WeaponChargeComponent.get(p);
            if (charge != null) charge.incrementScythe(2);
        }
        return true;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient) {
            WeaponChargeComponent charge = WeaponChargeComponent.get(user);
            if (charge != null && charge.getScythe() >= WeaponChargeComponent.MAX) {
                Vec3d attackerPos = user.getPos();
                charge.useScythe(100);

                double radius = 3.5;
                Box box = new Box(
                        attackerPos.x - radius, attackerPos.y + -2, attackerPos.z - radius,
                        attackerPos.x + radius, attackerPos.y + 3, attackerPos.z + radius
                );
                List<LivingEntity> nearby = world.getEntitiesByClass(LivingEntity.class, box,
                        e -> e != user);

                float sweepDamage = 6.0f;

                for (LivingEntity entity : nearby) {
                    entity.damage(entity.getDamageSources().mobAttack(user), sweepDamage);
                    Vec3d pullDir = entity.getPos().subtract(user.getPos()).normalize();
                    entity.setVelocity(
                            pullDir.x * -1.5,
                            pullDir.y * -1.5,
                            pullDir.z * -1.5
                    );
                    if (entity instanceof ServerPlayerEntity serverPlayer) {
                        serverPlayer.networkHandler.sendPacket(new EntityVelocityUpdateS2CPacket(serverPlayer));
                    }
                }

                world.playSound(null, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, SoundCategory.PLAYERS, 1.0f, 1.0f);
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
        WeaponChargeComponent charge = WeaponChargeComponent.getForDisplay();
        return charge != null ? Math.round((float) charge.getScythe() / WeaponChargeComponent.MAX * 13) : 0;
    }
    @Override
    public int getItemBarColor(ItemStack stack) {
        int red = (int) (255);
        int blue = (int) (36);
        int green = (int) (0);
        return (red << 16) | (green << 8) | blue; // RGB mix
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        if (stack.isOf(ModItems.BLOODSTAINED_SCYTHE)) {
            tooltip.add(Text.literal("Have a chance to inflict Blood Loss").formatted(Formatting.DARK_RED));
        }
        if (stack.isOf(ModItems.LATCHING_EMPTINESS)) {
            tooltip.add(Text.literal("Made for Melody Vox").formatted(Formatting.GRAY));
            tooltip.add(Text.literal("Have a chance to give Blackout").formatted(Formatting.GRAY));
        }
        if (stack.isOf(ModItems.FAULTY_DEVICE_CADEUCEUS)) {
            tooltip.add(Text.literal("Made for Charluk").formatted(Formatting.GRAY));
            tooltip.add(Text.literal("Have a very low chance to inflict Armor Crush").formatted(Formatting.GRAY));
        }
    }
}