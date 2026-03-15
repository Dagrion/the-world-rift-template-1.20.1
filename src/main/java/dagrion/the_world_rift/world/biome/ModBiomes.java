package dagrion.the_world_rift.world.biome;

import dagrion.the_world_rift.TheWorldRift;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

import static dagrion.the_world_rift.world.biome.custom.AncientForestBiome.ancientForest;
import static dagrion.the_world_rift.world.biome.custom.BarrenWastlandBiome.barrenWastland;
import static dagrion.the_world_rift.world.biome.custom.ElderWoodsBiome.elderWoods;
import static dagrion.the_world_rift.world.biome.custom.PetrifiedMeadowBiome.petrifiedMeadow;
import static dagrion.the_world_rift.world.biome.custom.TarnishedGroveBiome.tarnishedGrove;

public class ModBiomes {
    public static final RegistryKey<Biome> ANCIENT_FOREST = RegistryKey.of(RegistryKeys.BIOME,
            new Identifier(TheWorldRift.MOD_ID,"ancient_forest"));
    public static final RegistryKey<Biome> ELDER_WOODS = RegistryKey.of(RegistryKeys.BIOME,
            new Identifier(TheWorldRift.MOD_ID,"elder_woods"));
    public static final RegistryKey<Biome> TARNISHED_GROVE = RegistryKey.of(RegistryKeys.BIOME,
            new Identifier(TheWorldRift.MOD_ID,"tarnished_grove"));
    public static final RegistryKey<Biome> PETRIFIED_MEADOW = RegistryKey.of(RegistryKeys.BIOME,
            new Identifier(TheWorldRift.MOD_ID,"petrified_meadow"));

    public static final RegistryKey<Biome> BARREN_WASTLAND = RegistryKey.of(RegistryKeys.BIOME,
            new Identifier(TheWorldRift.MOD_ID,"barren_wastland"));

    public static void boostrap(Registerable<Biome> context) {
        context.register(ANCIENT_FOREST, ancientForest(context));
        context.register(ELDER_WOODS, elderWoods(context));
        context.register(TARNISHED_GROVE, tarnishedGrove(context));
        context.register(PETRIFIED_MEADOW, petrifiedMeadow(context));

        context.register(BARREN_WASTLAND, barrenWastland(context));
    }

    public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder) {
        DefaultBiomeFeatures.addLandCarvers(builder);
        DefaultBiomeFeatures.addAmethystGeodes(builder);
        DefaultBiomeFeatures.addDungeons(builder);
        DefaultBiomeFeatures.addMineables(builder);
        DefaultBiomeFeatures.addSprings(builder);
        DefaultBiomeFeatures.addFrozenTopLayer(builder);
    }
}
