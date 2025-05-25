package dagrion.the_world_rift.item;

import dagrion.the_world_rift.TheWorldRift;
import dagrion.the_world_rift.item.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item NETHER_STAR_SHARD = registerItem("nether_star_shard", new NetherStarItem(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item NETHER_STAR_POWDER = registerItem("nether_star_powder", new NetherStarItem(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item END_STONE_DUST = registerItem("end_stone_dust", new Item(new FabricItemSettings()));
    public static final Item NETHERITE_NUGGET = registerItem("netherite_nugget", new Item(new FabricItemSettings().fireproof()));
    public static final Item BLOODY_INGOT = registerItem("bloody_ingot", new Item(new FabricItemSettings().fireproof()));
    public static final Item MOON_DUST = registerItem("moon_dust", new Item(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item BLOOD_MOON_DUST = registerItem("blood_moon_dust", new Item(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item BLOOD_MOON = registerItem("blood_moon", new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC)));
    public static final Item EMPTY_VIAL = registerItem("empty_vial", new StingerItem((new FabricItemSettings().maxCount(16))));
    public static final Item BLOOD_VIAL = registerItem("blood_vial", new Item(new FabricItemSettings().maxCount(1)));
    public static final Item BLOOD_CRYSTAL = registerItem("blood_crystal", new Item(new FabricItemSettings()));

    public static final Item STINGER = registerItem("stinger",
            new StingerItem((new Item.Settings()).fireproof()));

    public static final Item ENCHANTED_CARROT = registerItem("enchanted_carrot",
            new EnchantedCarrotItem(new Item.Settings().food(ModFoodComponents.ENCHANTED_CARROT).maxCount(1).rarity(Rarity.RARE)));
    public static final Item BORDER_BREAKER = registerItem("border_breaker",
            new BorderBreakerItem(3,-2.8F, ModToolMaterials.BLOODY, new FabricItemSettings()));;

    public static final Item BLOODY_SWORD = registerItem("bloody_sword",
            new BloodySword(ModToolMaterials.BLOODY, 3, -2.4F, (new Item.Settings()).fireproof()));
    public static final Item BROKEN_BLOODY_SWORD = registerItem("broken_bloody_sword",
            new Item(new Item.Settings().fireproof().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item BROKEN_BLOODY_SCYTHE = registerItem("broken_bloody_scythe",
            new Item(new Item.Settings().fireproof().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item BROKEN_BLOODY_HAMMER = registerItem("broken_bloody_hammer",
            new Item(new Item.Settings().fireproof().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item BROKEN_BLOODY_DUAL_BLADE = registerItem("broken_bloody_dual_blade",
            new Item(new Item.Settings().fireproof().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item BROKEN_BLOODY_GLAIVE = registerItem("broken_bloody_glaive",
            new Item(new Item.Settings().fireproof().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item BROKEN_BLOODY_TRIDENT = registerItem("broken_bloody_trident",
            new Item(new Item.Settings().fireproof().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item BROKEN_BLOODY_KNIFE = registerItem("broken_bloody_knife",
            new Item(new Item.Settings().fireproof().maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item TRUE_BLOODY_SWORD = registerItem("true_bloody_sword",
            new TrueBloodySwordItem(ModToolMaterials.BLOODY, 3, -2.5F, (new Item.Settings()).fireproof().rarity(Rarity.RARE)));
    public static final Item BLOODY_SCYTHE = registerItem("bloody_scythe",
            new BloodyScythe(ModToolMaterials.BLOODY, 5, -2.9F, (new Item.Settings().fireproof().rarity(Rarity.RARE))));
    public static final Item BLOODY_HAMMER = registerItem("bloody_hammer",
            new BloodyHammer(ModToolMaterials.BLOODY, 2, -3.1F, (new Item.Settings().fireproof().rarity(Rarity.RARE))));
    public static final Item BLOODY_DUAL_BLADE = registerItem("bloody_dual_blade",
            new BloodyDualBlade(ModToolMaterials.BLOODY, -1, -2.0F, (new Item.Settings().fireproof().rarity(Rarity.RARE))));
    public static final Item BLOODY_GLAIVE = registerItem("bloody_glaive",
            new BloodyGlaive(ModToolMaterials.BLOODY, 4, -2.9F, (new Item.Settings().fireproof().rarity(Rarity.RARE))));
    public static final Item BLOODY_TRIDENT = registerItem("bloody_trident",
            new BloodyTrident((new Item.Settings().maxDamage(2500).fireproof().rarity(Rarity.RARE))));
    public static final Item BLOODY_KNIFE = registerItem("bloody_knife",
            new BloodyKnife(ModToolMaterials.BLOODY, 0, -2.0F, (new Item.Settings().fireproof().rarity(Rarity.RARE))));
    public static final Item HALF_MOON = registerItem("half_moon",
            new SwordItem(ModToolMaterials.MANAN, 32766, 32763, (new Item.Settings()).fireproof().rarity(Rarity.EPIC)));

    public static final Item BLOODY_HELMET = registerItem("bloody_helmet",
            new BloodyArmorItem(ModArmorMaterials.BLOODY, ArmorItem.Type.HELMET, new Item.Settings().fireproof()));
    public static final Item BLOODY_CHESTPLATE = registerItem("bloody_chestplate",
            new BloodyArmorItem(ModArmorMaterials.BLOODY, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof()));
    public static final Item BLOODY_LEGGINGS = registerItem("bloody_leggings",
            new BloodyArmorItem(ModArmorMaterials.BLOODY, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof()));
    public static final Item BLOODY_BOOTS = registerItem("bloody_boots",
            new BloodyArmorItem(ModArmorMaterials.BLOODY, ArmorItem.Type.BOOTS, new Item.Settings().fireproof()));

    public static final Item FLESH_PILE = registerItem("flesh_pile",
            new SpawnEggItem(EntityType.ZOMBIE,0xcbc6a5 ,0xff2400,new FabricItemSettings()));




    public static final Item BLOODSTEEL_INGOT = registerItem("bloodsteel_ingot", new Item(new FabricItemSettings().fireproof()));
    public static final Item HARDENED_BLOOD_CRYSTAL = registerItem("hardened_blood_crystal", new Item(new FabricItemSettings()));

    public static final Item BLOODSTEEL_HELMET = registerItem("bloodsteel_helmet",
            new BloodyArmorItem(ModArmorMaterials.BLOODSTEEL, ArmorItem.Type.HELMET, new Item.Settings().fireproof()));
    public static final Item BLOODSTEEL_CHESTPLATE = registerItem("bloodsteel_chestplate",
            new BloodyArmorItem(ModArmorMaterials.BLOODSTEEL, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof()));
    public static final Item BLOODSTEEL_LEGGINGS = registerItem("bloodsteel_leggings",
            new BloodyArmorItem(ModArmorMaterials.BLOODSTEEL, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof()));
    public static final Item BLOODSTEEL_BOOTS = registerItem("bloodsteel_boots",
            new BloodyArmorItem(ModArmorMaterials.BLOODSTEEL, ArmorItem.Type.BOOTS, new Item.Settings().fireproof()));
    public static final Item BLOODSTEEL_SWORD = registerItem("bloodsteel_sword",
            new BloodySword(ModToolMaterials.BLOODSTEEL, 3, -2.4F, (new Item.Settings()).fireproof()));




    public static final Item BLOOD_OF_THE_IMMORTAL = registerItem("blood_of_the_immortal", new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item DRAGON_HEART = registerItem("dragon_heart", new StingerItem((new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON))));
    public static final Item DARK_CLOTH = registerItem("dark_cloth", new StingerItem((new FabricItemSettings())));
    public static final Item DAGRION_HOOD = registerItem("dagrion_hood",
            new BloodyArmorItem(ModArmorMaterials.DAGRION, ArmorItem.Type.HELMET, new Item.Settings().fireproof()));
    public static final Item DAGRION_VAMBRACES = registerItem("dagrion_vambraces",
            new BloodyArmorItem(ModArmorMaterials.DAGRION, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof()));
    public static final Item DAGRION_COAT = registerItem("dagrion_coat",
            new BloodyArmorItem(ModArmorMaterials.DAGRION, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof()));
    public static final Item DAGRION_GREAVES = registerItem("dagrion_greaves",
            new BloodyArmorItem(ModArmorMaterials.DAGRION, ArmorItem.Type.BOOTS, new Item.Settings().fireproof()));



    public static final Item GLITCHED_BLOOD = registerItem("glitched_blood", new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TheWorldRift.MOD_ID, name), item);

    }

    public static void registerModItems () {
        TheWorldRift.LOGGER.info("Registering Mod Items for" + TheWorldRift.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.OPERATOR).register(fabricItemGroupEntries -> {

            fabricItemGroupEntries.add(HALF_MOON);

        });
    }
}