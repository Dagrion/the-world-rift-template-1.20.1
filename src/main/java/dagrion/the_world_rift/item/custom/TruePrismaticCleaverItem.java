package dagrion.the_world_rift.item.custom;

import com.google.common.collect.ImmutableMultimap;
import dagrion.the_world_rift.effect.ModEffect;
import dagrion.the_world_rift.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;

import java.util.List;

public class TruePrismaticCleaverItem extends ClaymoreItem {
    public TruePrismaticCleaverItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        if (attacker.getWorld().isClient()) return true;

        if (attacker.getMainHandStack().getItem() == ModItems.TRUE_PRISMATIC_CLEAVER) {

            if (Math.random() < 0.5) {
                List<StatusEffect> effects = Registries.STATUS_EFFECT.stream().toList();
                StatusEffect randomEffect = effects.get(attacker.getRandom().nextInt(effects.size()));

                int duration = 20 * (6 + attacker.getRandom().nextInt(12));
                int amplifier = attacker.getRandom().nextInt(4);

                if (randomEffect == StatusEffects.INSTANT_DAMAGE) { duration = 1; }
                if (randomEffect == ModEffect.BLOODLOSS
                        || randomEffect == ModEffect.ARMOR_CRUSH
                ) { amplifier = 0 ; }
                if (randomEffect == ModEffect.BLACKOUT) { amplifier = 0 ; duration = 20 * 3 ;}

                target.addStatusEffect(new StatusEffectInstance(randomEffect, duration, amplifier));
            }
        }

        return true;
    }
}
