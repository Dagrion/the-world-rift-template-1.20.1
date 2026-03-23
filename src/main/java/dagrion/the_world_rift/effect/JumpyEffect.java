package dagrion.the_world_rift.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class JumpyEffect extends StatusEffect {
    /** Chance per tick to trigger a jump (e.g. 0.03 = 3% per tick ≈ once every 1.5 seconds) */
    private static final float BASE_JUMP_CHANCE = 0.03f;
    /** Extra chance per amplifier level */
    private static final float JUMP_CHANCE_PER_LEVEL = 0.02f;

    public JumpyEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);
        if (entity.getWorld().isClient()) return;

        float chance = BASE_JUMP_CHANCE + amplifier * JUMP_CHANCE_PER_LEVEL;
        if (entity.getRandom().nextFloat() < chance && entity.isOnGround()) {
            entity.setVelocity(
                    entity.getVelocity().x,
                    0.5D, // jump strength
                    entity.getVelocity().z
            );
            entity.velocityModified = true;
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
