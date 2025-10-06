package dagrion.the_world_rift.entity;

import dagrion.the_world_rift.TheWorldRift;
import dagrion.the_world_rift.entity.custom.HypernovaEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModEntities {

    public  static final EntityType<HypernovaEntity> HYPERNOVA_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(TheWorldRift.MOD_ID, "hypernova_projectile"),
            FabricEntityTypeBuilder.<HypernovaEntity>create(SpawnGroup.MISC,HypernovaEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f,0.25f)).build());
}
