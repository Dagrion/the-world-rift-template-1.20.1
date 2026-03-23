package dagrion.the_world_rift.block;

import dagrion.the_world_rift.TheWorldRift;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
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
                    .mapColor(MapColor.GRAY)
            )
    );
    public static final Block ENCHANTED_DIAMOND_ORE = registerBlock("enchanted_diamond_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE)
            )
    );






    public static final Block ANCIENT_LIBRARY = registerBlock("ancient_library",
            new Block(FabricBlockSettings.copyOf(Blocks.BOOKSHELF)
                    .mapColor(MapColor.SPRUCE_BROWN)
            )
    );

    // Dungeon blocks: hardness/resistance like deepslate (3, 6)
    private static FabricBlockSettings dungeonBlockSettings() {
        return FabricBlockSettings.copyOf(Blocks.DEEPSLATE);
    }

    public static final Block CRACKED_DUNGEON_BRICKS = registerBlock("cracked_dungeon_bricks",
            new Block(dungeonBlockSettings()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .sounds(BlockSoundGroup.STONE)
            )
    );
    public static final Block DUNGEON_BRICKS = registerBlock("dungeon_bricks",
            new Block(dungeonBlockSettings()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
            )
    );
    public static final Block DUNGEON_CORE = registerBlock("dungeon_core",
            new Block(dungeonBlockSettings()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
            )
    );

    public static final Block DUNGEON_DOOR_FRAME = registerBlock("dungeon_door_frame",
            new dagrion.the_world_rift.block.DungeonDoorFrameBlock(dungeonBlockSettings()
                    .mapColor(MapColor.SPRUCE_BROWN)
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
            )
    );
    public static final Block DUNGEON_DOOR_KEYHOLE = registerBlock("dungeon_door_keyhole",
            new dagrion.the_world_rift.block.DungeonDoorKeyholeBlock(dungeonBlockSettings()
                    .mapColor(MapColor.SPRUCE_BROWN)
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
            )
    );

    public static final Block DUNGEON_CORE_RECEPTOR = registerBlock("dungeon_core_receptor",
            new dagrion.the_world_rift.block.DungeonCoreReceptorBlock(dungeonBlockSettings()
                    .mapColor(MapColor.SPRUCE_BROWN)
                    .sounds(BlockSoundGroup.STONE)
            )
    );
    public static final Block DUNGEON_CORE_TRANSMITTER = registerBlock("dungeon_core_transmitter",
            new dagrion.the_world_rift.block.DungeonCoreTransmitterBlock(dungeonBlockSettings()
                    .mapColor(MapColor.SPRUCE_BROWN)
                    .sounds(BlockSoundGroup.STONE)
            )
    );
    public static final Block DUNGEON_CORE_SHELL = registerBlock("dungeon_core_shell",
            new Block(dungeonBlockSettings()
                    .mapColor(MapColor.STONE_GRAY)
                    .sounds(BlockSoundGroup.STONE)
            )
    );
    public static final Block DUNGEON_CORE_HEART = registerBlock("dungeon_core_heart",
            new dagrion.the_world_rift.block.DungeonCoreHeartBlock(dungeonBlockSettings()
                    .mapColor(MapColor.TERRACOTTA_RED)
                    .sounds(BlockSoundGroup.STONE)
            )
    );

    public static final Block PORTAL_BLOCK = registerBlock("portal_block",
            new Block(FabricBlockSettings.copyOf(Blocks.BEDROCK)
                    .mapColor(MapColor.DEEPSLATE_GRAY)
            )
    );

    public static final Block HAZARD_BLOCK = registerBlock("hazard_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)
                    .strength(5.0F,12000.0F)
                    .sounds(BlockSoundGroup.NETHERITE)
                    .mapColor(MapColor.YELLOW)
            )
    );
    public static final Block STEEL_BLOCK = registerBlock("steel_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)
                    .strength(5.0F,12000.0F)
                    .sounds(BlockSoundGroup.NETHERITE)
            )
    );
    public static final Block PLATE_BLOCK = registerBlock("plate_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)
                    .strength(50.0F,12000.0F)
                    .pistonBehavior(PistonBehavior.BLOCK)
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
