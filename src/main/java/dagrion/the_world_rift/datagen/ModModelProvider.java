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
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOODSTEEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENCHANTED_DIAMOND_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STEEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.HAZARD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PLATE_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_DUNGEON_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DUNGEON_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DUNGEON_CORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PORTAL_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUNED_BLACKSTONE_A);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUNED_BLACKSTONE_B);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUNED_BLACKSTONE_C);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUNED_BLACKSTONE_D);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUNED_BLACKSTONE_E);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUNED_BLACKSTONE_F);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUNED_BLACKSTONE_G);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUNED_BLACKSTONE_H);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUNED_BLACKSTONE_I);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUNED_BLACKSTONE_J);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUNED_BLACKSTONE_K);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUNED_BLACKSTONE_L);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUNED_BLACKSTONE_M);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUNED_BLACKSTONE_N);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUNED_BLACKSTONE_O);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUNED_BLACKSTONE_P);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUNED_BLACKSTONE_Q);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUNED_BLACKSTONE_R);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUNED_BLACKSTONE_S);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUNED_BLACKSTONE_T);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUNED_BLACKSTONE_U);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUNED_BLACKSTONE_V);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUNED_BLACKSTONE_W);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUNED_BLACKSTONE_X);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUNED_BLACKSTONE_Y);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUNED_BLACKSTONE_Z);





    }


    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.HALF_MOON, Models.HANDHELD);
        itemModelGenerator.register(ModItems.HYPERNOVA, Models.GENERATED);

        itemModelGenerator.register(ModItems.ANCIENT_TABLET, Models.GENERATED);
        itemModelGenerator.register(ModItems.SRBDV, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHARGER, Models.GENERATED);
        itemModelGenerator.register(ModItems.YEET, Models.GENERATED);

        itemModelGenerator.register(ModItems.DRAGON_HEART, Models.GENERATED);
        itemModelGenerator.register(ModItems.DARK_CLOTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHER_STAR_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHER_STAR_POWDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOODSTAINED_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOODSTEEL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMPTY_VIAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOOD_VIAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOOD_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.HARDENED_BLOOD_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_PLATE, Models.GENERATED);

        itemModelGenerator.register(ModItems.STINGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.ENCHANTED_CARROT, Models.GENERATED);

        itemModelGenerator.register(ModItems.CLAYMORE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SCYTHE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DUAL_BLADE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.HALBERD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.KNIFE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GLAIVE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.RUINED_BLOODSTAINED_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUINED_BLOODSTAINED_SCYTHE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUINED_BLOODSTAINED_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUINED_BLOODSTAINED_DUAL_BLADE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUINED_BLOODSTAINED_HALBERD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUINED_BLOODSTAINED_KNIFE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUINED_BLOODSTAINED_GLAIVE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.BLOODSTAINED_CLAYMORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOODSTAINED_SCYTHE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOODSTAINED_HAMMER, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOODSTAINED_DUAL_BLADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOODSTAINED_HALBERD, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOODSTAINED_KNIFE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOODSTAINED_GLAIVE, Models.GENERATED);

        itemModelGenerator.register(ModItems.BLOODSTAINED_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOODSTAINED_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOODSTAINED_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOODSTAINED_BOOTS, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOODSTEEL_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOODSTEEL_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOODSTEEL_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOODSTEEL_BOOTS, Models.GENERATED);

        itemModelGenerator.register(ModItems.BLOODSTAINED_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLOODSTAINED_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLOODSTAINED_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLOODSTAINED_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLOODSTAINED_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BORDER_BREAKER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLOODSTEEL_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLOODSTEEL_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLOODSTEEL_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLOODSTEEL_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLOODSTEEL_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FRONTIER_BREAKER, Models.HANDHELD);


        itemModelGenerator.register(ModItems.BLOOD_OF_THE_IMMORTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.DAGRION_HOOD, Models.GENERATED);
        itemModelGenerator.register(ModItems.DAGRION_VAMBRACES, Models.GENERATED);
        itemModelGenerator.register(ModItems.DAGRION_COAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.DAGRION_GREAVES, Models.GENERATED);





    }
}
