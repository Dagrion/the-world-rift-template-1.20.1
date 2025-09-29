package dagrion.the_world_rift.datagen;

import dagrion.the_world_rift.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.BLOODSTAINED_BLOCK);

        addDrop(ModBlocks.ENCHANTED_DIAMOND_ORE, oreDrops(Blocks.DIAMOND_ORE, Items.DIAMOND_ORE));

    }
}
