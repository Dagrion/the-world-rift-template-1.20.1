package dagrion.the_world_rift.mixin;

import dagrion.the_world_rift.util.BlockBreakContext;
import net.minecraft.block.AbstractBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.class)
public class AbstractBlockHardnessMixin {

    @Inject(method = "getHardness", at = @At("HEAD"), cancellable = true)
    private void theWorldRift$rayProtectedHardness(CallbackInfoReturnable<Float> cir) {
        if (BlockBreakContext.isRayProtectedBlock()) {
            cir.setReturnValue(-1.0f);
        }
    }
}
