package dagrion.the_world_rift.world.vegetation.tree;

import dagrion.the_world_rift.TheWorldRift;
import dagrion.the_world_rift.world.vegetation.tree.custom.AncientTreeTrunkPlacer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class ModTrunkPlacer {
    public static final TrunkPlacerType<AncientTreeTrunkPlacer> ANCIENT_TREE_TRUNK_PLACER =
            Registry.register(
                    Registries.TRUNK_PLACER_TYPE,
                    new Identifier("the_world_rift", "ancient_tree_trunk_placer"),
                    new TrunkPlacerType<>(AncientTreeTrunkPlacer.CODEC)
            );

    public static void register() {
        TheWorldRift.LOGGER.info("Registering Trunk Placers for " + TheWorldRift.MOD_ID);
    }
}
