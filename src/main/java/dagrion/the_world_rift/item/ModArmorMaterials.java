package dagrion.the_world_rift.item;

import dagrion.the_world_rift.TheWorldRift;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    BLOODSTAINED("bloodstained", 37, new int[] { 3, 8, 6, 3 }, 22,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3f, 0.1f, () -> Ingredient.ofItems(ModItems.BLOOD_CRYSTAL)),
    BLOODSTEEL("bloodsteel", 40, new int[] { 4, 8, 6, 4 }, 22,
    SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3f, 0.15f, () -> Ingredient.ofItems(ModItems.HARDENED_BLOOD_CRYSTAL)),
    DAGRION("dagrion", 42, new int[] { 4, 9, 7, 5 }, 25,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.5f, 0.0f, () -> Ingredient.ofItems(ModItems.DARK_CLOTH));

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = { 11, 16, 15, 13 };

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound,
                      float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return TheWorldRift.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
