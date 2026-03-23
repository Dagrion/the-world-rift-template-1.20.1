package dagrion.the_world_rift.util;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.util.Identifier;
import net.minecraft.world.GameMode;

@Environment(EnvType.CLIENT)
    public class ToughnessHudRenderer {

    private static final Identifier TOUGHNESS =
            new Identifier("the_world_rift", "textures/gui/hud/toughness.png");

    public static void renderToughnessBar(DrawContext context) {
        MinecraftClient client = MinecraftClient.getInstance();

        // Basic checks
        if (client.player == null || client.options.hudHidden) return;

        // Hide in creative & spectator
        if (client.interactionManager == null) return;

        if (client.interactionManager.getCurrentGameMode() == GameMode.CREATIVE ||
                client.interactionManager.getCurrentGameMode() == GameMode.SPECTATOR) {
            return;
        }

        // Get toughness
        double toughnessValue = client.player.getAttributeValue(EntityAttributes.GENERIC_ARMOR_TOUGHNESS);

        // Convert to "armor-style" icons (2 toughness = 1 icon)
        int fullIcons = (int) (toughnessValue / 2);
        boolean hasHalf = (toughnessValue % 2) >= 1;

        // ArmorBar Position
        int centerX = client.getWindow().getScaledWidth() / 2;
        int x = centerX - 91;
        int y = client.getWindow().getScaledHeight() - 49;

        // Draw full icons
        for (int i = 0; i < fullIcons; i++) {
            context.drawTexture(
                    TOUGHNESS,
                    x + i * 8,
                    y,
                    0, 0,
                    9, 9,
                    18, 9      // texture size
            );
        }

        // Draw half icon
        if (hasHalf) {
            context.drawTexture(
                    TOUGHNESS,
                    x + fullIcons * 8,
                    y,
                    9, 0,
                    9, 9,
                    18, 9
            );
        }
    }
}

