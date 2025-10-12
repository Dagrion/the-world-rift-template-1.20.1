package dagrion.the_world_rift.item;

import dagrion.the_world_rift.TheWorldRift;
import dagrion.the_world_rift.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class ModItemGroups {
    public static final ItemGroup THE_BLOOD_ALCHEMIST = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TheWorldRift.MOD_ID, "blood_moon"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BLOOD_VIAL))
                    .displayName(Text.translatable("itemgroup.the_world_rift.the_blood_alchemist_items"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.NETHERITE_NUGGET); entries.add(ModItems.STINGER);
                        entries.add(ModItems.NETHER_STAR_SHARD); entries.add(ModItems.NETHER_STAR_POWDER);
                        entries.add(ModItems.EMPTY_VIAL); entries.add(ModItems.BLOOD_VIAL);
                        entries.add(ModItems.BLOOD_CRYSTAL); entries.add(ModItems.HARDENED_BLOOD_CRYSTAL);

                        entries.add(ModItems.ENCHANTED_CARROT);

                        entries.add(ModItems.BLOODSTAINED_INGOT); entries.add(ModBlocks.BLOODSTAINED_BLOCK);
                        entries.add(ModItems.BLOODSTEEL_INGOT); entries.add(ModBlocks.BLOODSTEEL_BLOCK);

                        entries.add(ModItems.BLOODSTAINED_HELMET); entries.add(ModItems.BLOODSTAINED_CHESTPLATE);
                        entries.add(ModItems.BLOODSTAINED_LEGGINGS); entries.add(ModItems.BLOODSTAINED_BOOTS);
                        entries.add(ModItems.BLOODSTEEL_HELMET); entries.add(ModItems.BLOODSTEEL_CHESTPLATE);
                        entries.add(ModItems.BLOODSTEEL_LEGGINGS); entries.add(ModItems.BLOODSTEEL_BOOTS);

                        entries.add(ModItems.BLOODSTAINED_SWORD); entries.add(ModItems.BLOODSTEEL_SWORD);
                        entries.add(ModItems.RUINED_BLOODSTAINED_SWORD); entries.add(ModItems.TRUE_BLOODSTAINED_SWORD);
                        entries.add(ModItems.RUINED_BLOODSTAINED_SCYTHE); entries.add(ModItems.BLOODSTAINED_SCYTHE);
                        entries.add(ModItems.RUINED_BLOODSTAINED_HAMMER); entries.add(ModItems.BLOODSTAINED_HAMMER);
                        entries.add(ModItems.RUINED_BLOODSTAINED_DUAL_BLADE); entries.add(ModItems.BLOODSTAINED_DUAL_BLADE);
                        entries.add(ModItems.RUINED_BLOODSTAINED_HALBERD); entries.add(ModItems.BLOODSTAINED_HALBERD);
                        entries.add(ModItems.RUINED_BLOODSTAINED_KNIFE); entries.add(ModItems.BLOODSTAINED_KNIFE);
                        entries.add(ModItems.BORDER_BREAKER);





                    }).build());

    public static final ItemGroup THE_WORLD_RIFT_DECORATION = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TheWorldRift.MOD_ID, "dungeon_bricks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.DUNGEON_BRICKS))
                    .displayName(Text.translatable("itemgroup.the_world_rift.the_world_rift_decoration"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModBlocks.ANCIENT_LIBRARY);

                        entries.add(ModBlocks.DUNGEON_BRICKS); entries.add(ModBlocks.CRACKED_DUNGEON_BRICKS); entries.add(ModBlocks.DUNGEON_CORE);
                        entries.add(ModBlocks.PORTAL_BLOCK);

                        entries.add(ModBlocks.RUNED_BLACKSTONE_A); entries.add(ModBlocks.RUNED_BLACKSTONE_B); entries.add(ModBlocks.RUNED_BLACKSTONE_C);
                        entries.add(ModBlocks.RUNED_BLACKSTONE_D); entries.add(ModBlocks.RUNED_BLACKSTONE_E); entries.add(ModBlocks.RUNED_BLACKSTONE_F);
                        entries.add(ModBlocks.RUNED_BLACKSTONE_G); entries.add(ModBlocks.RUNED_BLACKSTONE_H); entries.add(ModBlocks.RUNED_BLACKSTONE_I);
                        entries.add(ModBlocks.RUNED_BLACKSTONE_J); entries.add(ModBlocks.RUNED_BLACKSTONE_K); entries.add(ModBlocks.RUNED_BLACKSTONE_L);
                        entries.add(ModBlocks.RUNED_BLACKSTONE_M); entries.add(ModBlocks.RUNED_BLACKSTONE_N); entries.add(ModBlocks.RUNED_BLACKSTONE_O);
                        entries.add(ModBlocks.RUNED_BLACKSTONE_P); entries.add(ModBlocks.RUNED_BLACKSTONE_Q); entries.add(ModBlocks.RUNED_BLACKSTONE_R);
                        entries.add(ModBlocks.RUNED_BLACKSTONE_S); entries.add(ModBlocks.RUNED_BLACKSTONE_T); entries.add(ModBlocks.RUNED_BLACKSTONE_U);
                        entries.add(ModBlocks.RUNED_BLACKSTONE_V); entries.add(ModBlocks.RUNED_BLACKSTONE_W); entries.add(ModBlocks.RUNED_BLACKSTONE_X);
                        entries.add(ModBlocks.RUNED_BLACKSTONE_Y); entries.add(ModBlocks.RUNED_BLACKSTONE_Z);

                        entries.add(ModBlocks.STEEL_BLOCK); entries.add(ModBlocks.HAZARD_BLOCK);

                    }).build());





    public static final ItemGroup THE_RUINS_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TheWorldRift.MOD_ID, "Bloodstel_ingot"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BLOODSTEEL_INGOT))
                    .displayName(Text.translatable("itemgroup.the_world_rift.the_ruins_items"))
                    .entries((displayContext, entries) -> {




                    }).build());

    public static final ItemGroup THE_SEVEN_CALAMITY_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TheWorldRift.MOD_ID, "dragon_heart"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.DRAGON_HEART))
                    .displayName(Text.translatable("itemgroup.the_world_rift.the_seven_calamity_items"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.BLOOD_OF_THE_IMMORTAL);
                        entries.add(ModItems.DRAGON_HEART);
                        entries.add(ModItems.DARK_CLOTH);

                        entries.add(ModItems.DAGRION_HOOD);
                        entries.add(ModItems.DAGRION_VAMBRACES);
                        entries.add(ModItems.DAGRION_COAT);
                        entries.add(ModItems.DAGRION_GREAVES);

                    }).build());

    public static final ItemGroup THE_GLICH_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TheWorldRift.MOD_ID, "glitched_blood"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.GLITCHED_BLOOD))
                    .displayName(Text.translatable("itemgroup.the_world_rift.the_glitched_items"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.GLITCHED_BLOOD);

                    }).build());

    public static void registerModItems() {
        TheWorldRift.LOGGER.info("Registering Mod Items for" + TheWorldRift.MOD_ID);

    }
}