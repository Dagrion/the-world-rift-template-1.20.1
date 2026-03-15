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

public class PetrifiedMeadowBiome extends ModBiomes {

    public static Biome petrifiedMeadow(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        biomeBuilder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, ModPlacedFeatures.PETRIFIED_DELTA_1_PLACED);
        biomeBuilder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, ModPlacedFeatures.PETRIFIED_DELTA_2_PLACED);


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
                        .grassColor(0xa7a79a)
                        .foliageColor(0x878573)
                        .fogColor(0xc0d8ff)
                        .build())
                .build();
    }
}
