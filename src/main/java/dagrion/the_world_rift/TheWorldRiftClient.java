package dagrion.the_world_rift;

import dagrion.the_world_rift.entity.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class TheWorldRiftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.HYPERNOVA_PROJECTILE, FlyingItemEntityRenderer::new);

    }
}
