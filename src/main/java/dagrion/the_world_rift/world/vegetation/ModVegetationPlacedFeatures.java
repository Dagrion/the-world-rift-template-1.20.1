package dagrion.the_world_rift.world.vegetation;

import dagrion.the_world_rift.TheWorldRift;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModVegetationPlacedFeatures {
    public static final RegistryKey<PlacedFeature> ANCIENT_TREE_LITTLE_PLACED = registerKey("ancient_tree_little_placed");
    public static final RegistryKey<PlacedFeature> ANCIENT_TREE_SMALL_PLACED = registerKey("ancient_tree_small_placed");
    public static final RegistryKey<PlacedFeature> ANCIENT_TREE_PLACED = registerKey("ancient_tree_placed");
    public static final RegistryKey<PlacedFeature> ANCIENT_TREE_BIG_PLACED = registerKey("ancient_tree_big_placed");
    public static final RegistryKey<PlacedFeature> ANCIENT_TREE_GREAT_PLACED = registerKey("ancient_tree_great_placed");

    public static final RegistryKey<PlacedFeature> TARNISHED_TREE_PLACED = registerKey("tarnished_tree_placed");
    public static final RegistryKey<PlacedFeature> DEAD_TREE_PLACED = registerKey("dead_tree_placed");


    public static void boostrap(Registerable<PlacedFeature> context){
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, ANCIENT_TREE_LITTLE_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModVegetationConfiguredFeatures.ANCIENT_TREE_LITTLE),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),
                        Blocks.SPRUCE_SAPLING));
        register(context, ANCIENT_TREE_SMALL_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModVegetationConfiguredFeatures.ANCIENT_TREE_SMALL),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(2,0.25f,2),
                        Blocks.SPRUCE_SAPLING));
        register(context, ANCIENT_TREE_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModVegetationConfiguredFeatures.ANCIENT_TREE),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(2,0.2f,1),
                        Blocks.SPRUCE_SAPLING));
        register(context, ANCIENT_TREE_BIG_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModVegetationConfiguredFeatures.ANCIENT_TREE_BIG),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),
                        Blocks.SPRUCE_SAPLING));
        register(context, ANCIENT_TREE_GREAT_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModVegetationConfiguredFeatures.ANCIENT_TREE_GREAT),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,1),
                        Blocks.SPRUCE_SAPLING));


        register(context, TARNISHED_TREE_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModVegetationConfiguredFeatures.TARNISHED_TREE),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(3,0.2f,2),
                        Blocks.OAK_SAPLING));
        register(context, DEAD_TREE_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModVegetationConfiguredFeatures.DEAD_TREE),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(0,0.2f,1),
                        Blocks.OAK_SAPLING));
    }



    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(TheWorldRift.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
