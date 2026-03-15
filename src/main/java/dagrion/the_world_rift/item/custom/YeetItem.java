package dagrion.the_world_rift.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class YeetItem extends Item {
    public YeetItem(Settings settings) {super (settings);}
    double power = 15;
    double radius = 5;

    /* ------------------------------------------------ */
    /*  HUGE KNOCKBACK ON HIT                           */
    /* ------------------------------------------------ */
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!attacker.getWorld().isClient) {
            // Direction player is looking
            Vec3d look = attacker.getRotationVector().normalize();
            target.setVelocity(
                    look.x * power,
                    look.y * power * 1.2,
                    look.z * power
            );
            target.velocityModified = true;
            // Sync multiplayer
            if (target instanceof ServerPlayerEntity serverPlayer) {
                serverPlayer.networkHandler
                        .sendPacket(new EntityVelocityUpdateS2CPacket(serverPlayer));
            }
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient) {
            /* --------------------------------------- */
            /* CROUCH → SHOCKWAVE                      */
            /* --------------------------------------- */
            if (user.isSneaking()) {
                Box box = new Box(
                        user.getX() - radius, user.getY() - radius, user.getZ() - radius,
                        user.getX() + radius, user.getY() + radius, user.getZ() + radius
                );
                List<LivingEntity> nearby = world.getEntitiesByClass(LivingEntity.class, box,
                        e -> e != user);
                for (LivingEntity entity : nearby) {
                    Vec3d pushDir = entity.getPos().subtract(user.getPos()).normalize();
                    entity.setVelocity(
                            pushDir.x * power,
                            pushDir.y * power,
                            pushDir.z * power
                    );
                    if (entity instanceof ServerPlayerEntity serverPlayer) {
                        serverPlayer.networkHandler.sendPacket(new EntityVelocityUpdateS2CPacket(serverPlayer));
                    }
                }
            }
            /* --------------------------------------- */
            /* NORMAL RIGHT CLICK → DASH               */
            /* --------------------------------------- */
            else {
                Vec3d lookingDirection = user.getRotationVec(1.0f);
                user.setVelocity(
                        lookingDirection.x * power,
                        lookingDirection.y * power * 0.8,
                        lookingDirection.z * power
                );
                user.velocityModified = true;
                if (user instanceof ServerPlayerEntity serverPlayer) {
                    serverPlayer.networkHandler
                            .sendPacket(new EntityVelocityUpdateS2CPacket(serverPlayer));
                }
            }
            user.getItemCooldownManager().set(this, 100);
        }
        return TypedActionResult.consume(stack);
    }
}