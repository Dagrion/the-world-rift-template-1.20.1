package dagrion.the_world_rift.item.custom;

import dagrion.the_world_rift.component.weapons.WeaponChargeComponent;
import dagrion.the_world_rift.effect.ModEffect;
import dagrion.the_world_rift.item.ModItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class DualBladeItem extends SwordItem {
    public DualBladeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (Math.random() < 0.15 && attacker.getMainHandStack().getItem() == ModItems.BLOODSTAINED_DUAL_BLADE) {
            target.addStatusEffect(new StatusEffectInstance(ModEffect.BLOODLOSS, 20 * 6, 0)); }
        if (attacker instanceof PlayerEntity p) {
            WeaponChargeComponent charge = WeaponChargeComponent.get(p);
            if (charge != null) charge.incrementDualblade(2);
        }
        return true;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient) {
            WeaponChargeComponent charge = WeaponChargeComponent.get(user);
            if (charge != null && charge.getDualblade() >= WeaponChargeComponent.MAX) {
                Vec3d attackerPos = user.getPos();
                charge.useDualblade(100);

                double radius = 2.5;
                Box box = new Box(
                        attackerPos.x - radius, attackerPos.y + 0.5, attackerPos.z - radius,
                        attackerPos.x + radius, attackerPos.y + 1.5, attackerPos.z + radius
                );
                List<LivingEntity> nearby = world.getEntitiesByClass(LivingEntity.class, box,
                        e -> e != user);

                float sweepDamage = 7.0f;

                for (LivingEntity entity : nearby) {
                    entity.damage(entity.getDamageSources().mobAttack(user), sweepDamage);
                    entity.addStatusEffect(new StatusEffectInstance(ModEffect.BLOODLOSS, 140, 0));

                }

                world.playSound(null, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.ITEM_TRIDENT_RIPTIDE_1, SoundCategory.PLAYERS, 1.0f, 1.0f);

                ((ServerWorld) world).spawnParticles(ParticleTypes.SWEEP_ATTACK,
                        user.getX(), user.getY() + 1.0, user.getZ(),
                        100, 1.5, 0.0, 1.5, 0.0);
            }
        }
        return TypedActionResult.consume(stack);
    }

    @Override
    public boolean isItemBarVisible(ItemStack stack) {
        return true;
    }
    @Override
    public int getItemBarStep(ItemStack stack) {
        WeaponChargeComponent charge = WeaponChargeComponent.getForDisplay();
        return charge != null ? Math.round((float) charge.getDualblade() / WeaponChargeComponent.MAX * 13) : 0;
    }
    @Override
    public int getItemBarColor(ItemStack stack) {
        int red = (int) (255);
        int blue = (int) (36);
        int green = (int) (0);
        return (red << 16) | (green << 8) | blue; // RGB mix
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        if (stack.isOf(ModItems.BLOODSTAINED_DUAL_BLADE)) {
            tooltip.add(Text.literal("Have a chance to inflict Blood Loss").formatted(Formatting.DARK_RED));
        }
    }
}
