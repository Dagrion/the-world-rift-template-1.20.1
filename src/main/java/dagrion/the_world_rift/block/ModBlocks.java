package dagrion.the_world_rift.block;

import dagrion.the_world_rift.TheWorldRift;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block BLOODSTAINED_BLOCK = registerBlock("bloody_block",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.DARK_RED).strength(60.0F).requiresTool().sounds(BlockSoundGroup.NETHERITE)));
    public static final Block ENCHANTED_DIAMOND_ORE = registerBlock("enchanted_diamond_ore",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).strength(5.0F).requiresTool().sounds(BlockSoundGroup.STONE)));








    public static final Block ANCIENT_LIBRARY = registerBlock("ancient_library",
            new Block(FabricBlockSettings.create()
                    .mapColor(MapColor.SPRUCE_BROWN)
                    .strength(10000.0F)
                    .requiresTool()
                    .sounds(BlockSoundGroup.NETHER_WOOD)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .nonOpaque()
            )
    );

    public static final Block DUNGEON_BRICKS = registerBlock("dungeon_bricks",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .strength(-1.0F, 3600000.0F)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)
                    .pistonBehavior(PistonBehavior.BLOCK)
            )
    );
    public static final Block PORTAL_BLOCK = registerBlock("portal_block",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .strength(-1.0F, 3600000.0F)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool().pistonBehavior(PistonBehavior.BLOCK)
            )
    );

    public static final Block BLACKSTONE_LETTER_A = registerBlock("blackstone_letter_a",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).strength(1.5F, 6.0F).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BLACKSTONE_LETTER_B = registerBlock("blackstone_letter_b",
            new Block(AbstractBlock.Settings.create().strength(1.5F, 6.0F).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BLACKSTONE_LETTER_C = registerBlock("blackstone_letter_c",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).strength(1.5F, 6.0F).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BLACKSTONE_LETTER_D = registerBlock("blackstone_letter_d",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).strength(1.5F, 6.0F).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BLACKSTONE_LETTER_E = registerBlock("blackstone_letter_e",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).strength(1.5F, 6.0F).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BLACKSTONE_LETTER_F = registerBlock("blackstone_letter_f",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).strength(1.5F, 6.0F).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BLACKSTONE_LETTER_G = registerBlock("blackstone_letter_g",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).strength(1.5F, 6.0F).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BLACKSTONE_LETTER_H = registerBlock("blackstone_letter_h",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).strength(1.5F, 6.0F).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BLACKSTONE_LETTER_I = registerBlock("blackstone_letter_i",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).strength(1.5F, 6.0F).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BLACKSTONE_LETTER_J = registerBlock("blackstone_letter_j",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).strength(1.5F, 6.0F).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BLACKSTONE_LETTER_K = registerBlock("blackstone_letter_k",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).strength(1.5F, 6.0F).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BLACKSTONE_LETTER_L = registerBlock("blackstone_letter_l",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).strength(1.5F, 6.0F).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BLACKSTONE_LETTER_M = registerBlock("blackstone_letter_m",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).strength(1.5F, 6.0F).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BLACKSTONE_LETTER_N = registerBlock("blackstone_letter_n",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).strength(1.5F, 6.0F).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BLACKSTONE_LETTER_O = registerBlock("blackstone_letter_o",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).strength(1.5F, 6.0F).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BLACKSTONE_LETTER_P = registerBlock("blackstone_letter_p",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).strength(1.5F, 6.0F).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BLACKSTONE_LETTER_Q = registerBlock("blackstone_letter_q",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).strength(1.5F, 6.0F).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BLACKSTONE_LETTER_R = registerBlock("blackstone_letter_r",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).strength(1.5F, 6.0F).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BLACKSTONE_LETTER_S = registerBlock("blackstone_letter_s",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).strength(1.5F, 6.0F).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BLACKSTONE_LETTER_T = registerBlock("blackstone_letter_t",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).strength(1.5F, 6.0F).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BLACKSTONE_LETTER_U = registerBlock("blackstone_letter_u",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).strength(1.5F, 6.0F).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BLACKSTONE_LETTER_V = registerBlock("blackstone_letter_v",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).strength(1.5F, 6.0F).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BLACKSTONE_LETTER_W = registerBlock("blackstone_letter_w",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).strength(1.5F, 6.0F).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BLACKSTONE_LETTER_X = registerBlock("blackstone_letter_x",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).strength(1.5F, 6.0F).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BLACKSTONE_LETTER_Y = registerBlock("blackstone_letter_y",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).strength(1.5F, 6.0F).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BLACKSTONE_LETTER_Z = registerBlock("blackstone_letter_z",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).strength(1.5F, 6.0F).requiresTool().sounds(BlockSoundGroup.STONE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TheWorldRift.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TheWorldRift.MOD_ID, name),
                new BlockItem(block, new Item.Settings().fireproof()));
    }

    public static void registerModBlocks(){
        TheWorldRift.LOGGER.info("Registering Mod Blocks for" + TheWorldRift.MOD_ID);
    }
}
