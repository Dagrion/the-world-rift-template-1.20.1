package dagrion.the_world_rift.mixin;

import dagrion.the_world_rift.util.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Blocks in {@link ModTags.Blocks#NEEDS_NETHERITE_TOOL} mine much slower unless the player uses a netherite pickaxe.
 */
@Mixin(PlayerEntity.class)
public class PlayerEntityBlockBreakingSpeedMixin {

    /** Multiplier applied to breaking speed when the tool is not a netherite pickaxe (similar to wrong-tier feel). */
    private static final float WRONG_TOOL_SPEED_MULTIPLIER = 0.12f;

    @Inject(method = "getBlockBreakingSpeed", at = @At("RETURN"), cancellable = true)
    private void theWorldRift$slowDungeonWithoutNetheritePickaxe(BlockState block, CallbackInfoReturnable<Float> cir) {
        if (!block.isIn(ModTags.Blocks.NEEDS_NETHERITE_TOOL)) {
            return;
        }
        PlayerEntity self = (PlayerEntity) (Object) this;
        if (self.getMainHandStack().isOf(Items.NETHERITE_PICKAXE)) {
            return;
        }
        cir.setReturnValue(cir.getReturnValue() * WRONG_TOOL_SPEED_MULTIPLIER);
    }
}
