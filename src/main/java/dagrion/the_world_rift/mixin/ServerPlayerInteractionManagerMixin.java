package dagrion.the_world_rift.mixin;

import dagrion.the_world_rift.util.BlockBreakContext;
import net.minecraft.block.BlockState;
import net.minecraft.server.network.ServerPlayerInteractionManager;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerPlayerInteractionManager.class)
public class ServerPlayerInteractionManagerMixin {

    @Shadow
    private net.minecraft.server.world.ServerWorld world;

    @Inject(method = "continueMining", at = @At("HEAD"))
    private void theWorldRift$setBreakContext(BlockState state, BlockPos pos, int failedStartMiningTime,
                                              CallbackInfoReturnable<Float> cir) {
        BlockBreakContext.set(world, pos);
    }

    @Inject(method = "continueMining", at = @At("RETURN"))
    private void theWorldRift$clearBreakContext(BlockState state, BlockPos pos, int failedStartMiningTime,
                                                CallbackInfoReturnable<Float> cir) {
        BlockBreakContext.clear();
    }
}
