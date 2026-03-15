package dagrion.the_world_rift.world.dimension;

import dagrion.the_world_rift.TheWorldRift;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

import java.util.OptionalLong;

public class ModDimensions {
    public static final RegistryKey<DimensionOptions> THE_DARK_AMALGAM_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(TheWorldRift.MOD_ID, "the_dark_amalgam_dimension"));
    public static final RegistryKey<World> THE_DARK_AMALGAM_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(TheWorldRift.MOD_ID, "the_dark_amalgam_dimension"));
    public static final RegistryKey<DimensionType> THE_DARK_AMALGAM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(TheWorldRift.MOD_ID, "the_dark_amalgam_type"));

    public static void bootstrapType(Registerable<DimensionType> context) {
        context.register(THE_DARK_AMALGAM_TYPE, new DimensionType(
                OptionalLong.of(18000), // fixedTime
                true, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                true, // natural
                1.0, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                -64, // minY
                320, // height
                320, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD,
                DimensionTypes.OVERWORLD_ID, // effectsLocation
                0.5f, // ambientLight
                new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0, 0), 0)));
    }
}
