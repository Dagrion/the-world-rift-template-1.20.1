package dagrion.the_world_rift.mixin;

import dagrion.the_world_rift.effect.ModEffect;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class BlackoutMixin {

    private static int fadeAlpha = 0;

    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void renderOverlay(DrawContext drawContext, float tickDelta, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();

        boolean active = client.player != null && client.player.hasStatusEffect(ModEffect.BLACKOUT);

        if (active) {
            if (fadeAlpha < 255) fadeAlpha += 5; // fade in
        } else {
            if (fadeAlpha > 0) fadeAlpha -= 5; // fade out
        }

        fadeAlpha = Math.max(0, Math.min(255, fadeAlpha));

        if (fadeAlpha > 0) {
            int width = client.getWindow().getScaledWidth();
            int height = client.getWindow().getScaledHeight();

            int color = (fadeAlpha << 24);
            drawContext.fill(0, 0, width, height, color);
        }

        if (fadeAlpha > 200) {
            ci.cancel();
        }
    }
}