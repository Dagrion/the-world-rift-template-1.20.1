package dagrion.the_world_rift.world;

import dagrion.the_world_rift.TheWorldRift;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;

import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> BARREN_DELTA_1 = registerKey("barren_delta_1");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BARREN_DELTA_2 = registerKey("barren_delta_2");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PETRIFIED_DELTA_1 = registerKey("petrified_delta_1");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PETRIFIED_DELTA_2 = registerKey("petrified_delta_2");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DUNGEON_CORE_MULTIBLOCK = registerKey("dungeon_core_multiblock");


    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context){
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplacables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplacables = new BlockMatchRuleTest(Blocks.END_STONE);


        context.register(BARREN_DELTA_1,
                new ConfiguredFeature<>(Feature.DELTA_FEATURE, new DeltaFeatureConfig(
                                Blocks.COARSE_DIRT.getDefaultState(),   // contents
                                Blocks.ROOTED_DIRT.getDefaultState(),   // rim
                                UniformIntProvider.create(3, 7),        // size
                                UniformIntProvider.create(1, 4)         // rim size
                )));
        context.register(BARREN_DELTA_2,
                new ConfiguredFeature<>(Feature.DELTA_FEATURE, new DeltaFeatureConfig(
                        Blocks.DIRT.getDefaultState(),
                        Blocks.COARSE_DIRT.getDefaultState(),
                        UniformIntProvider.create(3, 12),
                        UniformIntProvider.create(2, 8)
                )));
        context.register(PETRIFIED_DELTA_1,
                new ConfiguredFeature<>(Feature.DELTA_FEATURE, new DeltaFeatureConfig(
                        Blocks.ANDESITE.getDefaultState(),
                        Blocks.TUFF.getDefaultState(),
                        UniformIntProvider.create(0, 4),
                        UniformIntProvider.create(3, 7)
                )));
        context.register(PETRIFIED_DELTA_2,
                new ConfiguredFeature<>(Feature.DELTA_FEATURE, new DeltaFeatureConfig(
                        Blocks.STONE.getDefaultState(),
                        Blocks.COBBLESTONE.getDefaultState(),
                        UniformIntProvider.create(0, 8),
                        UniformIntProvider.create(3, 14)
                )));
        context.register(DUNGEON_CORE_MULTIBLOCK,
                new ConfiguredFeature<>(ModFeatures.DUNGEON_CORE_MULTIBLOCK, DefaultFeatureConfig.INSTANCE));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(TheWorldRift.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
