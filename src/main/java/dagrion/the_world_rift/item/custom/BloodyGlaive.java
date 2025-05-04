package dagrion.the_world_rift.item.custom;

import dagrion.the_world_rift.effect.ModEffect;
import dagrion.the_world_rift.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class BloodyGlaive extends AxeItem {
    public BloodyGlaive(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (Math.random() < 0.15) {
            target.addStatusEffect(new StatusEffectInstance(ModEffect.BLOODLOSS,100,0));
        }
        return true;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user.getMainHandStack().getItem() == ModItems.BLOODY_GLAIVE) {
            user.setVelocity (0, -1.5, 0);
            user.getItemCooldownManager().set(user.getMainHandStack().getItem(), 300);
        }
        return super.use(world, user, hand);
    }
}

