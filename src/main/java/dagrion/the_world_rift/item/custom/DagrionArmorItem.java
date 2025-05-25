package dagrion.the_world_rift.item.custom;

import dagrion.the_world_rift.effect.ModEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.UUID;

public class DagrionArmorItem extends ArmorItem {

    // Fixed UUIDs for attribute modifiers
    private static final UUID ARMOR_BONUS_UUID = UUID.fromString("c74b8f9e-0e9a-44ae-8129-5bfa2f937b01");
    private static final UUID TOUGHNESS_BONUS_UUID = UUID.fromString("d3c1c417-1f91-4551-8f5d-b7be9fdce751");

    public DagrionArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient() && entity instanceof PlayerEntity player &&
                !player.hasStatusEffect(ModEffect.BLOODLUST) && player.getHealth() <= 10) { // 5 hp = 2.5 hearts
            if (player.getInventory().armor.stream()
                    .allMatch(itemStack ->
                            itemStack.getItem() instanceof ArmorItem armorItem &&
                                    armorItem.getMaterial() == this.material)) {
                player.addStatusEffect(new StatusEffectInstance(ModEffect.BLOODLUST, 100,
                        0, false, false, true));
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);

        if (!(entity instanceof PlayerEntity player) || world.isClient) return;

        // Run this check only for boots (to avoid repeating per armor piece)
        if (this.getType() != Type.BOOTS) return;

        if (isWearingFullSet(player)) {
            applySetBonus(player);
        } else {
            removeSetBonus(player);
        }
    }

    private boolean isWearingFullSet(PlayerEntity player) {
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            if (slot.getType() != EquipmentSlot.Type.ARMOR) continue;

            ItemStack armorStack = player.getEquippedStack(slot);
            if (!(armorStack.getItem() instanceof DagrionArmorItem)) {
                return false;
            }
        }
        return true;
    }

    private void applySetBonus(PlayerEntity player) {
        addModifier(player, EntityAttributes.GENERIC_ARMOR, ARMOR_BONUS_UUID, "dagrion_bonus_armor", 6.0);
        addModifier(player, EntityAttributes.GENERIC_ARMOR_TOUGHNESS, TOUGHNESS_BONUS_UUID, "dagrion_bonus_toughness", 2.0);
    }

    private void removeSetBonus(PlayerEntity player) {
        removeModifier(player, EntityAttributes.GENERIC_ARMOR, ARMOR_BONUS_UUID);
        removeModifier(player, EntityAttributes.GENERIC_ARMOR_TOUGHNESS, TOUGHNESS_BONUS_UUID);
    }

    private void addModifier(PlayerEntity player, EntityAttribute attribute, UUID uuid, String name, double value) {
        var instance = player.getAttributeInstance(attribute);
        if (instance == null  instance.hasModifier()) return;

        instance.addTemporaryModifier(new EntityAttributeModifier(uuid, name, value, EntityAttributeModifier.Operation.ADDITION));
    }

    private void removeModifier(PlayerEntity player, EntityAttribute attribute, UUID uuid) {
        var instance = player.getAttributeInstance(attribute);
        if (instance != null && instance.hasModifier()) {
            instance.removeModifier(uuid);
        }
    }
}