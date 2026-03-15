package dagrion.the_world_rift.effect;

import dagrion.the_world_rift.util.ModDamageSources;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class BloodlossEffect extends StatusEffect {
    public BloodlossEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i = 20 >> amplifier;
        if (i > 0) {
            return duration % i == 0;
        } else {
            return true;
        }
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getWorld().isClient()) {

            entity.damage(
                    ModDamageSources.bleeding(entity.getWorld()),
                    1.0F + amplifier
            );
            super.applyUpdateEffect(entity, amplifier);
        }
    }
}