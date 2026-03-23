package dagrion.the_world_rift.util;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.Identifier;
import net.minecraft.world.GameMode;

@Environment(EnvType.CLIENT)
    public class SaturationHudRenderer {

    private static final Identifier SATURATION =
            new Identifier("the_world_rift", "textures/gui/hud/saturation.png");

    public static void renderSaturationBar(DrawContext context) {
        MinecraftClient client = MinecraftClient.getInstance();

        // Basic checks
        if (client.player == null || client.options.hudHidden) return;

        // Hide in creative & spectator
        if (client.interactionManager == null) return;

        if (client.interactionManager.getCurrentGameMode() == GameMode.CREATIVE ||
                client.interactionManager.getCurrentGameMode() == GameMode.SPECTATOR) {
            return;
        }

        // Get saturation
        float saturationValue = client.player.getHungerManager().getSaturationLevel();

        // Convert to "armor-style" icons (2 toughness = 1 icon)
        int fullIcons = (int) (saturationValue / 2);
        boolean hasHalf = (saturationValue % 2) >= 1;

        // FoodBar Position
        int centerX = client.getWindow().getScaledWidth() / 2;
        int x = centerX + 10;
        int y = client.getWindow().getScaledHeight() - 39;

        // Rightmost position of the bar
        int maxIcons = 10; // max saturation icons
        int rightX = x + maxIcons * 8; // x = left edge of the bar, maxIcons = max saturation icons

        // Draw full icons
        for (int i = 0; i < fullIcons; i++) {
            context.drawTexture(
                    SATURATION,
                    rightX - (i + 1) * 8, // move left from the right edge
                    y,
                    0, 0,
                    9, 9,
                    18, 9
            );
        }

// Draw half icon
        if (hasHalf) {
            context.drawTexture(
                    SATURATION,
                    rightX - (fullIcons + 1) * 8,
                    y,
                    9, 0,
                    9, 9,
                    18, 9
            );
        }
    }
}
