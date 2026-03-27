package dagrion.the_world_rift.util;

import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * While a receptor is hit by a transmitter ray, all {@link ModTags.Blocks#DUNGEON_BLOCK} connected to
 * that receptor are treated as unbreakable (hardness -1) until the ray stops.
 */
public final class DungeonProtectionManager {

    private static final Map<World, Set<BlockPos>> PROTECTED = new WeakHashMap<>();

    public static void beginTick(ServerWorld world) {
        PROTECTED.put(world, new HashSet<>());
    }

    public static void addProtectedFromActiveRays(ServerWorld world, List<BlockPos> receptorPositions) {
        if (receptorPositions.isEmpty()) {
            return;
        }
        Set<BlockPos> out = PROTECTED.computeIfAbsent(world, w -> new HashSet<>());
        for (BlockPos receptor : receptorPositions) {
            floodFillDungeonBlocks(world, receptor.toImmutable(), out);
        }
    }

    private static void floodFillDungeonBlocks(ServerWorld world, BlockPos start, Set<BlockPos> out) {
        ArrayDeque<BlockPos> queue = new ArrayDeque<>();
        Set<BlockPos> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            BlockPos current = queue.poll();
            BlockState state = world.getBlockState(current);
            if (!state.isIn(ModTags.Blocks.DUNGEON_BLOCK)) {
                continue;
            }
            out.add(current.toImmutable());
            for (Direction d : Direction.values()) {
                BlockPos n = current.offset(d);
                if (visited.add(n.toImmutable())) {
                    queue.add(n.toImmutable());
                }
            }
        }
    }

    public static boolean isProtected(World world, BlockPos pos) {
        Set<BlockPos> set = PROTECTED.get(world);
        return set != null && set.contains(pos);
    }
}
