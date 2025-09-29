package dagrion.the_world_rift.item;

import dagrion.the_world_rift.TheWorldRift;
import dagrion.the_world_rift.item.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item NETHER_STAR_SHARD = registerItem("nether_star_shard", new NetherStarItem(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item NETHER_STAR_POWDER = registerItem("nether_star_powder", new NetherStarItem(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item NETHERITE_NUGGET = registerItem("netherite_nugget", new Item(new FabricItemSettings().fireproof()));
    public static final Item BLOODSTAINED_INGOT = registerItem("bloody_ingot", new Item(new FabricItemSettings().fireproof()));
    public static final Item BLOOD_MOON = registerItem("blood_moon", new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC)));
    public static final Item EMPTY_VIAL = registerItem("empty_vial", new StingerItem((new FabricItemSettings().maxCount(16))));
    public static final Item BLOOD_VIAL = registerItem("blood_vial", new Item(new FabricItemSettings().maxCount(1)));
    public static final Item BLOOD_CRYSTAL = registerItem("blood_crystal", new Item(new FabricItemSettings()));

    public static final Item ANCIENT_TABLET = registerItem("ancient_tablet", new Item(new FabricItemSettings().maxCount(1)));
    public static final Item SRBDV = registerItem("scarlet_realm_behind_the_dark_veil", new SRBDVItem(new FabricItemSettings().maxCount(1)));

    public static final Item STINGER = registerItem("stinger",
            new StingerItem((new Item.Settings()).fireproof().maxCount(1)));

    public static final Item ENCHANTED_CARROT = registerItem("enchanted_carrot",
            new EnchantedCarrotItem(new Item.Settings().food(ModFoodComponents.ENCHANTED_CARROT).maxCount(1).rarity(Rarity.RARE)));

    public static final Item BORDER_BREAKER = registerItem("border_breaker",
            new BorderBreakerItem( 3,-2.8F, ModToolMaterials.BLOODSTAINED, new FabricItemSettings()));

    public static final Item BLOODSTAINED_SWORD = registerItem("bloody_sword",
            new BloodySword(ModToolMaterials.BLOODSTAINED, 3, -2.4F, (new Item.Settings()).fireproof()));
    public static final Item BROKEN_BLOODSTAINED_SWORD = registerItem("broken_bloody_sword",
            new Item(new Item.Settings().fireproof().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item BROKEN_BLOODSTAINED_SCYTHE = registerItem("broken_bloody_scythe",
            new Item(new Item.Settings().fireproof().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item BROKEN_BLOODSTAINED_HAMMER = registerItem("broken_bloody_hammer",
            new Item(new Item.Settings().fireproof().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item BROKEN_BLOODSTAINED_DUAL_BLADE = registerItem("broken_bloody_dual_blade",
            new Item(new Item.Settings().fireproof().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item BROKEN_BLOODSTAINED_HALBERD = registerItem("broken_bloody_halberd",
            new Item(new Item.Settings().fireproof().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item BROKEN_BLOODSTAINED_KNIFE = registerItem("broken_bloody_knife",
            new Item(new Item.Settings().fireproof().maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item TRUE_BLOODSTAINED_SWORD = registerItem("true_bloody_sword",
            new TrueBloodySwordItem(ModToolMaterials.BLOODSTAINED, 3, -2.5F, (new Item.Settings()).fireproof().rarity(Rarity.RARE)));
    public static final Item BLOODSTAINED_SCYTHE = registerItem("bloody_scythe",
            new BloodyScythe(ModToolMaterials.BLOODSTAINED, 5, -2.9F, (new Item.Settings().fireproof().rarity(Rarity.RARE))));
    public static final Item BLOODSTAINED_HAMMER = registerItem("bloody_hammer",
            new BloodyHammer(ModToolMaterials.BLOODSTAINED, 3, -3.1F, (new Item.Settings().fireproof().rarity(Rarity.RARE))));
    public static final Item BLOODSTAINED_DUAL_BLADE = registerItem("bloody_dual_blade",
            new BloodyDualBlade(ModToolMaterials.BLOODSTAINED, -1, -2.0F, (new Item.Settings().fireproof().rarity(Rarity.RARE))));
    public static final Item BLOODSTAINED_HALBERD = registerItem("bloody_halberd",
            new BloodyHalberd(ModToolMaterials.BLOODSTAINED, 4, -3.0F, (new Item.Settings().fireproof().rarity(Rarity.RARE))));
    public static final Item BLOODSTAINED_KNIFE = registerItem("bloody_knife",
            new BloodyKnife(ModToolMaterials.BLOODSTAINED, 3, -2.0F, (new Item.Settings().fireproof().rarity(Rarity.RARE))));

    public static final Item HALF_MOON = registerItem("half_moon",
            new SwordItem(ModToolMaterials.MANAN, 32766, 32763, (new Item.Settings()).fireproof().rarity(Rarity.EPIC)));
    public static final Item HYPERNOVA = registerItem("hypernova",
            new Item(new FabricItemSettings().maxCount(1).fireproof().rarity(Rarity.EPIC)));


    public static final Item BLOODSTAINED_HELMET = registerItem("bloody_helmet",
            new BloodyArmorItem(ModArmorMaterials.BLOODY, ArmorItem.Type.HELMET, new Item.Settings().fireproof()));
    public static final Item BLOODSTAINED_CHESTPLATE = registerItem("bloody_chestplate",
            new BloodyArmorItem(ModArmorMaterials.BLOODY, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof()));
    public static final Item BLOODSTAINED_LEGGINGS = registerItem("bloody_leggings",
            new BloodyArmorItem(ModArmorMaterials.BLOODY, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof()));
    public static final Item BLOODSTAINED_BOOTS = registerItem("bloody_boots",
            new BloodyArmorItem(ModArmorMaterials.BLOODY, ArmorItem.Type.BOOTS, new Item.Settings().fireproof()));

















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
            fabricItemGroupEntries.add(HYPERNOVA);
            fabricItemGroupEntries.add(SRBDV);

        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(fabricItemGroupEntries -> {

            fabricItemGroupEntries.add(ANCIENT_TABLET);

        });
    }
}