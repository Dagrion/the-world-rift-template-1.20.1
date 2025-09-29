package dagrion.the_world_rift.datagen;

import dagrion.the_world_rift.block.ModBlocks;
import dagrion.the_world_rift.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOODSTAINED_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENCHANTED_DIAMOND_ORE);


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BLOODSTAINED_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOOD_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMPTY_VIAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOOD_VIAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.STINGER, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHER_STAR_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHER_STAR_POWDER, Models.GENERATED);

        itemModelGenerator.register(ModItems.BLOODSTAINED_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOODSTAINED_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOODSTAINED_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOODSTAINED_BOOTS, Models.GENERATED);

        itemModelGenerator.register(ModItems.BORDER_BREAKER, Models.GENERATED);
        itemModelGenerator.register(ModItems.BROKEN_BLOODSTAINED_SWORD, Models.GENERATED);
        itemModelGenerator.register(ModItems.BROKEN_BLOODSTAINED_SCYTHE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BROKEN_BLOODSTAINED_HAMMER, Models.GENERATED);
        itemModelGenerator.register(ModItems.BROKEN_BLOODSTAINED_HALBERD, Models.GENERATED);
        itemModelGenerator.register(ModItems.BROKEN_BLOODSTAINED_DUAL_BLADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BROKEN_BLOODSTAINED_KNIFE, Models.GENERATED);

        itemModelGenerator.register(ModItems.BLOODSTAINED_SWORD, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRUE_BLOODSTAINED_SWORD, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOODSTAINED_SCYTHE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOODSTAINED_HAMMER, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOODSTAINED_HALBERD, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOODSTAINED_DUAL_BLADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOODSTAINED_KNIFE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HALF_MOON, Models.GENERATED);

        itemModelGenerator.register(ModItems.ANCIENT_TABLET, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOOD_MOON, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENCHANTED_CARROT, Models.GENERATED);

    }
}
