package dagrion.the_world_rift.item.custom;

import dagrion.the_world_rift.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.Objects;

public class StingerItem extends Item {
    public StingerItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
            if (user.getStackInHand(hand).getItem() == ModItems.EMPTY_VIAL && user.getOffHandStack().getItem() == ModItems.STINGER) {
                user.getStackInHand(hand).decrement(1);
                user.damage(user.getDamageSources().magic(), 2f);
                user.getItemCooldownManager().set(user.getOffHandStack().getItem(), 20);
                user.getItemCooldownManager().set(user.getMainHandStack().getItem(), 20);
                user.giveItemStack(new ItemStack(ModItems.BLOOD_VIAL));
            }
        return super.use(world, user, hand);
    }

    public boolean postHit (ItemStack stack, LivingEntity target, LivingEntity attacker)  {
        if (target instanceof PlayerEntity player && attacker instanceof PlayerEntity user)
                if (user.getMainHandStack().getItem() == ModItems.STINGER && user.getOffHandStack().getItem() == ModItems.EMPTY_VIAL) {
                    user.getOffHandStack().decrement(1);
                    user.giveItemStack(new ItemStack(ModItems.BLOOD_VIAL));
                    player.damage(player.getDamageSources().generic(), 4);
                }
        return super.postHit(stack, attacker, target);
    }
}
