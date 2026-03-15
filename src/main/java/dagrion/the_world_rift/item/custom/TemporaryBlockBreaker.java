package dagrion.the_world_rift.item.custom;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TemporaryBlockBreaker extends Item {

    private static final int RESTORE_DELAY = 100; // 5 seconds
    private static final List<TemporaryBlockData> TEMP_BLOCKS = new ArrayList<>();

    public TemporaryBlockBreaker(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        if (world.isClient || !(world instanceof ServerWorld serverWorld)) {
            return ActionResult.SUCCESS;
        }
        BlockState state = world.getBlockState(pos);
        if (state.isAir()) return ActionResult.PASS;
        BlockEntity blockEntity = world.getBlockEntity(pos);
        // Save NBT BEFORE removal
        NbtCompound nbt = null;
        if (blockEntity != null) {
            nbt = blockEntity.createNbtWithId();
        }
        // Store block data
        TEMP_BLOCKS.add(new TemporaryBlockData(
                serverWorld.getRegistryKey(),
                pos.toImmutable(),
                state,
                nbt,
                RESTORE_DELAY
        ));
        // Remove block WITHOUT triggering drops
        serverWorld.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);
        return ActionResult.SUCCESS;
    }

    /* ------------------------------------------------ */
    /* RESTORE LOGIC                                   */
    /* ------------------------------------------------ */
    public static void registerTickEvent() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            Iterator<TemporaryBlockData> iterator = TEMP_BLOCKS.iterator();
            while (iterator.hasNext()) {
                TemporaryBlockData data = iterator.next();
                data.tick();
                if (data.shouldRestore()) {
                    ServerWorld world = server.getWorld(data.getWorldKey());
                    if (world != null && world.isAir(data.getPos())) {
                        world.setBlockState(
                                data.getPos(),
                                data.getState(),
                                Block.NOTIFY_ALL
                        );
                        if (data.getBlockEntityNbt() != null) {
                            BlockEntity newBlockEntity =
                                    world.getBlockEntity(data.getPos());
                            if (newBlockEntity != null) {
                                newBlockEntity.readNbt(data.getBlockEntityNbt());
                                newBlockEntity.markDirty();
                            }
                        }
                    }
                    iterator.remove();
                }
            }
        });
    }

    /* ------------------------------------------------ */
    /* DATA CLASS                                       */
    /* ------------------------------------------------ */
    private static class TemporaryBlockData {
        private final RegistryKey<World> worldKey;
        private final BlockPos pos;
        private final BlockState state;
        private final NbtCompound blockEntityNbt;
        private int ticksRemaining;
        public TemporaryBlockData(RegistryKey<World> worldKey,
                                  BlockPos pos,
                                  BlockState state,
                                  NbtCompound nbt,
                                  int delay) {
            this.worldKey = worldKey;
            this.pos = pos;
            this.state = state;
            this.blockEntityNbt = nbt;
            this.ticksRemaining = delay;
        }
        public void tick() {
            ticksRemaining--;
        }
        public boolean shouldRestore() {
            return ticksRemaining <= 0;
        }
        public RegistryKey<World> getWorldKey() { return worldKey; }
        public BlockPos getPos() { return pos; }
        public BlockState getState() { return state; }
        public NbtCompound getBlockEntityNbt() { return blockEntityNbt; }
    }
}