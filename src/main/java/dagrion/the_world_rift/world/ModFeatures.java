package dagrion.the_world_rift.world;

import dagrion.the_world_rift.TheWorldRift;
import dagrion.the_world_rift.world.feature.DungeonCoreMultiblockFeature;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

public class ModFeatures {
    public static final Feature<DefaultFeatureConfig> DUNGEON_CORE_MULTIBLOCK = Registry.register(
            Registries.FEATURE,
            Identifier.of(TheWorldRift.MOD_ID, "dungeon_core_multiblock"),
            new DungeonCoreMultiblockFeature()
    );

    public static void register() {
        // Registration happens via the static initializer above
    }
}
