package dagrion.the_world_rift.item.custom;

import dagrion.the_world_rift.entity.custom.HypernovaEntity;
import dagrion.the_world_rift.util.ModDamageSources;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Hypernova extends Item {
    public Hypernova(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (user.isCreative()) {
            world.playSound((PlayerEntity) null, user.getX(), user.getY(), user.getZ(),
                    SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
            if (!world.isClient) {
                HypernovaEntity hypernovaEntity = new HypernovaEntity(user, world);
                hypernovaEntity.setItem(itemStack);
                hypernovaEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
                world.spawnEntity(hypernovaEntity);
            }

            user.incrementStat(Stats.USED.getOrCreateStat(this));
            if (!user.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
        }
            return TypedActionResult.success(itemStack, world.isClient());
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, net.minecraft.entity.Entity entity, int slot, boolean selected) {
        if (!world.isClient) {
            if (stack.getItem() instanceof Hypernova) {
                entity.damage(ModDamageSources.manan(entity.getWorld()),99999999999999999999999999999999999999F);
            }
        }
    }
}

