package dagrion.the_world_rift.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

import java.util.UUID;

/**
 * Total Master: ~90% slower movement, Resistance 2 (40% damage reduction), +8 attack damage.
 */
public class TotalMasterEffect extends StatusEffect {
    private static final UUID STRENGTH_MODIFIER_ID = UUID.fromString("A1B2C3D4-E5F6-7890-ABCD-EF1234567890");
    private static final UUID SLOWNESS_MODIFIER_ID = UUID.fromString("B2C3D4E5-F6A7-8901-BCDE-F12345678901");

    public TotalMasterEffect(StatusEffectCategory category, int color) {
        super(category, color);
        addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, STRENGTH_MODIFIER_ID.toString(),
                8.0, EntityAttributeModifier.Operation.ADDITION);
        // -90% speed → 10% of base: MULTIPLY_TOTAL -0.90
        addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, SLOWNESS_MODIFIER_ID.toString(),
                -0.90, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);
        if (!entity.getWorld().isClient()) {
            var instance = entity.getStatusEffect(this);
            if (instance != null) {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,
                        instance.getDuration(), 1, false, false, false));
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
