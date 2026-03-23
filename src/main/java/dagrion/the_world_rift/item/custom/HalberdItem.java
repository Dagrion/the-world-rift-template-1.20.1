package dagrion.the_world_rift.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import dagrion.the_world_rift.component.weapons.WeaponChargeComponent;
import dagrion.the_world_rift.effect.ModEffect;
import dagrion.the_world_rift.item.ModItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;
import java.util.UUID;

public class HalberdItem extends SwordItem {
    protected static final UUID ATTACK_REACH_MODIFIER_ID = UUID.fromString("66dbd500-02d6-46a9-b510-699af6ac0936");
    protected static final UUID REACH_MODIFIER_ID = UUID.fromString("e7509cce-5ee6-4bb2-97e7-39a01aa58913");
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    private void disableShield(PlayerEntity player) {
        player.getItemCooldownManager().set(Items.SHIELD, 100);
        player.clearActiveItem();
        player.getWorld().sendEntityStatus(player, (byte)30);
    }

    public HalberdItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", toolMaterial.getAttackDamage() + attackDamage + 0, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        builder.put(ReachEntityAttributes.ATTACK_RANGE, new EntityAttributeModifier(ATTACK_REACH_MODIFIER_ID, "Weapon modifier", 1.5, EntityAttributeModifier.Operation.ADDITION));
        builder.put(ReachEntityAttributes.REACH, new EntityAttributeModifier(REACH_MODIFIER_ID, "Weapon modifier", 2.0, EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(slot);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        if (target instanceof PlayerEntity player) {
            if (player.isBlocking()) {
                disableShield(player);
            }
        }

        // Your existing blood effect
        if (Math.random() < 0.15 && attacker.getMainHandStack().getItem() == ModItems.BLOODSTAINED_HALBERD) {
            target.addStatusEffect(new StatusEffectInstance(ModEffect.BLOODLOSS, 20 * 5, 0)); }
        if (attacker instanceof PlayerEntity p) {
            WeaponChargeComponent charge = WeaponChargeComponent.get(p);
            if (charge != null) charge.incrementHalebard(2);
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (!world.isClient) {
            WeaponChargeComponent charge = WeaponChargeComponent.get(user);
            if (charge != null && charge.getHalebard() >= WeaponChargeComponent.MAX) {
                charge.useHalebard(100);

                double radius = 6.0;

                List<PlayerEntity> players = world.getEntitiesByClass(
                        PlayerEntity.class,
                        user.getBoundingBox().expand(radius),
                        target -> target != user
                );

                for (PlayerEntity target : players) {
                    if (target.isBlocking()) {
                        disableShield(target);
                    }
                }

                world.playSound(null, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.ITEM_SHIELD_BREAK,
                        SoundCategory.PLAYERS, 1.0f, 1.0f);

                ((ServerWorld) world).spawnParticles(ParticleTypes.SMOKE,
                        user.getX(), user.getY() + 1.0, user.getZ(),
                        50, 3.5, 2.5, 3.5, 0.0);
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
        return charge != null ? Math.round((float) charge.getHalebard() / WeaponChargeComponent.MAX * 13) : 0;
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
        if (stack.isOf(ModItems.BLOODSTAINED_HALBERD)) {
            tooltip.add(Text.literal("Have a chance to inflict Blood Loss").formatted(Formatting.DARK_RED));
        }
    }
}

