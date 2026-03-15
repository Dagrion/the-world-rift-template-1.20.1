package dagrion.the_world_rift.world.biome.custom;

import dagrion.the_world_rift.world.ModPlacedFeatures;
import dagrion.the_world_rift.world.biome.ModBiomes;
import dagrion.the_world_rift.world.vegetation.ModVegetationPlacedFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

public class BarrenWastlandBiome extends ModBiomes {

    public static Biome barrenWastland(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        biomeBuilder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, ModPlacedFeatures.BARREN_DELTA_1_PLACED);
        biomeBuilder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, ModPlacedFeatures.BARREN_DELTA_2_PLACED);

        DefaultBiomeFeatures.addMineables(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
        DefaultBiomeFeatures.addAncientDebris(biomeBuilder);


        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModVegetationPlacedFeatures.DEAD_TREE_PLACED);

        return new Biome.Builder()
                .precipitation(false)
                .downfall(0.4f)
                .temperature(0.8f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x771d1d)
                        .waterFogColor(0x291919)
                        .skyColor(0x0f0000)
                        .grassColor(0xbc9b62)
                        .foliageColor(0x9e814d)
                        .fogColor(0x050000)
                        .build())
                .build();
    }
}
