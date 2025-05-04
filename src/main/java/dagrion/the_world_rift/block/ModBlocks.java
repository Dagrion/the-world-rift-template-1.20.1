package dagrion.the_world_rift.block;

import dagrion.the_world_rift.TheWorldRift;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block BLOODY_BLOCK = registerBlock("bloody_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(60.0F)
                    .requiresTool()
                    .sounds(BlockSoundGroup.NETHERITE)));

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
