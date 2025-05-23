package dagrion.the_world_rift.item.custom;

import dagrion.the_world_rift.effect.ModEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

public class BloodyDualBlade extends SwordItem {
    public BloodyDualBlade(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (Math.random() < 0.35) {
            target.addStatusEffect(new StatusEffectInstance(ModEffect.BLOODLOSS, 175, 0));
        }
        return true;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, net.minecraft.entity.Entity entity, int slot, boolean selected) {
        if (!world.isClient && entity instanceof PlayerEntity player) {
            boolean isMainHand = player.getMainHandStack() == stack;

            if (isMainHand) {
                StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.SPEED, 40, 1, true, false, true);
                player.addStatusEffect(effect);
            }
        }
    }
}
