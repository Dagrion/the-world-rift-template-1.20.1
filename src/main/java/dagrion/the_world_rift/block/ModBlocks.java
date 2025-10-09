package dagrion.the_world_rift.block;

import dagrion.the_world_rift.TheWorldRift;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block BLOODSTAINED_BLOCK = registerBlock("bloodstained_block",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)
                    .mapColor(MapColor.DARK_RED)
            )
    );
    public static final Block BLOODSTEEL_BLOCK = registerBlock("bloodsteel_block",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)
                    .mapColor(MapColor.DARK_RED)
            )
    );
    public static final Block ENCHANTED_DIAMOND_ORE = registerBlock("enchanted_diamond_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE)
                    .mapColor(MapColor.LIGHT_BLUE)
            )
    );






    public static final Block ANCIENT_LIBRARY = registerBlock("ancient_library",
            new Block(FabricBlockSettings.copyOf(Blocks.BOOKSHELF)
                    .mapColor(MapColor.SPRUCE_BROWN)
            )
    );

    public static final Block CRACKED_DUNGEON_BRICKS = registerBlock("cracked_dungeon_bricks",
            new Block(FabricBlockSettings.create()
                    .strength(-1.0F,6.0F)
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .sounds(BlockSoundGroup.STONE)
            )
    );
    public static final Block DUNGEON_BRICKS = registerBlock("dungeon_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.BEDROCK)
                    .mapColor(MapColor.DEEPSLATE_GRAY)
            )
    );
    public static final Block DUNGEON_CORE = registerBlock("dungeon_core",
            new Block(FabricBlockSettings.copyOf(Blocks.BEDROCK)
                    .mapColor(MapColor.DEEPSLATE_GRAY)
            )
    );
    public static final Block PORTAL_BLOCK = registerBlock("portal_block",
            new Block(FabricBlockSettings.copyOf(Blocks.BEDROCK)
                    .mapColor(MapColor.DEEPSLATE_GRAY)
            )
    );

    public static final Block RUNED_BLACKSTONE_A = registerBlock("runed_blackstone_26", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE)));
    public static final Block RUNED_BLACKSTONE_B = registerBlock("runed_blackstone_25", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE)));
    public static final Block RUNED_BLACKSTONE_C = registerBlock("runed_blackstone_24", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE)));
    public static final Block RUNED_BLACKSTONE_D = registerBlock("runed_blackstone_23", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE)));
    public static final Block RUNED_BLACKSTONE_E = registerBlock("runed_blackstone_22", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE)));
    public static final Block RUNED_BLACKSTONE_F = registerBlock("runed_blackstone_21", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE)));
    public static final Block RUNED_BLACKSTONE_G = registerBlock("runed_blackstone_20", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE)));
    public static final Block RUNED_BLACKSTONE_H = registerBlock("runed_blackstone_19", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE)));
    public static final Block RUNED_BLACKSTONE_I = registerBlock("runed_blackstone_18", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE)));
    public static final Block RUNED_BLACKSTONE_J = registerBlock("runed_blackstone_17", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE)));
    public static final Block RUNED_BLACKSTONE_K = registerBlock("runed_blackstone_16", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE)));
    public static final Block RUNED_BLACKSTONE_L = registerBlock("runed_blackstone_15", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE)));
    public static final Block RUNED_BLACKSTONE_M = registerBlock("runed_blackstone_14", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE)));
    public static final Block RUNED_BLACKSTONE_N = registerBlock("runed_blackstone_13", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE)));
    public static final Block RUNED_BLACKSTONE_O = registerBlock("runed_blackstone_12", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE)));
    public static final Block RUNED_BLACKSTONE_P = registerBlock("runed_blackstone_11", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE)));
    public static final Block RUNED_BLACKSTONE_Q = registerBlock("runed_blackstone_10", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE)));
    public static final Block RUNED_BLACKSTONE_R = registerBlock("runed_blackstone_9", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE)));
    public static final Block RUNED_BLACKSTONE_S = registerBlock("runed_blackstone_8", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE)));
    public static final Block RUNED_BLACKSTONE_T = registerBlock("runed_blackstone_7", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE)));
    public static final Block RUNED_BLACKSTONE_U = registerBlock("runed_blackstone_6", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE)));
    public static final Block RUNED_BLACKSTONE_V = registerBlock("runed_blackstone_5", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE)));
    public static final Block RUNED_BLACKSTONE_W = registerBlock("runed_blackstone_4", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE)));
    public static final Block RUNED_BLACKSTONE_X = registerBlock("runed_blackstone_3", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE)));
    public static final Block RUNED_BLACKSTONE_Y = registerBlock("runed_blackstone_2", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE)));
    public static final Block RUNED_BLACKSTONE_Z = registerBlock("runed_blackstone_1", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE)));


    public static final Block WARNING_BLOCK = registerBlock("warning_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)
                    .sounds(BlockSoundGroup.NETHERITE)
            )
    );


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(TheWorldRift.MOD_ID, name), block);
    }

    private static BlockItem registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(TheWorldRift.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        TheWorldRift.LOGGER.info("Registering Mod Blocks for" + TheWorldRift.MOD_ID);
    }
}
