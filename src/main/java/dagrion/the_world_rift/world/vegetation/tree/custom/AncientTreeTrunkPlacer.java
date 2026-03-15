package dagrion.the_world_rift.world.vegetation.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dagrion.the_world_rift.world.vegetation.tree.ModTrunkPlacer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class AncientTreeTrunkPlacer extends TrunkPlacer {
    public static final Codec<AncientTreeTrunkPlacer> CODEC = RecordCodecBuilder.create(instance ->
            fillTrunkPlacerFields(instance)
                    .and(Codec.INT.fieldOf("base_radius").forGetter(p -> p.baseRadius))
                    .and(Codec.INT.fieldOf("taper_height").forGetter(p -> p.taperHeight))
                    .apply(instance, AncientTreeTrunkPlacer::new));
    private final int baseRadius;
    private final int taperHeight;

    public AncientTreeTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight, int baseRadius, int taperHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
        this.baseRadius = baseRadius;
        this.taperHeight = taperHeight;
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return ModTrunkPlacer.ANCIENT_TREE_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(
            TestableWorld world,
            BiConsumer<BlockPos, net.minecraft.block.BlockState> replacer,
            Random random,
            int height,
            BlockPos startPos,
            TreeFeatureConfig config) {

        setToDirt(world, replacer, random, startPos.down(), config);

        List<FoliagePlacer.TreeNode> foliage = new ArrayList<>();

        for (int y = 0; y < height; y++) {

            int currentRadius = baseRadius;

            // Taper near the top
            if (y >= height - taperHeight) {
                int taperProgress = y - (height - taperHeight);
                currentRadius = Math.max(1, baseRadius - taperProgress);
            }

            placeCircularLayer(world, replacer, random, startPos.up(y), currentRadius, config);
        }

        // Foliage at top
        foliage.add(new FoliagePlacer.TreeNode(startPos.up(height), 0, false));

        return foliage;
    }

    private void placeCircularLayer(TestableWorld world,
                                    BiConsumer<BlockPos, net.minecraft.block.BlockState> replacer,
                                    Random random,
                                    BlockPos center,
                                    int radius,
                                    TreeFeatureConfig config) {

        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {

                if (x * x + z * z <= radius * radius) {
                    BlockPos pos = center.add(x, 0, z);
                    getAndSetState(world, replacer, random, pos, config);
                }
            }
        }
    }
}
