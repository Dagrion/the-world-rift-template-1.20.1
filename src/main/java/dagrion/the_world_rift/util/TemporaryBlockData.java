package dagrion.the_world_rift.util;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

public class TemporaryBlockData {

    public final BlockPos pos;
    public final BlockState state;
    public final NbtCompound blockEntityNbt;
    public int ticksRemaining;

    public TemporaryBlockData(BlockPos pos, BlockState state, NbtCompound nbt, int delay) {
        this.pos = pos;
        this.state = state;
        this.blockEntityNbt = nbt;
        this.ticksRemaining = delay;
    }
}