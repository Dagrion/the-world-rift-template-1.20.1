package dagrion.the_world_rift.datagen;

import dagrion.the_world_rift.block.ModBlocks;
import dagrion.the_world_rift.util.ModTags;
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
                .add(ModBlocks.STEEL_BLOCK)          .add(ModBlocks.HAZARD_BLOCK)
                .add(ModBlocks.PLATE_BLOCK)

                .add(ModBlocks.DUNGEON_BRICKS)
                .add(ModBlocks.DUNGEON_DOOR_FRAME)      .add(ModBlocks.DUNGEON_DOOR_KEYHOLE)
                .add(ModBlocks.DUNGEON_CORE_RECEPTOR)   .add(ModBlocks.DUNGEON_CORE_TRANSMITTER)
                .add(ModBlocks.DUNGEON_CORE_HEART)
                .add(ModBlocks.DUNGEON_CORE_SHELL)
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

        getOrCreateTagBuilder(ModTags.Blocks.DUNGEON_BLOCK)
                .add(ModBlocks.CRACKED_DUNGEON_BRICKS)
                .add(ModBlocks.DUNGEON_BRICKS)
                .add(ModBlocks.DUNGEON_CORE)
                .add(ModBlocks.DUNGEON_DOOR_FRAME)
                .add(ModBlocks.DUNGEON_DOOR_KEYHOLE)
                .add(ModBlocks.DUNGEON_CORE_RECEPTOR)
                .add(ModBlocks.DUNGEON_CORE_TRANSMITTER)
                .add(ModBlocks.DUNGEON_CORE_HEART)
                .add(ModBlocks.DUNGEON_CORE_SHELL)
        ;

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.CRACKED_DUNGEON_BRICKS)
                .add(ModBlocks.DUNGEON_BRICKS)
                .add(ModBlocks.DUNGEON_CORE)
                .add(ModBlocks.DUNGEON_DOOR_FRAME)
                .add(ModBlocks.DUNGEON_DOOR_KEYHOLE)
                .add(ModBlocks.DUNGEON_CORE_RECEPTOR)
                .add(ModBlocks.DUNGEON_CORE_TRANSMITTER)
                .add(ModBlocks.DUNGEON_CORE_SHELL)
                .add(ModBlocks.DUNGEON_CORE_HEART)
        ;

    }
}
