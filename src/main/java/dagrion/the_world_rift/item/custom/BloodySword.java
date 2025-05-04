package dagrion.the_world_rift.item.custom;

import dagrion.the_world_rift.effect.ModEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class BloodySword extends SwordItem {
    public BloodySword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (Math.random() < 0.1) {
            target.addStatusEffect(new StatusEffectInstance(ModEffect.BLOODLOSS,100,0));
        }
        return true;
    }
}
