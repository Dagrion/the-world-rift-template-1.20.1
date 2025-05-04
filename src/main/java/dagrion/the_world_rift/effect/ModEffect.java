package dagrion.the_world_rift.effect;

import dagrion.the_world_rift.TheWorldRift;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffect {
    public static final StatusEffect BLOODLOSS = registerStatusEffect("bloodloss",
            new BloodlossEffect(StatusEffectCategory.HARMFUL,0xa91101)
                    .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                            "22653B89-116E-49DC-9B6B-9971489B5BE5",-2.0F, EntityAttributeModifier.Operation.ADDITION));

    public static final StatusEffect BLOODLUST = registerStatusEffect("bloodlust",
            new BloodlustEffect(StatusEffectCategory.BENEFICIAL,0xa91101)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            "91AEAA56-376B-4498-935B-2F7F68070635", 0.5F, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
                    .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                            "648D7064-6A60-4F59-8ABE-C2C23A6DD7A9", 2.0F, EntityAttributeModifier.Operation.ADDITION)
                    .addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS,
                            "648D7064-6A60-4F59-8ABE-C2C23A6DD7A9", 1.0F, EntityAttributeModifier.Operation.ADDITION));


    private static StatusEffect registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(TheWorldRift.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        TheWorldRift.LOGGER.info("Register Mod Effects for " + TheWorldRift.MOD_ID);
    }
}
