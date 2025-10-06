package dagrion.the_world_rift.item.custom;

import dagrion.the_world_rift.effect.ModEffect;
import dagrion.the_world_rift.item.ModItems;
import net.minecraft.entity.Entity;
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

    protected static final UUID TOUGHNESS_BONUS_ID = UUID.fromString("c0c77ae4-3de1-4c45-b847-8d94c61d1123");
    public DagrionArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    public static void tick(PlayerEntity player) {
        boolean fullSet = hasFullVoidplate(player);

        if (fullSet) {
            if (player.getAttributeInstance(EntityAttributes.GENERIC_ARMOR_TOUGHNESS) != null &&
                    player.getAttributeInstance(EntityAttributes.GENERIC_ARMOR_TOUGHNESS)
                            .getModifier(TOUGHNESS_BONUS_ID) == null) {

                player.getAttributeInstance(EntityAttributes.GENERIC_ARMOR_TOUGHNESS)
                        .addPersistentModifier(new EntityAttributeModifier(
                                TOUGHNESS_BONUS_ID,
                                "Voidplate armor set bonus",
                                3.0,
                                EntityAttributeModifier.Operation.ADDITION
                        ));
            }
        } else {
            // Remove the toughness buff if it's applied but the player removed the armor
            if (player.getAttributeInstance(EntityAttributes.GENERIC_ARMOR_TOUGHNESS) != null) {
                EntityAttributeModifier modifier = player.getAttributeInstance(EntityAttributes.GENERIC_ARMOR_TOUGHNESS)
                        .getModifier(TOUGHNESS_BONUS_ID);

                if (modifier != null) {
                    player.getAttributeInstance(EntityAttributes.GENERIC_ARMOR_TOUGHNESS)
                            .removeModifier(modifier);
                }
            }
        }
    }

    private static boolean hasFullVoidplate(PlayerEntity player) {
        ItemStack head = player.getInventory().armor.get(3);
        ItemStack chest = player.getInventory().armor.get(2);
        ItemStack legs = player.getInventory().armor.get(1);
        ItemStack boots = player.getInventory().armor.get(0);

        return head.isOf(ModItems.DAGRION_HOOD)
                && chest.isOf(ModItems.DAGRION_VAMBRACES)
                && legs.isOf(ModItems.DAGRION_COAT)
                && boots.isOf(ModItems.DAGRION_GREAVES);
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
    }
}