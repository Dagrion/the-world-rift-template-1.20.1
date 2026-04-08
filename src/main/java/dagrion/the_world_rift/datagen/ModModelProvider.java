package dagrion.the_world_rift.datagen;

import dagrion.the_world_rift.TheWorldRift;
import dagrion.the_world_rift.block.DungeonDoorFrameBlock;
import dagrion.the_world_rift.block.DungeonDoorKeyholeBlock;
import dagrion.the_world_rift.block.ModBlocks;
import dagrion.the_world_rift.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import com.google.gson.JsonElement;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.lang.reflect.Field;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.function.Consumer;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOODSTAINED_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOODSTEEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENCHANTED_DIAMOND_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PORTAL_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_DUNGEON_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DUNGEON_BRICKS);

        registerDungeonCoreReceptorTransmitterModels(blockStateModelGenerator);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DUNGEON_CORE_SHELL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DUNGEON_CORE_HEART);

        registerDungeonDoorModels(blockStateModelGenerator);


    }

    /**
     * Receptor and transmitter blocks have FACING with top texture on the facing direction.
     * Cube model: up=top, down/north/south/east/west=side. Blockstate rotates model per facing.
     */
    private void registerDungeonCoreReceptorTransmitterModels(BlockStateModelGenerator gen) {
        String modId = TheWorldRift.MOD_ID;
        Identifier receptorModel = Identifier.of(modId, "block/dungeon_core_receptor");
        Identifier transmitterModel = Identifier.of(modId, "block/dungeon_core_transmitter");

        try {
            Field modelField = BlockStateModelGenerator.class.getDeclaredField("modelCollector");
            modelField.setAccessible(true);
            @SuppressWarnings("unchecked")
            var modelCollector = (BiConsumer<Identifier, Supplier<JsonElement>>) modelField.get(gen);

            // Receptor: cube with top on up, side on others
            var receptorTexture = new TextureMap()
                    .put(TextureKey.UP, Identifier.of(modId, "block/dungeon_core_receptor_top"))
                    .put(TextureKey.DOWN, Identifier.of(modId, "block/dungeon_core_receptor_side"))
                    .put(TextureKey.NORTH, Identifier.of(modId, "block/dungeon_core_receptor_side"))
                    .put(TextureKey.SOUTH, Identifier.of(modId, "block/dungeon_core_receptor_side"))
                    .put(TextureKey.EAST, Identifier.of(modId, "block/dungeon_core_receptor_side"))
                    .put(TextureKey.WEST, Identifier.of(modId, "block/dungeon_core_receptor_side"))
                    .put(TextureKey.PARTICLE, Identifier.of(modId, "block/dungeon_core_receptor_side"));
            Models.CUBE.upload(receptorModel, receptorTexture, modelCollector);

            // Transmitter: cube with top on up, side on others
            var transmitterTexture = new TextureMap()
                    .put(TextureKey.UP, Identifier.of(modId, "block/dungeon_core_transmitter_top"))
                    .put(TextureKey.DOWN, Identifier.of(modId, "block/dungeon_core_transmitter_side"))
                    .put(TextureKey.NORTH, Identifier.of(modId, "block/dungeon_core_transmitter_side"))
                    .put(TextureKey.SOUTH, Identifier.of(modId, "block/dungeon_core_transmitter_side"))
                    .put(TextureKey.EAST, Identifier.of(modId, "block/dungeon_core_transmitter_side"))
                    .put(TextureKey.WEST, Identifier.of(modId, "block/dungeon_core_transmitter_side"))
                    .put(TextureKey.PARTICLE, Identifier.of(modId, "block/dungeon_core_transmitter_side"));
            Models.CUBE.upload(transmitterModel, transmitterTexture, modelCollector);

            Field blockStateField = BlockStateModelGenerator.class.getDeclaredField("blockStateCollector");
            blockStateField.setAccessible(true);
            @SuppressWarnings("unchecked")
            Consumer<BlockStateSupplier> blockStateCollector = (Consumer<BlockStateSupplier>) blockStateField.get(gen);

            var facingMap = BlockStateVariantMap.create(Properties.FACING)
                    .register(Direction.UP, BlockStateVariant.create().put(VariantSettings.MODEL, receptorModel))
                    .register(Direction.DOWN, BlockStateVariant.create().put(VariantSettings.MODEL, receptorModel).put(VariantSettings.X, VariantSettings.Rotation.R180))
                    .register(Direction.NORTH, BlockStateVariant.create().put(VariantSettings.MODEL, receptorModel).put(VariantSettings.X, VariantSettings.Rotation.R90))
                    .register(Direction.SOUTH, BlockStateVariant.create().put(VariantSettings.MODEL, receptorModel).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                    .register(Direction.EAST, BlockStateVariant.create().put(VariantSettings.MODEL, receptorModel).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                    .register(Direction.WEST, BlockStateVariant.create().put(VariantSettings.MODEL, receptorModel).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R270));

            var receptorSupplier = VariantsBlockStateSupplier.create(ModBlocks.DUNGEON_CORE_RECEPTOR).coordinate(facingMap);
            blockStateCollector.accept(receptorSupplier);

            var transmitterFacingMap = BlockStateVariantMap.create(Properties.FACING)
                    .register(Direction.UP, BlockStateVariant.create().put(VariantSettings.MODEL, transmitterModel))
                    .register(Direction.DOWN, BlockStateVariant.create().put(VariantSettings.MODEL, transmitterModel).put(VariantSettings.X, VariantSettings.Rotation.R180))
                    .register(Direction.NORTH, BlockStateVariant.create().put(VariantSettings.MODEL, transmitterModel).put(VariantSettings.X, VariantSettings.Rotation.R90))
                    .register(Direction.SOUTH, BlockStateVariant.create().put(VariantSettings.MODEL, transmitterModel).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                    .register(Direction.EAST, BlockStateVariant.create().put(VariantSettings.MODEL, transmitterModel).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                    .register(Direction.WEST, BlockStateVariant.create().put(VariantSettings.MODEL, transmitterModel).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R270));

            var transmitterSupplier = VariantsBlockStateSupplier.create(ModBlocks.DUNGEON_CORE_TRANSMITTER).coordinate(transmitterFacingMap);
            blockStateCollector.accept(transmitterSupplier);

            gen.registerParentedItemModel(ModBlocks.DUNGEON_CORE_RECEPTOR, receptorModel);
            gen.registerParentedItemModel(ModBlocks.DUNGEON_CORE_TRANSMITTER, transmitterModel);
        } catch (Exception e) {
            throw new RuntimeException("Failed to register dungeon core receptor/transmitter models", e);
        }
    }

    /**
     * Dungeon door blocks have open=true/false variants. BlockStateModelGenerator has no public
     * API for boolean property variants, so we use reflection to access blockStateCollector
     * and modelCollector, and VariantsBlockStateSupplier with BlockStateVariantMap.
     */
    private void registerDungeonDoorModels(BlockStateModelGenerator gen) {
        String modId = TheWorldRift.MOD_ID;
        Identifier frameModel = Identifier.of(modId, "block/dungeon_door_frame");
        Identifier frameTranslucent = Identifier.of(modId, "block/dungeon_door_frame_translucent");
        Identifier keyholeModel = Identifier.of(modId, "block/dungeon_door_keyhole");
        Identifier keyholeTranslucent = Identifier.of(modId, "block/dungeon_door_keyhole_translucent");

        try {
            Field modelField = BlockStateModelGenerator.class.getDeclaredField("modelCollector");
            modelField.setAccessible(true);
            @SuppressWarnings("unchecked")
            var modelCollector = (BiConsumer<Identifier, Supplier<JsonElement>>) modelField.get(gen);

            // Base models (cube_all with block texture)
            var frameTexture = TextureMap.all(Identifier.of(modId, "block/dungeon_door_frame"));
            var keyholeTexture = TextureMap.all(Identifier.of(modId, "block/dungeon_door_keyhole"));
            Models.CUBE_ALL.upload(frameModel, frameTexture, modelCollector);
            Models.CUBE_ALL.upload(keyholeModel, keyholeTexture, modelCollector);

            // Translucent models (gray_stained_glass)
            var glassTexture = TextureMap.all(Identifier.of("minecraft", "block/gray_stained_glass"));
            Models.CUBE_ALL.upload(frameTranslucent, glassTexture, modelCollector);
            Models.CUBE_ALL.upload(keyholeTranslucent, glassTexture, modelCollector);

            Field blockStateField = BlockStateModelGenerator.class.getDeclaredField("blockStateCollector");
            blockStateField.setAccessible(true);
            @SuppressWarnings("unchecked")
            Consumer<BlockStateSupplier> blockStateCollector = (Consumer<BlockStateSupplier>) blockStateField.get(gen);

            var frameSupplier = VariantsBlockStateSupplier.create(ModBlocks.DUNGEON_DOOR_FRAME)
                    .coordinate(BlockStateVariantMap.create(DungeonDoorFrameBlock.OPEN)
                            .register(false, BlockStateVariant.create().put(VariantSettings.MODEL, frameModel))
                            .register(true, BlockStateVariant.create().put(VariantSettings.MODEL, frameTranslucent)));
            var keyholeSupplier = VariantsBlockStateSupplier.create(ModBlocks.DUNGEON_DOOR_KEYHOLE)
                    .coordinate(BlockStateVariantMap.create(DungeonDoorKeyholeBlock.OPEN)
                            .register(false, BlockStateVariant.create().put(VariantSettings.MODEL, keyholeModel))
                            .register(true, BlockStateVariant.create().put(VariantSettings.MODEL, keyholeTranslucent)));

            blockStateCollector.accept(frameSupplier);
            blockStateCollector.accept(keyholeSupplier);

            gen.registerParentedItemModel(ModBlocks.DUNGEON_DOOR_FRAME, frameModel);
            gen.registerParentedItemModel(ModBlocks.DUNGEON_DOOR_KEYHOLE, keyholeModel);
        } catch (Exception e) {
            throw new RuntimeException("Failed to register dungeon door models", e);
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.HALF_MOON, Models.HANDHELD);
        itemModelGenerator.register(ModItems.HYPERNOVA, Models.GENERATED);

        itemModelGenerator.register(ModItems.SRBDV, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHARGER, Models.GENERATED);

        itemModelGenerator.register(ModItems.DUNGEON_KEY, Models.GENERATED);

        itemModelGenerator.register(ModItems.NETHER_STAR_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHER_STAR_POWDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOODSTAINED_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOODSTEEL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMPTY_VIAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOOD_VIAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOOD_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.HARDENED_BLOOD_CRYSTAL, Models.GENERATED);

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

    }
}
