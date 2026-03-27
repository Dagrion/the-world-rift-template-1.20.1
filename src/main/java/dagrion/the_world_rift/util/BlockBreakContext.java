package dagrion.the_world_rift.util;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/** Holds the block position currently being mined on this thread (server) for ray-protection hardness. */
public final class BlockBreakContext {

    private static final ThreadLocal<World> WORLD = new ThreadLocal<>();
    private static final ThreadLocal<BlockPos> POS = new ThreadLocal<>();

    private BlockBreakContext() {}

    public static void set(World world, BlockPos pos) {
        WORLD.set(world);
        POS.set(pos);
    }

    public static void clear() {
        WORLD.remove();
        POS.remove();
    }

    public static boolean isRayProtectedBlock() {
        World w = WORLD.get();
        BlockPos p = POS.get();
        return w != null && p != null && DungeonProtectionManager.isProtected(w, p);
    }
}
