package dagrion.the_world_rift.item;

import dagrion.the_world_rift.TheWorldRift;
import dagrion.the_world_rift.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static dagrion.the_world_rift.item.ModItems.*;


public class ModItemGroups {

    public static ItemGroup THE_BLOOD_ALCHEMIST;
    public static ItemGroup THE_RUINS_ITEMS;

    public static ItemGroup THE_WORLD_RIFT_DECORATION;
    public static ItemGroup THE_WORLD_RIFT_OPERATOR;
    public static ItemGroup HELPER_ITEMS;

    public static void registerItemGroups() {
        TheWorldRift.LOGGER.info("Registering Item Groups for " + TheWorldRift.MOD_ID);

        THE_WORLD_RIFT_OPERATOR = Registry.register(Registries.ITEM_GROUP,
                new Identifier(TheWorldRift.MOD_ID, "the_world_rift_operator_items"),
                FabricItemGroup.builder()
                        .displayName(Text.translatable("itemgroup.the_world_rift.the_world_rift_operator_items"))
                        .icon(() -> new ItemStack(ModItems.DRAGON_HEART))
                        .entries((displayContext, entries) -> {

                            entries.add(HALF_MOON);
                            entries.add(HYPERNOVA);

                            entries.add(TRUE_PRISMATIC_CLEAVER);

                            entries.add(SRBDV);
                            entries.add(CHARGER);
                            entries.add(TEMPORARY_BLOCK_BREAKER);
                            entries.add(DUNGEON_KEY);

                            entries.add(ANCIENT_TABLET);


                            entries.add(ModItems.BLOOD_OF_THE_IMMORTAL);

                            entries.add(ModItems.DAGRION_HOOD);
                            entries.add(ModItems.DAGRION_VAMBRACES);
                            entries.add(ModItems.DAGRION_COAT);
                            entries.add(ModItems.DAGRION_GREAVES);
                        })
                        .build());

        HELPER_ITEMS = Registry.register(Registries.ITEM_GROUP,
                new Identifier(TheWorldRift.MOD_ID, "helper_items"),
                FabricItemGroup.builder()
                        .displayName(Text.translatable("itemgroup.the_world_rift.helper_items"))
                        .icon(() -> new ItemStack(PRISMATIC_CLEAVER))
                        .entries((displayContext, entries) -> {

                            entries.add(PRISMATIC_CLEAVER);
                            entries.add(RESONANT_CLEAVER);

                            entries.add(LATCHING_EMPTINESS);
                            entries.add(FAULTY_DEVICE_CADEUCEUS);

                            entries.add(CARMINE_BLOOM);

                            entries.add(TACAZH);
                            entries.add(STAR);

                        })
                        .build());

        THE_WORLD_RIFT_DECORATION = Registry.register(Registries.ITEM_GROUP,
                new Identifier(TheWorldRift.MOD_ID, "the_world_rift_decoration"),
                FabricItemGroup.builder()
                        .displayName(Text.translatable("itemgroup.the_world_rift.the_world_rift_decoration"))
                        .icon(() -> new ItemStack(ModBlocks.BLOODSTAINED_BLOCK))
                        .entries((displayContext, entries) -> {

                            entries.add(ModBlocks.ANCIENT_LIBRARY);

                            entries.add(ModBlocks.DUNGEON_BRICKS); entries.add(ModBlocks.CRACKED_DUNGEON_BRICKS); entries.add(ModBlocks.DUNGEON_CORE);
                            entries.add(ModBlocks.DUNGEON_DOOR_FRAME); entries.add(ModBlocks.DUNGEON_DOOR_KEYHOLE);
                            entries.add(ModBlocks.PORTAL_BLOCK);

                            entries.add(ModBlocks.DUNGEON_CORE_RECEPTOR); entries.add(ModBlocks.DUNGEON_CORE_TRANSMITTER); entries.add(ModBlocks.DUNGEON_CORE_SHELL); entries.add(ModBlocks.DUNGEON_CORE_HEART);
                        })
                        .build());

        THE_BLOOD_ALCHEMIST = Registry.register(Registries.ITEM_GROUP,
                new Identifier(TheWorldRift.MOD_ID, "the_blood_alchemist_items"),
                FabricItemGroup.builder()
                        .displayName(Text.translatable("itemgroup.the_world_rift.the_blood_alchemist_items"))
                        .icon(() -> new ItemStack(ModItems.BLOOD_VIAL))
                        .entries((displayContext, entries) -> {

                            entries.add(ModItems.NETHERITE_NUGGET);     entries.add(ModItems.STINGER);
                            entries.add(ModItems.DRAGON_HEART);         entries.add(ModItems.DARK_CLOTH);
                            entries.add(ModItems.NETHER_STAR_SHARD);    entries.add(ModItems.NETHER_STAR_POWDER);
                            entries.add(ModItems.EMPTY_VIAL);           entries.add(ModItems.BLOOD_VIAL);
                            entries.add(ModItems.BLOOD_CRYSTAL);        entries.add(ModItems.HARDENED_BLOOD_CRYSTAL);

                            entries.add(ModItems.ENCHANTED_CARROT);

                            entries.add(ModItems.BLOODSTAINED_INGOT);       entries.add(ModBlocks.BLOODSTAINED_BLOCK);
                            entries.add(ModItems.BLOODSTAINED_HELMET);      entries.add(ModItems.BLOODSTAINED_CHESTPLATE);
                            entries.add(ModItems.BLOODSTAINED_LEGGINGS);    entries.add(ModItems.BLOODSTAINED_BOOTS);
                            entries.add(ModItems.BLOODSTAINED_SWORD);       entries.add(ModItems.BLOODSTAINED_PICKAXE);
                            entries.add(ModItems.BLOODSTAINED_AXE);         entries.add(ModItems.BLOODSTAINED_SHOVEL);
                            entries.add(ModItems.BLOODSTAINED_HOE);

                            entries.add(ModItems.RUINED_BLOODSTAINED_SWORD);        entries.add(ModItems.BLOODSTAINED_CLAYMORE);
                            entries.add(ModItems.RUINED_BLOODSTAINED_SCYTHE);       entries.add(ModItems.BLOODSTAINED_SCYTHE);
                            entries.add(ModItems.RUINED_BLOODSTAINED_HAMMER);       entries.add(ModItems.BLOODSTAINED_HAMMER);
                            entries.add(ModItems.RUINED_BLOODSTAINED_DUAL_BLADE);   entries.add(ModItems.BLOODSTAINED_DUAL_BLADE);
                            entries.add(ModItems.RUINED_BLOODSTAINED_HALBERD);      entries.add(ModItems.BLOODSTAINED_HALBERD);
                            entries.add(ModItems.RUINED_BLOODSTAINED_KNIFE);        entries.add(ModItems.BLOODSTAINED_KNIFE);
                            entries.add(ModItems.RUINED_BLOODSTAINED_GLAIVE);       entries.add(ModItems.BLOODSTAINED_GLAIVE);
                            entries.add(ModItems.BORDER_BREAKER);

                            entries.add(ModItems.BLOODSTEEL_INGOT);     entries.add(ModBlocks.BLOODSTEEL_BLOCK);
                            entries.add(ModItems.BLOODSTEEL_HELMET);    entries.add(ModItems.BLOODSTEEL_CHESTPLATE);
                            entries.add(ModItems.BLOODSTEEL_LEGGINGS);  entries.add(ModItems.BLOODSTEEL_BOOTS);
                            entries.add(ModItems.BLOODSTEEL_SWORD);     entries.add(ModItems.BLOODSTEEL_PICKAXE);
                            entries.add(ModItems.BLOODSTEEL_AXE);       entries.add(ModItems.BLOODSTEEL_SHOVEL);
                            entries.add(ModItems.BLOODSTEEL_HOE);
                            entries.add(ModItems.FRONTIER_BREAKER);
                        })
                        .build());

        THE_RUINS_ITEMS = Registry.register(Registries.ITEM_GROUP,
                new Identifier(TheWorldRift.MOD_ID, "the_ruins_items"),
                FabricItemGroup.builder()
                        .displayName(Text.translatable("itemgroup.the_world_rift.the_ruins_items"))
                        .icon(() -> new ItemStack(ModItems.STEEL_PLATE))
                        .entries((displayContext, entries) -> {

                            entries.add(ModItems.STEEL_PLATE);
                            entries.add(ModBlocks.STEEL_BLOCK); entries.add(ModBlocks.HAZARD_BLOCK);
                            entries.add(ModBlocks.PLATE_BLOCK);
                        })
                        .build());



        ItemGroupEvents.modifyEntriesEvent(ItemGroups.OPERATOR).register(fabricItemGroupEntries -> {

             fabricItemGroupEntries.add(YEET);

        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(CLAYMORE);
            fabricItemGroupEntries.add(SCYTHE);
            fabricItemGroupEntries.add(HAMMER);
            fabricItemGroupEntries.add(DUAL_BLADE);
            fabricItemGroupEntries.add(HALBERD);
            fabricItemGroupEntries.add(KNIFE);
            fabricItemGroupEntries.add(GLAIVE);
        });
    }
}