package dagrion.the_world_rift.block;

import dagrion.the_world_rift.item.ModItems;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.block.ShapeContext;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.*;

public class DungeonDoorKeyholeBlock extends Block {
    public static final BooleanProperty OPEN = BooleanProperty.of("open");
    private static final int RESTORE_DELAY_TICKS = 200; // 10 seconds
    private static final List<DungeonDoorRestoreGroup> RESTORE_QUEUE = new ArrayList<>();

    public DungeonDoorKeyholeBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(OPEN, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(OPEN);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(OPEN) ? VoxelShapes.empty() : super.getCollisionShape(state, world, pos, context);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient || !(world instanceof ServerWorld serverWorld)) {
            return ActionResult.SUCCESS;
        }
        ItemStack stack = player.getStackInHand(hand);
        if (!stack.isOf(ModItems.DUNGEON_KEY)) {
            return ActionResult.PASS;
        }
        Set<BlockPos> connected = findConnectedBlocks(serverWorld, pos);
        if (connected.isEmpty()) {
            return ActionResult.PASS;
        }
        List<BlockPos> opened = new ArrayList<>();
        for (BlockPos p : connected) {
            BlockState s = serverWorld.getBlockState(p);
            if ((s.getBlock() == ModBlocks.DUNGEON_DOOR_FRAME || s.getBlock() == ModBlocks.DUNGEON_DOOR_KEYHOLE)
                    && !s.get(OPEN)) {
                serverWorld.setBlockState(p, s.with(getOpenProperty(s.getBlock()), true), Block.NOTIFY_ALL);
                opened.add(p.toImmutable());
            }
        }
        if (!opened.isEmpty()) {
            RESTORE_QUEUE.add(new DungeonDoorRestoreGroup(
                    serverWorld.getRegistryKey(),
                    opened,
                    RESTORE_DELAY_TICKS
            ));
        }
        return ActionResult.SUCCESS;
    }

    private static BooleanProperty getOpenProperty(Block block) {
        if (block == ModBlocks.DUNGEON_DOOR_FRAME) return DungeonDoorFrameBlock.OPEN;
        return OPEN;
    }

    private static Set<BlockPos> findConnectedBlocks(ServerWorld world, BlockPos start) {
        Set<BlockPos> visited = new HashSet<>();
        Queue<BlockPos> queue = new ArrayDeque<>();
        queue.add(start.toImmutable());
        visited.add(start.toImmutable());
        while (!queue.isEmpty()) {
            BlockPos current = queue.poll();
            for (Direction dir : Direction.values()) {
                BlockPos neighbor = current.offset(dir);
                if (visited.contains(neighbor)) continue;
                BlockState state = world.getBlockState(neighbor);
                if (state.getBlock() == ModBlocks.DUNGEON_DOOR_FRAME || state.getBlock() == ModBlocks.DUNGEON_DOOR_KEYHOLE) {
                    visited.add(neighbor.toImmutable());
                    queue.add(neighbor);
                }
            }
        }
        return visited;
    }

    public static void registerTickEvent() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            Iterator<DungeonDoorRestoreGroup> it = RESTORE_QUEUE.iterator();
            while (it.hasNext()) {
                DungeonDoorRestoreGroup group = it.next();
                group.tick();
                if (group.shouldRestore()) {
                    ServerWorld world = server.getWorld(group.worldKey);
                    if (world != null) {
                        for (BlockPos p : group.positions) {
                            BlockState s = world.getBlockState(p);
                            if (s.getBlock() == ModBlocks.DUNGEON_DOOR_FRAME || s.getBlock() == ModBlocks.DUNGEON_DOOR_KEYHOLE) {
                                world.setBlockState(p, s.with(getOpenProperty(s.getBlock()), false), Block.NOTIFY_ALL);
                            }
                        }
                    }
                    it.remove();
                }
            }
        });
    }

    private static class DungeonDoorRestoreGroup {
        final RegistryKey<World> worldKey;
        final List<BlockPos> positions;
        int ticksRemaining;

        DungeonDoorRestoreGroup(RegistryKey<World> worldKey, List<BlockPos> positions, int delay) {
            this.worldKey = worldKey;
            this.positions = positions;
            this.ticksRemaining = delay;
        }

        void tick() {
            ticksRemaining--;
        }

        boolean shouldRestore() {
            return ticksRemaining <= 0;
        }
    }
}
