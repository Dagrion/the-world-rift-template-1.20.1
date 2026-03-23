package dagrion.the_world_rift.world;

import dagrion.the_world_rift.TheWorldRift;
import dagrion.the_world_rift.world.vegetation.ModVegetationConfiguredFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> BARREN_DELTA_1_PLACED = registerKey("barren_delta_1_placed");
    public static final RegistryKey<PlacedFeature> BARREN_DELTA_2_PLACED = registerKey("barren_delta_2_placed");
    public static final RegistryKey<PlacedFeature> PETRIFIED_DELTA_1_PLACED = registerKey("petrified_delta_1_placed");
    public static final RegistryKey<PlacedFeature> PETRIFIED_DELTA_2_PLACED = registerKey("petrified_delta_2_placed");
    public static final RegistryKey<PlacedFeature> DUNGEON_CORE_MULTIBLOCK_PLACED = registerKey("dungeon_core_multiblock_placed");


    public static void boostrap(Registerable<PlacedFeature> context){
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        context.register(BARREN_DELTA_1_PLACED, new PlacedFeature(
                        configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BARREN_DELTA_1),
                        List.of(
                                CountPlacementModifier.of(40),
                                SquarePlacementModifier.of(),
                                HeightmapPlacementModifier.of(Heightmap.Type.WORLD_SURFACE),
                                BiomePlacementModifier.of()
                        )));
        context.register(BARREN_DELTA_2_PLACED, new PlacedFeature(
                configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BARREN_DELTA_1),
                List.of(
                        CountPlacementModifier.of(40),
                        SquarePlacementModifier.of(),
                        HeightmapPlacementModifier.of(Heightmap.Type.WORLD_SURFACE),
                        BiomePlacementModifier.of()
                )));
        context.register(PETRIFIED_DELTA_1_PLACED, new PlacedFeature(
                configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BARREN_DELTA_1),
                List.of(
                        CountPlacementModifier.of(40),
                        SquarePlacementModifier.of(),
                        HeightmapPlacementModifier.of(Heightmap.Type.WORLD_SURFACE),
                        BiomePlacementModifier.of()
                )));
        context.register(PETRIFIED_DELTA_2_PLACED, new PlacedFeature(
                configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BARREN_DELTA_1),
                List.of(
                        CountPlacementModifier.of(40),
                        SquarePlacementModifier.of(),
                        HeightmapPlacementModifier.of(Heightmap.Type.WORLD_SURFACE),
                        BiomePlacementModifier.of()
                )));
        context.register(DUNGEON_CORE_MULTIBLOCK_PLACED, new PlacedFeature(
                configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DUNGEON_CORE_MULTIBLOCK),
                List.of(
                        CountPlacementModifier.of(1),
                        SquarePlacementModifier.of(),
                        HeightmapPlacementModifier.of(Heightmap.Type.WORLD_SURFACE_WG),
                        BiomePlacementModifier.of()
                )));

    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(TheWorldRift.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
