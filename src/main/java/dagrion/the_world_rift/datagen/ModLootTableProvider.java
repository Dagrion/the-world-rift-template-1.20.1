package dagrion.the_world_rift.datagen;

import dagrion.the_world_rift.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.predicate.item.ItemPredicate;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    /** Drops the block only when mined with a netherite pickaxe. */
    private void addDungeonBlockDrop(Block block) {
        addDrop(block, LootTable.builder()
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(MatchToolLootCondition.builder(
                                ItemPredicate.Builder.create().items(Items.NETHERITE_PICKAXE)))
                        .with(ItemEntry.builder(block))
                        .build()));
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.BLOODSTAINED_BLOCK);
        addDrop(ModBlocks.BLOODSTEEL_BLOCK);

        addDrop(ModBlocks.ENCHANTED_DIAMOND_ORE, oreDrops(Blocks.DIAMOND_ORE, Items.DIAMOND));

        // Dungeon blocks: only drop loot when mined with netherite pickaxe
        addDungeonBlockDrop(ModBlocks.CRACKED_DUNGEON_BRICKS);
        addDungeonBlockDrop(ModBlocks.DUNGEON_BRICKS);
        addDungeonBlockDrop(ModBlocks.DUNGEON_DOOR_FRAME);
        addDungeonBlockDrop(ModBlocks.DUNGEON_DOOR_KEYHOLE);
        addDungeonBlockDrop(ModBlocks.DUNGEON_CORE_RECEPTOR);
        addDungeonBlockDrop(ModBlocks.DUNGEON_CORE_TRANSMITTER);
        addDungeonBlockDrop(ModBlocks.DUNGEON_CORE_SHELL);
        addDungeonBlockDrop(ModBlocks.DUNGEON_CORE_HEART);
    }
}
