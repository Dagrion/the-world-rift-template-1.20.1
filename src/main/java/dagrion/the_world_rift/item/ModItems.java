package dagrion.the_world_rift.item;

import dagrion.the_world_rift.TheWorldRift;
import dagrion.the_world_rift.item.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
        // -----------------------
        // CREATIVE ITEMS
        // -----------------------
        // MANAN ITEMS
    public static final Item HALF_MOON = registerItem("half_moon",
            new HalfMoon(ModToolMaterials.MANAN, 2147483647 , 2147483647, (new Item.Settings()).fireproof().rarity(Rarity.EPIC)));
    public static final Item HYPERNOVA = registerItem("hypernova",
            new Hypernova(new FabricItemSettings().maxCount(1).fireproof().rarity(Rarity.EPIC)));
        // DEBUG & FUNNY ITEMS
    public static final Item ANCIENT_TABLET = registerItem("ancient_tablet", new Item(new FabricItemSettings().maxCount(1)));
    public static final Item SRBDV = registerItem("scarlet_realm_behind_the_dark_veil", new SRBDVItem(new FabricItemSettings().maxCount(1)));
    public static final Item CHARGER = registerItem("charger", new ChargerItem(new FabricItemSettings().maxCount(1)));
    public static final Item YEET = registerItem("yeet", new YeetItem(new FabricItemSettings().maxCount(1)));
        // -----------------------
        // BASIC ITEMS
        // -----------------------
    public static final Item DRAGON_HEART = registerItem("dragon_heart", new StingerItem((new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON))));
    public static final Item DARK_CLOTH = registerItem("dark_cloth", new StingerItem((new FabricItemSettings())));
    public static final Item NETHER_STAR_SHARD = registerItem("nether_star_shard", new NetherStarItem(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item NETHER_STAR_POWDER = registerItem("nether_star_powder", new NetherStarItem(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item NETHERITE_NUGGET = registerItem("netherite_nugget", new Item(new FabricItemSettings().fireproof()));
    public static final Item BLOODSTAINED_INGOT = registerItem("bloodstained_ingot", new Item(new FabricItemSettings().fireproof()));
    public static final Item BLOODSTEEL_INGOT = registerItem("bloodsteel_ingot", new Item(new FabricItemSettings().fireproof()));
    public static final Item EMPTY_VIAL = registerItem("empty_vial", new StingerItem((new FabricItemSettings().maxCount(16))));
    public static final Item BLOOD_VIAL = registerItem("blood_vial", new Item(new FabricItemSettings().maxCount(1)));
    public static final Item BLOOD_CRYSTAL = registerItem("blood_crystal", new Item(new FabricItemSettings()));
    public static final Item HARDENED_BLOOD_CRYSTAL = registerItem("hardened_blood_crystal", new Item(new FabricItemSettings()));
    public static final Item STEEL_PLATE = registerItem("steel_plate", new Item(new FabricItemSettings().fireproof()));
        // TOOLS
    public static final Item STINGER = registerItem("stinger",
            new StingerItem(new Item.Settings().fireproof().maxCount(1)));
    public static final Item TEMPORARY_BLOCK_BREAKER = registerItem("temporary_block_breaker",
            new TemporaryBlockBreaker(new Item.Settings().fireproof().maxCount(1)));
    public static final Item DUNGEON_KEY = registerItem("dungeon_key",
            new Item(new FabricItemSettings().maxCount(1)));
        // FOODS
    public static final Item ENCHANTED_CARROT = registerItem("enchanted_carrot",
            new EnchantedCarrotItem(new Item.Settings().food(ModFoodComponents.ENCHANTED_CARROT).maxCount(1).rarity(Rarity.RARE)));
        // WEAPONS
    public static final Item CLAYMORE = registerItem("claymore",
            new ClaymoreItem(ToolMaterials.NETHERITE, 3, -2.7F, (new Item.Settings()).fireproof()));
    public static final Item SCYTHE = registerItem("scythe",
            new ScytheItem(ToolMaterials.NETHERITE, 5, -3.1F, (new Item.Settings().fireproof())));
    public static final Item HAMMER = registerItem("hammer",
            new HammerItem(ToolMaterials.NETHERITE, 3, -2.9F, (new Item.Settings().fireproof())));
    public static final Item DUAL_BLADE = registerItem("dual_blade",
            new DualBladeItem(ToolMaterials.NETHERITE, -1, -2.0F, (new Item.Settings().fireproof())));
    public static final Item HALBERD = registerItem("halberd",
            new HalberdItem(ToolMaterials.NETHERITE, 4, -3.0F, (new Item.Settings().fireproof())));
    public static final Item KNIFE = registerItem("knife",
            new KnifeItem(ToolMaterials.NETHERITE, 3, -2.0F, (new Item.Settings().fireproof())));
    public static final Item GLAIVE = registerItem("glaive",
            new GlaiveItem(ToolMaterials.NETHERITE, 3, -2.4F, (new Item.Settings().fireproof())));
        // -----------------------
        // BLOODSTAINED
        // -----------------------
        // RUINED
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
    public static final Item RUINED_BLOODSTAINED_GLAIVE = registerItem("ruined_bloodstained_glaive",
            new Item(new Item.Settings().fireproof().maxCount(1).rarity(Rarity.UNCOMMON)));
        // WEAPONS
    public static final Item BLOODSTAINED_CLAYMORE = registerItem("bloodstained_claymore",
            new ClaymoreItem(ModToolMaterials.BLOODSTAINED, 3, -2.7F, (new Item.Settings()).fireproof().rarity(Rarity.RARE)));
    public static final Item BLOODSTAINED_SCYTHE = registerItem("bloodstained_scythe",
            new ScytheItem(ModToolMaterials.BLOODSTAINED, 5, -3.1F, (new Item.Settings().fireproof().rarity(Rarity.RARE))));
    public static final Item BLOODSTAINED_HAMMER = registerItem("bloodstained_hammer",
            new HammerItem(ModToolMaterials.BLOODSTAINED, 3, -2.9F, (new Item.Settings().fireproof().rarity(Rarity.RARE))));
    public static final Item BLOODSTAINED_DUAL_BLADE = registerItem("bloodstained_dual_blade",
            new DualBladeItem(ModToolMaterials.BLOODSTAINED, -1, -2.0F, (new Item.Settings().fireproof().rarity(Rarity.RARE))));
    public static final Item BLOODSTAINED_HALBERD = registerItem("bloodstained_halberd",
            new HalberdItem(ModToolMaterials.BLOODSTAINED, 4, -3.0F, (new Item.Settings().fireproof().rarity(Rarity.RARE))));
    public static final Item BLOODSTAINED_KNIFE = registerItem("bloodstained_knife",
            new KnifeItem(ModToolMaterials.BLOODSTAINED, 3, -2.0F, (new Item.Settings().fireproof().rarity(Rarity.RARE))));
    public static final Item BLOODSTAINED_GLAIVE = registerItem("bloodstained_glaive",
            new GlaiveItem(ModToolMaterials.BLOODSTAINED, 3, -2.0F, (new Item.Settings().fireproof().rarity(Rarity.RARE))));
        // BASIC
    public static final Item BLOODSTAINED_HELMET = registerItem("bloodstained_helmet",
        new BloodstainedArmorItem(ModArmorMaterials.BLOODSTAINED, ArmorItem.Type.HELMET, new Item.Settings().fireproof()));
    public static final Item BLOODSTAINED_CHESTPLATE = registerItem("bloodstained_chestplate",
            new BloodstainedArmorItem(ModArmorMaterials.BLOODSTAINED, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof()));
    public static final Item BLOODSTAINED_LEGGINGS = registerItem("bloodstained_leggings",
            new BloodstainedArmorItem(ModArmorMaterials.BLOODSTAINED, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof()));
    public static final Item BLOODSTAINED_BOOTS = registerItem("bloodstained_boots",
            new BloodstainedArmorItem(ModArmorMaterials.BLOODSTAINED, ArmorItem.Type.BOOTS, new Item.Settings().fireproof()));
    public static final Item BLOODSTAINED_SWORD = registerItem("bloodstained_sword",
            new BloodstainedSword(ModToolMaterials.BLOODSTAINED, 3, -2.4F, (new Item.Settings()).fireproof()));
    public static final Item BLOODSTAINED_PICKAXE = registerItem("bloodstained_pickaxe",
            new PickaxeItem(ModToolMaterials.BLOODSTAINED, 1,-2.8F,new Item.Settings().fireproof()));
    public static final Item BLOODSTAINED_AXE = registerItem("bloodstained_axe",
            new AxeItem(ModToolMaterials.BLOODSTAINED, 5, -3.0F, (new Item.Settings()).fireproof()));
    public static final Item BLOODSTAINED_SHOVEL = registerItem("bloodstained_shovel",
            new ShovelItem(ModToolMaterials.BLOODSTAINED, 1.5F, -3.0F, (new Item.Settings()).fireproof()));
    public static final Item BLOODSTAINED_HOE = registerItem("bloodstained_hoe",
            new HoeItem(ModToolMaterials.BLOODSTAINED, -4, -0.0F, (new Item.Settings()).fireproof()));
    public static final Item BORDER_BREAKER = registerItem("border_breaker",
            new BorderBreakerItem( 1,-2.8F, ModToolMaterials.BLOODSTAINED, new FabricItemSettings()));
        // -----------------------
        // BLOODSTEEL
        // -----------------------
        // BASIC
    public static final Item BLOODSTEEL_HELMET = registerItem("bloodsteel_helmet",
            new BloodsteelArmorItem(ModArmorMaterials.BLOODSTEEL, ArmorItem.Type.HELMET, new Item.Settings().fireproof()));
    public static final Item BLOODSTEEL_CHESTPLATE = registerItem("bloodsteel_chestplate",
            new BloodsteelArmorItem(ModArmorMaterials.BLOODSTEEL, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof()));
    public static final Item BLOODSTEEL_LEGGINGS = registerItem("bloodsteel_leggings",
            new BloodsteelArmorItem(ModArmorMaterials.BLOODSTEEL, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof()));
    public static final Item BLOODSTEEL_BOOTS = registerItem("bloodsteel_boots",
            new BloodsteelArmorItem(ModArmorMaterials.BLOODSTEEL, ArmorItem.Type.BOOTS, new Item.Settings().fireproof()));
    public static final Item BLOODSTEEL_SWORD = registerItem("bloodsteel_sword",
            new BloodstainedSword(ModToolMaterials.BLOODSTEEL, 3, -2.6F, (new Item.Settings()).fireproof()));
    public static final Item BLOODSTEEL_PICKAXE = registerItem("bloodsteel_pickaxe",
            new PickaxeItem(ModToolMaterials.BLOODSTEEL, 1, -2.8F, new Item.Settings().fireproof()));
    public static final Item BLOODSTEEL_AXE = registerItem("bloodsteel_axe",
            new AxeItem(ModToolMaterials.BLOODSTEEL, 5, -3.0F, (new Item.Settings()).fireproof()));
    public static final Item BLOODSTEEL_SHOVEL = registerItem("bloodsteel_shovel",
            new ShovelItem(ModToolMaterials.BLOODSTEEL, 1.5F, -3.0F, (new Item.Settings()).fireproof()));
    public static final Item BLOODSTEEL_HOE = registerItem("bloodsteel_hoe",
            new HoeItem(ModToolMaterials.BLOODSTEEL, -4, -0.0F, (new Item.Settings()).fireproof()));
    public static final Item FRONTIER_BREAKER = registerItem("frontier_breaker",
            new FrontierBreakerItem( 1,-2.8F, ModToolMaterials.BLOODSTEEL, new FabricItemSettings()));

        // -----------------------
        // HELPERS ITEMS
        // -----------------------
    public static final Item PRISMATIC_CLEAVER = registerItem("prismatic_cleaver",
                new PrismaticCleaverItem(ToolMaterials.NETHERITE, 3, -2.7F, (new Item.Settings()).fireproof()));
        public static final Item TRUE_PRISMATIC_CLEAVER = registerItem("true_prismatic_cleaver",
                new TruePrismaticCleaverItem(ToolMaterials.NETHERITE, 3, -2.7F, (new Item.Settings()).fireproof()));
    public static final Item RESONANT_CLEAVER = registerItem("resonant_cleaver",
            new ClaymoreItem(ToolMaterials.NETHERITE, 3, -2.7F, (new Item.Settings()).fireproof()));

    public static final Item LATCHING_EMPTINESS = registerItem("latching_emptiness",
            new ScytheItem(ToolMaterials.NETHERITE, 5, -3.1F, (new Item.Settings().fireproof())));
    public static final Item FAULTY_DEVICE_CADEUCEUS = registerItem("faulty_device_cadeuceus",
            new ScytheItem(ToolMaterials.NETHERITE, 5, -3.1F, (new Item.Settings().fireproof())));

    public static final Item TACAZH = registerItem("tacazh",
            new KnifeItem(ToolMaterials.NETHERITE, 3, -2.0F, (new Item.Settings().fireproof())));
    public static final Item STAR = registerItem("star",
            new KnifeItem(ToolMaterials.NETHERITE, 3, -2.0F, (new Item.Settings().fireproof())));

    public static final Item CARMINE_BLOOM = registerItem("carmine_bloom",
            new GlaiveItem(ToolMaterials.NETHERITE, 3, -2.4F, (new Item.Settings().fireproof())));


        // -----------------------
        // WORK IN PROGRESS
        // -----------------------
    public static final Item BLOOD_OF_THE_IMMORTAL = registerItem("blood_of_the_immortal", new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item DAGRION_HOOD = registerItem("dagrion_hood",
            new DagrionArmorItem(ModArmorMaterials.DAGRION, ArmorItem.Type.HELMET, new Item.Settings().fireproof()));
    public static final Item DAGRION_VAMBRACES = registerItem("dagrion_vambraces",
            new DagrionArmorItem(ModArmorMaterials.DAGRION, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof()));
    public static final Item DAGRION_COAT = registerItem("dagrion_coat",
            new DagrionArmorItem(ModArmorMaterials.DAGRION, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof()));
    public static final Item DAGRION_GREAVES = registerItem("dagrion_greaves",
            new DagrionArmorItem(ModArmorMaterials.DAGRION, ArmorItem.Type.BOOTS, new Item.Settings().fireproof()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TheWorldRift.MOD_ID, name), item);

    }

}