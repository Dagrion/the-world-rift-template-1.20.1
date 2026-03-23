package dagrion.the_world_rift;

import dagrion.the_world_rift.block.ModBlocks;
import dagrion.the_world_rift.entity.ModEntities;
import dagrion.the_world_rift.util.SaturationHudRenderer;
import dagrion.the_world_rift.util.ToughnessHudRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Items;
import net.minecraft.text.Text;

public class TheWorldRiftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DUNGEON_DOOR_FRAME, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DUNGEON_DOOR_KEYHOLE, RenderLayer.getTranslucent());

        EntityRendererRegistry.register(ModEntities.HYPERNOVA_PROJECTILE, FlyingItemEntityRenderer::new);

        // Armor Toughness Bar
        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            ToughnessHudRenderer.renderToughnessBar(drawContext);
        });
        // Saturation Bar
        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            SaturationHudRenderer.renderSaturationBar(drawContext);
        });
        // Hunger and Saturation on Food
        ItemTooltipCallback.EVENT.register((stack, context, lines) -> {
            if (stack.isFood()) {
                FoodComponent food = stack.getItem().getFoodComponent();
                if (food != null) {
                    int hunger = food.getHunger();
                    float saturation = hunger * food.getSaturationModifier() * 2;

                    lines.add(Text.literal("§6Hunger: +" + hunger));
                    lines.add(Text.literal("§eSaturation: +" + String.format("%.1f", saturation)));
                }
            }
            // Cake Food and Saturation
            if (stack.isOf(Items.CAKE)) {
                // Each slice of cake gives:
                int hunger = 2;
                float saturation = 2 * 0.1f * 2; // = 0.4
                lines.add(Text.literal("§7Per slice:"));
                lines.add(Text.literal("§6Hunger: +" + hunger));
                lines.add(Text.literal("§eSaturation: +" + String.format("%.1f", saturation)));
            }
        });
        // No Sprint when low Health
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;
            boolean lowHealth = client.player.getHealth() <= 6.0F;
            if (lowHealth) {
                client.player.setSprinting(false);
                client.options.sprintKey.setPressed(false);
            }
        });


    }
}
