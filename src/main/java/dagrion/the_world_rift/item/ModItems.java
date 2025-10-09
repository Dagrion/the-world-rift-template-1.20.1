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
    public static final Item BLOODSTAINED_INGOT = registerItem("bloodstained_ingot", new Item(new FabricItemSettings().fireproof()));
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

    public static final Item BLOODSTAINED_SWORD = registerItem("bloodstained_sword",
            new BloodySword(ModToolMaterials.BLOODSTAINED, 3, -2.4F, (new Item.Settings()).fireproof()));
    public static final Item RUINED_BLOODSTAINED_SWORD = registerItem("ruined_bloodstained_sword",
            new Item(new Item.Settings().fireproof().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item RUINED_BLOODSTAINED_SCYTHE = registerItem("ruined_bloodstained_scythe",
            new Item(new Item.Settings().fireproof().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item RUINED_BLOODSTAINED_HAMMER = registerItem("ruined_bloodstained_hammer",
            new Item(new Item.Settings().fireproof().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item RUINED_BLOODSTAINED_DUAL_BLADE = registerItem("ruined_bloodstained_dual_blade",
            new Item(new Item.Settings().fireproof().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item RUINED_BLOODSTAINED_HALBERD = registerItem("ruined_bloodstained_halberd",
            new Item(new Item.Settings().fireproof().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item RUINED_BLOODSTAINED_KNIFE = registerItem("ruined_bloodstained_knife",
            new Item(new Item.Settings().fireproof().maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item TRUE_BLOODSTAINED_SWORD = registerItem("true_bloodstained_sword",
            new TrueBloodySwordItem(ModToolMaterials.BLOODSTAINED, 3, -2.5F, (new Item.Settings()).fireproof().rarity(Rarity.RARE)));
    public static final Item BLOODSTAINED_SCYTHE = registerItem("bloodstained_scythe",
            new BloodyScythe(ModToolMaterials.BLOODSTAINED, 5, -2.9F, (new Item.Settings().fireproof().rarity(Rarity.RARE))));
    public static final Item BLOODSTAINED_HAMMER = registerItem("bloodstained_hammer",
            new BloodyHammer(ModToolMaterials.BLOODSTAINED, 3, -3.1F, (new Item.Settings().fireproof().rarity(Rarity.RARE))));
    public static final Item BLOODSTAINED_DUAL_BLADE = registerItem("bloodstained_dual_blade",
            new BloodyDualBlade(ModToolMaterials.BLOODSTAINED, -1, -2.0F, (new Item.Settings().fireproof().rarity(Rarity.RARE))));
    public static final Item BLOODSTAINED_HALBERD = registerItem("bloodstained_halberd",
            new BloodyHalberd(ModToolMaterials.BLOODSTAINED, 4, -3.0F, (new Item.Settings().fireproof().rarity(Rarity.RARE))));
    public static final Item BLOODSTAINED_KNIFE = registerItem("bloodstained_knife",
            new BloodyKnife(ModToolMaterials.BLOODSTAINED, 3, -2.0F, (new Item.Settings().fireproof().rarity(Rarity.RARE))));

    public static final Item HALF_MOON = registerItem("half_moon",
            new SwordItem(ModToolMaterials.MANAN, 32766, 32763, (new Item.Settings()).fireproof().rarity(Rarity.EPIC)));
    public static final Item HYPERNOVA = registerItem("hypernova",
            new HypernovaItem(new FabricItemSettings().maxCount(1).fireproof().rarity(Rarity.EPIC)));


    public static final Item BLOODSTAINED_HELMET = registerItem("bloodstained_helmet",
            new BloodyArmorItem(ModArmorMaterials.BLOODSTAINED, ArmorItem.Type.HELMET, new Item.Settings().fireproof()));
    public static final Item BLOODSTAINED_CHESTPLATE = registerItem("bloodstained_chestplate",
            new BloodyArmorItem(ModArmorMaterials.BLOODSTAINED, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof()));
    public static final Item BLOODSTAINED_LEGGINGS = registerItem("bloodstained_leggings",
            new BloodyArmorItem(ModArmorMaterials.BLOODSTAINED, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof()));
    public static final Item BLOODSTAINED_BOOTS = registerItem("bloodstained_boots",
            new BloodyArmorItem(ModArmorMaterials.BLOODSTAINED, ArmorItem.Type.BOOTS, new Item.Settings().fireproof()));

















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
            new DagrionArmorItem(ModArmorMaterials.DAGRION, ArmorItem.Type.HELMET, new Item.Settings().fireproof()));
    public static final Item DAGRION_VAMBRACES = registerItem("dagrion_vambraces",
            new DagrionArmorItem(ModArmorMaterials.DAGRION, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof()));
    public static final Item DAGRION_COAT = registerItem("dagrion_coat",
            new DagrionArmorItem(ModArmorMaterials.DAGRION, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof()));
    public static final Item DAGRION_GREAVES = registerItem("dagrion_greaves",
            new DagrionArmorItem(ModArmorMaterials.DAGRION, ArmorItem.Type.BOOTS, new Item.Settings().fireproof()));



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
            fabricItemGroupEntries.add(ANCIENT_TABLET);

        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(fabricItemGroupEntries -> {


        });
    }
}