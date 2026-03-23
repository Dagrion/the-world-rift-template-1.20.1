package dagrion.the_world_rift.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

import java.util.UUID;

/**
 * Oxidized: 40% slower movement, -8 attack damage.
 */
public class OxidizedEffect extends StatusEffect {
    private static final UUID WEAKNESS_MODIFIER_ID = UUID.fromString("C3D4E5F6-A7B8-9012-CDEF-234567890123");
    private static final UUID SLOWNESS_MODIFIER_ID = UUID.fromString("D4E5F6A7-B8C9-0123-DEFA-345678901234");

    public OxidizedEffect(StatusEffectCategory category, int color) {
        super(category, color);
        addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, WEAKNESS_MODIFIER_ID.toString(),
                -8.0, EntityAttributeModifier.Operation.ADDITION);
        // -40% speed
        addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, SLOWNESS_MODIFIER_ID.toString(),
                -0.40, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
    }
}
