package dagrion.the_world_rift.mixin;

import dagrion.the_world_rift.block.ModBlocks;
import dagrion.the_world_rift.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(AbstractBlock.class)
public class EnchanteddiamondoreMixin {
     @Inject(method = "onUse", at = @At("HEAD"))
        private void onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ActionResult> cir) {
            if (world.getBlockState(pos).isOf(Blocks.DIAMOND_ORE) && !world.isClient) {
                if (player.getMainHandStack().isOf(ModItems.NETHER_STAR_POWDER) && player.getMainHandStack().getCount() >= 4) {
                    world.setBlockState(pos, Blocks.AIR.getDefaultState());
                    Block.dropStack(world, pos, new ItemStack(ModBlocks.ENCHANTED_DIAMOND_ORE, 1));
                    player.getMainHandStack().decrement(4);
                }
            }
        }
    }

