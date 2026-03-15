package dagrion.the_world_rift.world.vegetation;

import com.google.common.collect.ImmutableList;
import dagrion.the_world_rift.TheWorldRift;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.foliage.MegaPineFoliagePlacer;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.AlterGroundTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.trunk.GiantTrunkPlacer;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class ModVegetationConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> ANCIENT_TREE_LITTLE = registerKey("ancient_tree_little");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ANCIENT_TREE_SMALL = registerKey("ancient_tree_small");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ANCIENT_TREE = registerKey("ancient_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ANCIENT_TREE_BIG = registerKey("ancient_tree_big");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ANCIENT_TREE_GREAT = registerKey("ancient_tree_great");

    public static final RegistryKey<ConfiguredFeature<?, ?>> TARNISHED_TREE = registerKey("tarnished_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DEAD_TREE = registerKey("dead_tree");


    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context){

        register(context, ANCIENT_TREE_LITTLE, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.SPRUCE_WOOD),
                new StraightTrunkPlacer(5,0,5),
                BlockStateProvider.of(Blocks.SPRUCE_LEAVES),
                new SpruceFoliagePlacer(UniformIntProvider.create(2, 3), UniformIntProvider.create(0, 2), UniformIntProvider.create(1, 2)),
                new TwoLayersFeatureSize(1,0,2)).build());
        register(context, ANCIENT_TREE_SMALL, Feature.TREE, (new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.SPRUCE_WOOD),
                new GiantTrunkPlacer(15, 0, 10),
                BlockStateProvider.of(Blocks.SPRUCE_LEAVES),
                new MegaPineFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), UniformIntProvider.create(5, 9)),
                new TwoLayersFeatureSize(1, 1, 2)))
                .decorators(ImmutableList.of(new AlterGroundTreeDecorator(BlockStateProvider.of(Blocks.PODZOL)))).build());
        register(context, ANCIENT_TREE, Feature.TREE, (new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.SPRUCE_WOOD),
                new GiantTrunkPlacer(20, 0, 10),
                BlockStateProvider.of(Blocks.SPRUCE_LEAVES),
                new MegaPineFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), UniformIntProvider.create(9, 14)),
                new TwoLayersFeatureSize(1, 1, 2)))
                .decorators(ImmutableList.of(new AlterGroundTreeDecorator(BlockStateProvider.of(Blocks.PODZOL)))).build());
        register(context, ANCIENT_TREE_BIG, Feature.TREE, (new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.SPRUCE_WOOD),
                new GiantTrunkPlacer(24, 0, 15),
                BlockStateProvider.of(Blocks.SPRUCE_LEAVES),
                new MegaPineFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), UniformIntProvider.create(14, 19)),
                new TwoLayersFeatureSize(1, 1, 2)))
                .decorators(ImmutableList.of(new AlterGroundTreeDecorator(BlockStateProvider.of(Blocks.PODZOL)))).build());
        register(context, ANCIENT_TREE_GREAT, Feature.TREE, (new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.SPRUCE_WOOD),
                new GiantTrunkPlacer(24, 15, 24),
                BlockStateProvider.of(Blocks.SPRUCE_LEAVES),
                new MegaPineFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), UniformIntProvider.create(19, 24)),
                new TwoLayersFeatureSize(1, 1, 2)))
                .decorators(ImmutableList.of(new AlterGroundTreeDecorator(BlockStateProvider.of(Blocks.PODZOL)))).build());


        register(context, TARNISHED_TREE,Feature.TREE, (new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.OAK_WOOD),
                new LargeOakTrunkPlacer(3, 11, 0),
            //ROOT PROVIDER MISSING
                BlockStateProvider.of(Blocks.OAK_LEAVES),
                new LargeOakFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0),4),
                new TwoLayersFeatureSize(1, 1, 2)))
                .decorators(ImmutableList.of(new LeavesVineTreeDecorator(0.125f))).build());

        register(context, DEAD_TREE,Feature.TREE, (new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.OAK_WOOD),
                new LargeOakTrunkPlacer(3, 11, 0),
                BlockStateProvider.of(Blocks.AIR),
                new LargeOakFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), 4),
                new TwoLayersFeatureSize(1, 1, 2)))
                .build());
    }




    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(TheWorldRift.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
