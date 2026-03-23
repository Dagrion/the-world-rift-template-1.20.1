package dagrion.the_world_rift.mixin;

import dagrion.the_world_rift.effect.ModEffect;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class HeavyMixin {

    @Inject(method = "jump", at = @At("HEAD"), cancellable = true)
    private void cancelJump(CallbackInfo ci) {
        LivingEntity entity = (LivingEntity)(Object)this;

        if (entity.hasStatusEffect(ModEffect.HEAVY)) {
            ci.cancel();
        }
    }
}
