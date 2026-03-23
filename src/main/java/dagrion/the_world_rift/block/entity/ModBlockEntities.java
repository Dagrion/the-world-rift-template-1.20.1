package dagrion.the_world_rift.block.entity;

import dagrion.the_world_rift.TheWorldRift;
import dagrion.the_world_rift.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<DungeonCoreHeartBlockEntity> DUNGEON_CORE_HEART =
            Registry.register(Registries.BLOCK_ENTITY_TYPE,
                    Identifier.of(TheWorldRift.MOD_ID, "dungeon_core_heart"),
                    FabricBlockEntityTypeBuilder.create(DungeonCoreHeartBlockEntity::new, ModBlocks.DUNGEON_CORE_HEART).build());

    public static void register() {
        // Registration happens via static initializer above
    }
}
