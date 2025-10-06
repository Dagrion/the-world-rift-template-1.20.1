package dagrion.the_world_rift.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import dagrion.the_world_rift.effect.ModEffect;
import dagrion.the_world_rift.item.ModItems;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BloodyHalberd extends AxeItem {
    protected static final UUID ATTACK_REACH_MODIFIER_ID = UUID.fromString("66dbd500-02d6-46a9-b510-699af6ac0936");
    protected static final UUID REACH_MODIFIER_ID = UUID.fromString("e7509cce-5ee6-4bb2-97e7-39a01aa58913");
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public BloodyHalberd(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", toolMaterial.getAttackDamage() + attackDamage + 0, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        builder.put(ReachEntityAttributes.ATTACK_RANGE, new EntityAttributeModifier(ATTACK_REACH_MODIFIER_ID, "Weapon modifier", 1.5, EntityAttributeModifier.Operation.ADDITION));
        builder.put(ReachEntityAttributes.REACH, new EntityAttributeModifier(REACH_MODIFIER_ID, "Weapon modifier", 2.0, EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(slot);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = attacker.getWorld();
        if (!world.isClient && attacker.isOnGround()) {
            Vec3d attackerPos = attacker.getPos();

            // Sweep radius (like Sweeping Edge)
            double radius = 4.5;
            Box box = new Box(
                    attackerPos.x - radius, attackerPos.y - 1.0, attackerPos.z - radius,
                    attackerPos.x + radius, attackerPos.y + 1.0, attackerPos.z + radius
            );

            List<LivingEntity> nearby = world.getEntitiesByClass(LivingEntity.class, box,
                    e -> e != attacker && e != target && e.isAlive());

            // Sweep damage ~ half base damage
            float sweepDamage = 4.0f;

            for (LivingEntity entity : nearby) {
                entity.damage(entity.getDamageSources().mobAttack(attacker), sweepDamage);
            }

            // Play sweep sound and particles
            world.playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(),
                    SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, SoundCategory.PLAYERS, 1.0f, 1.0f);

            ((ServerWorld) world).spawnParticles(ParticleTypes.SWEEP_ATTACK,
                    attacker.getX(), attacker.getY() + 1.0, attacker.getZ(),
                    1, 0.0, 0.0, 0.0, 0.0);
        }
        if (Math.random() < 0.15) {
            target.addStatusEffect(new StatusEffectInstance(ModEffect.BLOODLOSS,100,0));
        }
        return true;
    }



}

