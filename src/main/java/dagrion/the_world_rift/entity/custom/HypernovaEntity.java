package dagrion.the_world_rift.entity.custom;

import dagrion.the_world_rift.entity.ModEntities;
import dagrion.the_world_rift.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

public class HypernovaEntity extends ThrownItemEntity {
    public HypernovaEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public HypernovaEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.HYPERNOVA_PROJECTILE , livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.HYPERNOVA;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);

    }
}
