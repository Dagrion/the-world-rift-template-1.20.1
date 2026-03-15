package dagrion.the_world_rift.world.biome.custom;

import dagrion.the_world_rift.world.biome.ModBiomes;
import dagrion.the_world_rift.world.vegetation.ModVegetationPlacedFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;

public class AncientForestBiome extends ModBiomes {

    public static Biome ancientForest(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        RegistryEntryLookup<PlacedFeature> placedLookup =
                context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        DefaultBiomeFeatures.addMossyRocks(biomeBuilder);

        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, placedLookup.getOrThrow(ModVegetationPlacedFeatures.ANCIENT_TREE_LITTLE_PLACED));
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, placedLookup.getOrThrow(ModVegetationPlacedFeatures.ANCIENT_TREE_SMALL_PLACED));
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, placedLookup.getOrThrow(ModVegetationPlacedFeatures.ANCIENT_TREE_PLACED));
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, placedLookup.getOrThrow(ModVegetationPlacedFeatures.ANCIENT_TREE_BIG_PLACED));
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, placedLookup.getOrThrow(ModVegetationPlacedFeatures.ANCIENT_TREE_GREAT_PLACED));
        DefaultBiomeFeatures.addForestFlowers(biomeBuilder);
        DefaultBiomeFeatures.addLargeFerns(biomeBuilder);
        DefaultBiomeFeatures.addGiantTaigaGrass(biomeBuilder);
        DefaultBiomeFeatures.addTaigaGrass(biomeBuilder);

        DefaultBiomeFeatures.addDefaultMushrooms(biomeBuilder);
        DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);
        DefaultBiomeFeatures.addPlainsTallGrass(biomeBuilder);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.4f)
                .temperature(0.8f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x3f76e4)
                        .waterFogColor(0x050533)
                        .skyColor(0x7da3ff)
                        .grassColor(0x5eb06f)
                        .foliageColor(0x348344)
                        .fogColor(0xc0d8ff)
                        .build())
                .build();
    }
}
