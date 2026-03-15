package dagrion.the_world_rift.item.custom;

import dagrion.the_world_rift.effect.ModEffect;
import dagrion.the_world_rift.util.ModDamageSources;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class HalfMoon extends SwordItem {
    public HalfMoon(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient && user.isCreative()) {
            Vec3d attackerPos = user.getPos();

            // Sweep radius (like Sweeping Edge)
            double radius = 10.0;
            Box box = new Box(
                    attackerPos.x - radius, attackerPos.y - 5.0, attackerPos.z - radius,
                    attackerPos.x + radius, attackerPos.y + 5.0, attackerPos.z + radius
            );
            List<LivingEntity> nearby = world.getEntitiesByClass(LivingEntity.class, box,
                    e -> e != user);

            // Sweep damage ~ half base damage
            float sweepDamage = 4294967296.0f;

            for (LivingEntity entity : nearby) {
                entity.damage(entity.getDamageSources().mobAttack(user), sweepDamage);
            }

            // Play sweep sound and particles
            world.playSound(null, user.getX(), user.getY(), user.getZ(),
                    SoundEvents.BLOCK_BEACON_DEACTIVATE, SoundCategory.PLAYERS, 1.0f, 1.0f);

            ((ServerWorld) world).spawnParticles(ParticleTypes.END_ROD,
                    user.getX(), user.getY() + 1.0, user.getZ(),
                    1500, 5.0, 5.0, 5.0, 0.0);
        }

        return TypedActionResult.consume(stack);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, net.minecraft.entity.Entity entity, int slot, boolean selected) {
        if (!world.isClient) {
            if (stack.getItem() instanceof HalfMoon) {
                    entity.damage(ModDamageSources.manan(entity.getWorld()),99999999999999999999999999999999999999F);
                }
            }
        }
    }
