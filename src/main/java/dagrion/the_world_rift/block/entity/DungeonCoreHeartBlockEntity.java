package dagrion.the_world_rift.block.entity;

import dagrion.the_world_rift.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.state.property.Properties;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.List;

public class DungeonCoreHeartBlockEntity extends BlockEntity {

    private static final int MAX_RAY_DISTANCE = 16;
    private static final float PARTICLE_STEP = 0.25f;
    private static final Vector3f RED_COLOR = new Vector3f(1f, 0f, 0f);

    public DungeonCoreHeartBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.DUNGEON_CORE_HEART, pos, state);
    }

    private static final int PARTICLE_INTERVAL_TICKS = 4;

    public static void tick(World world, BlockPos pos, BlockState state, DungeonCoreHeartBlockEntity be) {
        if (world.isClient) return;
        if (!(world instanceof net.minecraft.server.world.ServerWorld serverWorld)) return;

        if (!isStructureFull(world, pos)) return;

        BlockPos origin = pos.add(-1, -1, -1);
        TransmitterInfo[] transmitters = {
                new TransmitterInfo(origin.add(2, 1, 1), Direction.EAST),
                new TransmitterInfo(origin.add(0, 1, 1), Direction.WEST),
                new TransmitterInfo(origin.add(1, 2, 1), Direction.UP),
                new TransmitterInfo(origin.add(1, 0, 1), Direction.DOWN),
                new TransmitterInfo(origin.add(1, 1, 2), Direction.SOUTH),
                new TransmitterInfo(origin.add(1, 1, 0), Direction.NORTH),
        };

        List<BlockPos> activeReceptors = new ArrayList<>();
        for (TransmitterInfo info : transmitters) {
            BlockPos receptorPos = findReceptorInDirection(world, info.pos, info.facing);
            if (receptorPos != null) {
                activeReceptors.add(receptorPos);
                if (world.getTime() % PARTICLE_INTERVAL_TICKS == 0) {
                    spawnRedstoneRay(serverWorld, info.pos, receptorPos);
                    damageEntitiesInRay(serverWorld, info.pos, receptorPos);
                }
            }
        }
    }

    private static boolean isStructureFull(World world, BlockPos center) {
        BlockPos origin = center.add(-1, -1, -1);
        if (world.getBlockState(center).getBlock() != ModBlocks.DUNGEON_CORE_HEART) return false;
        if (world.getBlockState(origin.add(2, 1, 1)).getBlock() != ModBlocks.DUNGEON_CORE_TRANSMITTER) return false;
        if (world.getBlockState(origin.add(0, 1, 1)).getBlock() != ModBlocks.DUNGEON_CORE_TRANSMITTER) return false;
        if (world.getBlockState(origin.add(1, 2, 1)).getBlock() != ModBlocks.DUNGEON_CORE_TRANSMITTER) return false;
        if (world.getBlockState(origin.add(1, 0, 1)).getBlock() != ModBlocks.DUNGEON_CORE_TRANSMITTER) return false;
        if (world.getBlockState(origin.add(1, 1, 2)).getBlock() != ModBlocks.DUNGEON_CORE_TRANSMITTER) return false;
        if (world.getBlockState(origin.add(1, 1, 0)).getBlock() != ModBlocks.DUNGEON_CORE_TRANSMITTER) return false;
        for (int dx = 0; dx < 3; dx++) {
            for (int dy = 0; dy < 3; dy++) {
                for (int dz = 0; dz < 3; dz++) {
                    if (dx == 1 && dy == 1 && dz == 1) continue;
                    if (isTransmitterPos(dx, dy, dz)) continue;
                    BlockPos p = origin.add(dx, dy, dz);
                    if (world.getBlockState(p).getBlock() != ModBlocks.DUNGEON_CORE_SHELL) return false;
                }
            }
        }
        return true;
    }

    private static boolean isTransmitterPos(int dx, int dy, int dz) {
        return (dx == 2 && dy == 1 && dz == 1) || (dx == 0 && dy == 1 && dz == 1)
                || (dx == 1 && dy == 2 && dz == 1) || (dx == 1 && dy == 0 && dz == 1)
                || (dx == 1 && dy == 1 && dz == 2) || (dx == 1 && dy == 1 && dz == 0);
    }

    private static final int MIN_TRANSMITTER_RECEPTOR_DISTANCE = 3;

    /**
     * Raycast from transmitter in facing direction. Returns receptor position if found with only air in between, null otherwise.
     * Transmitter and receptor must face each other. Transmitter and receptor must be at least MIN_TRANSMITTER_RECEPTOR_DISTANCE blocks apart.
     * Every block except air blocks the ray.
     */
    private static BlockPos findReceptorInDirection(World world, BlockPos transmitterPos, Direction facing) {
        BlockPos.Mutable current = transmitterPos.mutableCopy();
        for (int i = 0; i < MAX_RAY_DISTANCE; i++) {
            current.move(facing);
            BlockState state = world.getBlockState(current);
            if (state.getBlock() == ModBlocks.DUNGEON_CORE_RECEPTOR) {
                if (i + 1 >= MIN_TRANSMITTER_RECEPTOR_DISTANCE
                        && state.get(Properties.FACING) == facing.getOpposite()) {
                    return current.toImmutable();
                }
                return null;
            }
            if (!state.isAir()) {
                return null;
            }
        }
        return null;
    }

    private static final float RAY_DAMAGE = 3f;

    private static void damageEntitiesInRay(net.minecraft.server.world.ServerWorld world, BlockPos from, BlockPos to) {
        Vec3d start = Vec3d.ofCenter(from);
        Vec3d end = Vec3d.ofCenter(to);
        double minX = Math.min(start.x, end.x) - 0.3;
        double maxX = Math.max(start.x, end.x) + 0.3;
        double minY = Math.min(start.y, end.y) - 0.3;
        double maxY = Math.max(start.y, end.y) + 0.3;
        double minZ = Math.min(start.z, end.z) - 0.3;
        double maxZ = Math.max(start.z, end.z) + 0.3;
        Box rayBox = new Box(minX, minY, minZ, maxX, maxY, maxZ);
        List<LivingEntity> entities = world.getEntitiesByClass(LivingEntity.class, rayBox, e -> true);
        for (LivingEntity entity : entities) {
            entity.damage(world.getDamageSources().magic(), RAY_DAMAGE);
        }
    }

    private static void spawnRedstoneRay(net.minecraft.server.world.ServerWorld world, BlockPos from, BlockPos to) {
        Vec3d start = Vec3d.ofCenter(from);
        Vec3d end = Vec3d.ofCenter(to);
        Vec3d diff = end.subtract(start);
        double length = diff.length();
        if (length < 0.001) return;

        DustParticleEffect dust = new DustParticleEffect(RED_COLOR, 1f);
        int particleCount = Math.max(2, (int) (length / PARTICLE_STEP));
        double step = 1.0 / particleCount;

        for (int i = 0; i <= particleCount; i++) {
            double t = i * step;
            double x = start.x + diff.x * t;
            double y = start.y + diff.y * t;
            double z = start.z + diff.z * t;
            world.spawnParticles(dust, x, y, z, 1, 0, 0, 0, 0);
        }
    }

    private record TransmitterInfo(BlockPos pos, Direction facing) {}
}
