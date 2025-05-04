package dagrion.the_world_rift.item.custom;

import dagrion.the_world_rift.effect.ModEffect;
import dagrion.the_world_rift.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
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
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (user.getMainHandStack().getItem() == ModItems.BLOODY_DUAL_BLADE) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 600, 2, false, false, true));
            user.getItemCooldownManager().set(user.getMainHandStack().getItem(), 600);
        }
        return TypedActionResult.success(itemStack);
    }

}
