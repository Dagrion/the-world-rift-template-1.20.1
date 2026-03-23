package dagrion.the_world_rift.item.custom;

import dagrion.the_world_rift.component.weapons.WeaponChargeComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;


public class ChargerItem extends Item {
    private static final int FULL_CHARGE_TICKS = 60; // 2 seconds
    private static final int COOLDOWN_TICKS = 1200;

    public ChargerItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand); // Begin charging
        WeaponChargeComponent charge = WeaponChargeComponent.get(user);
        if (charge != null) charge.chargeAll();
        return TypedActionResult.consume(user.getStackInHand(hand));
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 72000; // Like bow: hold indefinitely
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.SPEAR;
    }
}
