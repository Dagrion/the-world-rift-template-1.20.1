package dagrion.the_world_rift.item.custom;

import com.google.common.collect.ImmutableMultimap;
import dagrion.the_world_rift.effect.ModEffect;
import dagrion.the_world_rift.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;

import java.util.ArrayList;
import java.util.List;

public class PrismaticCleaverItem extends ClaymoreItem {
    public PrismaticCleaverItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        if (attacker.getWorld().isClient()) return true;
        // Only trigger for your weapon
        if (attacker.getMainHandStack().getItem() == ModItems.PRISMATIC_CLEAVER) {
            if (Math.random() < 0.5) {
                // Get ALL harmful effects
                List<StatusEffect> harmfulEffects = Registries.STATUS_EFFECT.stream()
                        .filter(effect -> effect.getCategory() == StatusEffectCategory.HARMFUL)
                        .toList();
                // Manually add extra effects here
                List<StatusEffect> extraEffects = List.of(
                        StatusEffects.GLOWING,
                        StatusEffects.SLOW_FALLING
                );

                // Combine both lists
                List<StatusEffect> allEffects = new ArrayList<>(harmfulEffects);
                allEffects.addAll(extraEffects);
                // Pick random effect
                StatusEffect randomEffect = allEffects.get(attacker.getRandom().nextInt(allEffects.size()));

                int duration = 20 * (3 + attacker.getRandom().nextInt(8));
                int amplifier = attacker.getRandom().nextInt(3);

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
