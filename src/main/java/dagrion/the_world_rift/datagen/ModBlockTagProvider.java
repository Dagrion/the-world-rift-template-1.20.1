package dagrion.the_world_rift.datagen;

import dagrion.the_world_rift.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.BLOODSTAINED_BLOCK)
                .add(ModBlocks.BLOODSTEEL_BLOCK)
                .add(ModBlocks.ENCHANTED_DIAMOND_ORE)
                .add(ModBlocks.RUNED_BLACKSTONE_A)   .add(ModBlocks.RUNED_BLACKSTONE_B)   .add(ModBlocks.RUNED_BLACKSTONE_C)    .add(ModBlocks.RUNED_BLACKSTONE_D)
                .add(ModBlocks.RUNED_BLACKSTONE_E)   .add(ModBlocks.RUNED_BLACKSTONE_F)   .add(ModBlocks.RUNED_BLACKSTONE_G)    .add(ModBlocks.RUNED_BLACKSTONE_H)
                .add(ModBlocks.RUNED_BLACKSTONE_I)   .add(ModBlocks.RUNED_BLACKSTONE_J)   .add(ModBlocks.RUNED_BLACKSTONE_K)    .add(ModBlocks.RUNED_BLACKSTONE_L)
                .add(ModBlocks.RUNED_BLACKSTONE_M)   .add(ModBlocks.RUNED_BLACKSTONE_N)   .add(ModBlocks.RUNED_BLACKSTONE_O)    .add(ModBlocks.RUNED_BLACKSTONE_P)
                .add(ModBlocks.RUNED_BLACKSTONE_Q)   .add(ModBlocks.RUNED_BLACKSTONE_R)   .add(ModBlocks.RUNED_BLACKSTONE_S)    .add(ModBlocks.RUNED_BLACKSTONE_T)
                .add(ModBlocks.RUNED_BLACKSTONE_U)   .add(ModBlocks.RUNED_BLACKSTONE_V)   .add(ModBlocks.RUNED_BLACKSTONE_W)    .add(ModBlocks.RUNED_BLACKSTONE_X)
                .add(ModBlocks.RUNED_BLACKSTONE_Y)   .add(ModBlocks.RUNED_BLACKSTONE_Z)
                .add(ModBlocks.STEEL_BLOCK)          .add(ModBlocks.HAZARD_BLOCK)
                .add(ModBlocks.PLATE_BLOCK)
        ;

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ENCHANTED_DIAMOND_ORE)
                .add(ModBlocks.STEEL_BLOCK)
                .add(ModBlocks.HAZARD_BLOCK)
        ;

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.BLOODSTAINED_BLOCK)
                .add(ModBlocks.BLOODSTEEL_BLOCK)
                .add(ModBlocks.PLATE_BLOCK)
        ;

    }
}
