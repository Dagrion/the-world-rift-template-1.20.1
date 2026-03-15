package dagrion.the_world_rift.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.World;

public class ModDamageSources {
    public static DamageSource bleeding (World world) {
        return new DamageSource(
                world.getRegistryManager()
                        .get(RegistryKeys.DAMAGE_TYPE)
                        .entryOf(ModDamageTypes.BLEEDING)
        );
    }

    public static DamageSource manan (World world) {
        return new DamageSource(
                world.getRegistryManager()
                        .get(RegistryKeys.DAMAGE_TYPE)
                        .entryOf(ModDamageTypes.MANAN)
        );
    }
}
