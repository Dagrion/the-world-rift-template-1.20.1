package dagrion.the_world_rift.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import dagrion.the_world_rift.component.weapons.WeaponChargeComponent;
import dagrion.the_world_rift.effect.ModEffect;
import dagrion.the_world_rift.item.ModItems;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
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

public class KnifeItem extends SwordItem {

    protected static final UUID ATTACK_REACH_MODIFIER_ID = UUID.fromString("66dbd500-02d6-46a9-b510-699af6ac0936");
    protected static final UUID REACH_MODIFIER_ID = UUID.fromString("e7509cce-5ee6-4bb2-97e7-39a01aa58913");
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public KnifeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", toolMaterial.getAttackDamage() + attackDamage + 0, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        builder.put(ReachEntityAttributes.ATTACK_RANGE, new EntityAttributeModifier(ATTACK_REACH_MODIFIER_ID, "Weapon modifier", -2.0, EntityAttributeModifier.Operation.ADDITION));
        builder.put(ReachEntityAttributes.REACH, new EntityAttributeModifier(REACH_MODIFIER_ID, "Weapon modifier", 0.0, EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
        registerInvisibilityEvents();
    }

    private static boolean invisibilityEventsRegistered = false;

    private static void registerInvisibilityEvents() {
        if (invisibilityEventsRegistered) return;
        invisibilityEventsRegistered = true;
        // Remove invisibility when player doesn't have knife in inventory (runs once at mod init)
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                if (!player.hasStatusEffect(ModEffect.INVISIBILITY_KNIFE)) continue;
                boolean hasKnife = false;
                for (int i = 0; i < player.getInventory().size(); i++) {
                    if (player.getInventory().getStack(i).getItem() instanceof KnifeItem) {
                        hasKnife = true;
                        break;
                    }
                }
                if (!hasKnife) {
                    player.removeStatusEffect(ModEffect.INVISIBILITY_KNIFE);
                }
            }
        });
        // Remove invisibility when player deals damage
        AttackEntityCallback.EVENT.register((player, world, hand, target, hitResult) -> {
            if (!world.isClient && player.hasStatusEffect(ModEffect.INVISIBILITY_KNIFE)) {
                player.removeStatusEffect(ModEffect.INVISIBILITY_KNIFE);
            }
            return net.minecraft.util.ActionResult.PASS;
        });
        // Remove invisibility when player takes damage
        ServerLivingEntityEvents.ALLOW_DAMAGE.register((entity, source, amount) -> {
            if (entity instanceof ServerPlayerEntity player && player.hasStatusEffect(ModEffect.INVISIBILITY_KNIFE)) {
                player.removeStatusEffect(ModEffect.INVISIBILITY_KNIFE);
            }
            return true;
        });
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(slot);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (Math.random() < 0.15 && attacker.getMainHandStack().getItem() == ModItems.BLOODSTAINED_KNIFE) {
            target.addStatusEffect(new StatusEffectInstance(ModEffect.BLOODLOSS, 20 * 3, 1)); }
        if (attacker instanceof PlayerEntity p) {
            WeaponChargeComponent charge = WeaponChargeComponent.get(p);
            if (charge != null) charge.incrementKnife(2);
        }
        return true;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient) {
            WeaponChargeComponent charge = WeaponChargeComponent.get(user);
            if (charge != null && charge.getKnife() >= WeaponChargeComponent.MAX) {
                charge.useKnife(100);

                user.addStatusEffect(new StatusEffectInstance(
                        ModEffect.INVISIBILITY_KNIFE,
                        20 * 600,
                        0,
                        false,
                        false
                ));
                world.playSound(null, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.BLOCK_BEACON_ACTIVATE, SoundCategory.PLAYERS, 1.0f, 1.0f);
                ((ServerWorld) world).spawnParticles(ParticleTypes.END_ROD,
                        user.getX(), user.getY() + 1.0, user.getZ(),
                        1000, 0.5, 1.0, 0.5, 0.0);
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
        return charge != null ? Math.round((float) charge.getKnife() / WeaponChargeComponent.MAX * 13) : 0;
    }

    @Override
    public int getItemBarColor(ItemStack stack) {
        int red = 255;
        int green = 0;
        int blue = 36;
        return (red << 16) | (green << 8) | blue;
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        if (stack.isOf(ModItems.BLOODSTAINED_KNIFE)) {
            tooltip.add(Text.literal("Have a chance to inflict sever Blood Loss").formatted(Formatting.DARK_RED));
        }
    }

    // -----------------------
    // Invisibility Event Handling
    // -----------------------
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && entity instanceof PlayerEntity player) {
            boolean hasItemAnywhere = player.getInventory().contains(new ItemStack(this));
            boolean isHoldingMainHand = player.getMainHandStack().isOf(this);
            if (player.hasStatusEffect(ModEffect.INVISIBILITY_KNIFE) &&
                    (!hasItemAnywhere || !isHoldingMainHand)) {
                player.removeStatusEffect(ModEffect.INVISIBILITY_KNIFE);
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
