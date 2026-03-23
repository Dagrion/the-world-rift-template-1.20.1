package dagrion.the_world_rift.world.feature;

import dagrion.the_world_rift.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

/**
 * Places a 3x3x3 multiblock: 1 dungeon_core_heart at center, 6 transmitters facing outward, 20 shells for the rest.
 */
public class DungeonCoreMultiblockFeature extends Feature<DefaultFeatureConfig> {

    public DungeonCoreMultiblockFeature() {
        super(DefaultFeatureConfig.CODEC);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos origin = context.getOrigin();

        BlockState core = ModBlocks.DUNGEON_CORE_HEART.getDefaultState();
        BlockState shell = ModBlocks.DUNGEON_CORE_SHELL.getDefaultState();

        for (int dx = 0; dx < 3; dx++) {
            for (int dy = 0; dy < 3; dy++) {
                for (int dz = 0; dz < 3; dz++) {
                    BlockPos pos = origin.add(dx, dy, dz);

                    if (dx == 1 && dy == 1 && dz == 1) {
                        world.setBlockState(pos, core, 3);
                        continue;
                    }
                    if (dx == 2 && dy == 1 && dz == 1) {
                        world.setBlockState(pos, transmitterWithFacing(Direction.EAST), 3);
                        continue;
                    }
                    if (dx == 0 && dy == 1 && dz == 1) {
                        world.setBlockState(pos, transmitterWithFacing(Direction.WEST), 3);
                        continue;
                    }
                    if (dx == 1 && dy == 2 && dz == 1) {
                        world.setBlockState(pos, transmitterWithFacing(Direction.UP), 3);
                        continue;
                    }
                    if (dx == 1 && dy == 0 && dz == 1) {
                        world.setBlockState(pos, transmitterWithFacing(Direction.DOWN), 3);
                        continue;
                    }
                    if (dx == 1 && dy == 1 && dz == 2) {
                        world.setBlockState(pos, transmitterWithFacing(Direction.SOUTH), 3);
                        continue;
                    }
                    if (dx == 1 && dy == 1 && dz == 0) {
                        world.setBlockState(pos, transmitterWithFacing(Direction.NORTH), 3);
                        continue;
                    }

                    world.setBlockState(pos, shell, 3);
                }
            }
        }

        return true;
    }

    private static BlockState transmitterWithFacing(Direction facing) {
        return ModBlocks.DUNGEON_CORE_TRANSMITTER.getDefaultState().with(Properties.FACING, facing);
    }
}
