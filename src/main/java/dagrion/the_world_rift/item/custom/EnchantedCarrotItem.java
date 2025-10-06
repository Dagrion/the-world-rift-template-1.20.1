package dagrion.the_world_rift.item.custom;

import dagrion.the_world_rift.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import static net.minecraft.entity.effect.StatusEffects.NIGHT_VISION;

public class EnchantedCarrotItem extends Item {
    public EnchantedCarrotItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        // Call user.eatFood() to get the effects from eating the item. Make sure to make a copy of the item so it isn't removed when this is called.
        user.eatFood(world, stack.copy());
        user.addStatusEffect(new StatusEffectInstance(NIGHT_VISION,12000,0,true,false));

        // Return the new stack. In this case, we don't want the stack to change.
        return stack;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}