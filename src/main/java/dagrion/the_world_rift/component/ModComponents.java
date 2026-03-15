package dagrion.the_world_rift.component;
import dagrion.the_world_rift.component.weapons.WeaponChargeComponent;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

public class ModComponents implements EntityComponentInitializer
{
    public static final ComponentKey<WeaponChargeComponent>
            CHARGE = ComponentRegistry.getOrCreate(Identifier.of("the_world_rift", "charge"),
            WeaponChargeComponent.class);

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerFor(PlayerEntity.class, CHARGE, player ->  new WeaponChargeComponent(player));

    }
}
