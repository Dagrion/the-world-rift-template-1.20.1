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

    public static ItemGroup THE_BLOOD_ALCHEMIST;
    public static ItemGroup THE_WORLD_RIFT_DECORATION;
    public static ItemGroup THE_RUINS_ITEMS;
    public static ItemGroup THE_SEVEN_CALAMITY_ITEMS;
    public static ItemGroup THE_GLITCH_ITEMS;

    public static void registerItemGroups() {
        TheWorldRift.LOGGER.info("Registering Item Groups for " + TheWorldRift.MOD_ID);

        THE_BLOOD_ALCHEMIST = Registry.register(Registries.ITEM_GROUP,
                new Identifier(TheWorldRift.MOD_ID, "the_blood_alchemist_items"),
                FabricItemGroup.builder()
                        .displayName(Text.translatable("itemgroup.the_world_rift.the_blood_alchemist_items"))
                        .icon(() -> new ItemStack(ModItems.BLOOD_VIAL))
                        .entries((displayContext, entries) -> {
                            entries.add(ModItems.NETHERITE_NUGGET);
                            entries.add(ModItems.STINGER);
                            entries.add(ModItems.NETHER_STAR_SHARD);
                            entries.add(ModItems.NETHER_STAR_POWDER);
                            entries.add(ModItems.EMPTY_VIAL);
                            entries.add(ModItems.BLOOD_VIAL);
                            entries.add(ModItems.BLOOD_CRYSTAL);
                            entries.add(ModItems.HARDENED_BLOOD_CRYSTAL);

                            entries.add(ModItems.ENCHANTED_CARROT);

                            entries.add(ModItems.BLOODSTAINED_INGOT);
                            entries.add(ModBlocks.BLOODSTAINED_BLOCK);
                            entries.add(ModItems.BLOODSTEEL_INGOT);
                            entries.add(ModBlocks.BLOODSTEEL_BLOCK);

                            entries.add(ModItems.BLOODSTAINED_HELMET);
                            entries.add(ModItems.BLOODSTAINED_CHESTPLATE);
                            entries.add(ModItems.BLOODSTAINED_LEGGINGS);
                            entries.add(ModItems.BLOODSTAINED_BOOTS);
                            entries.add(ModItems.BLOODSTEEL_HELMET);
                            entries.add(ModItems.BLOODSTEEL_CHESTPLATE);
                            entries.add(ModItems.BLOODSTEEL_LEGGINGS);
                            entries.add(ModItems.BLOODSTEEL_BOOTS);

                            entries.add(ModItems.BLOODSTAINED_SWORD);
                            entries.add(ModItems.BLOODSTEEL_SWORD);
                            entries.add(ModItems.RUINED_BLOODSTAINED_SWORD);
                            entries.add(ModItems.TRUE_BLOODSTAINED_SWORD);
                            entries.add(ModItems.RUINED_BLOODSTAINED_SCYTHE);
                            entries.add(ModItems.BLOODSTAINED_SCYTHE);
                            entries.add(ModItems.RUINED_BLOODSTAINED_HAMMER);
                            entries.add(ModItems.BLOODSTAINED_HAMMER);
                            entries.add(ModItems.RUINED_BLOODSTAINED_DUAL_BLADE);
                            entries.add(ModItems.BLOODSTAINED_DUAL_BLADE);
                            entries.add(ModItems.RUINED_BLOODSTAINED_HALBERD);
                            entries.add(ModItems.BLOODSTAINED_HALBERD);
                            entries.add(ModItems.RUINED_BLOODSTAINED_KNIFE);
                            entries.add(ModItems.BLOODSTAINED_KNIFE);

                            entries.add(ModItems.BORDER_BREAKER);
                        })
                        .build());

        THE_WORLD_RIFT_DECORATION = Registry.register(Registries.ITEM_GROUP,
                new Identifier(TheWorldRift.MOD_ID, "the_world_rift_decoration"),
                FabricItemGroup.builder()
                        .displayName(Text.translatable("itemgroup.the_world_rift.the_world_rift_decoration"))
                        .icon(() -> new ItemStack(ModBlocks.BLOODSTAINED_BLOCK))
                        .entries((displayContext, entries) -> {
                            entries.add(ModBlocks.BLOODSTAINED_BLOCK);
                            entries.add(ModBlocks.BLOODSTEEL_BLOCK);
                            entries.add(ModBlocks.PORTAL_BLOCK);
                        })
                        .build());

        THE_RUINS_ITEMS = Registry.register(Registries.ITEM_GROUP,
                new Identifier(TheWorldRift.MOD_ID, "the_ruins_items"),
                FabricItemGroup.builder()
                        .displayName(Text.translatable("itemgroup.the_world_rift.the_ruins_items"))
                        .icon(() -> new ItemStack(ModItems.BORDER_BREAKER))
                        .entries((displayContext, entries) -> {
                            entries.add(ModItems.BORDER_BREAKER);
                        })
                        .build());

        THE_SEVEN_CALAMITY_ITEMS = Registry.register(Registries.ITEM_GROUP,
                new Identifier(TheWorldRift.MOD_ID, "the_seven_calamity_items"),
                FabricItemGroup.builder()
                        .displayName(Text.translatable("itemgroup.the_world_rift.the_seven_calamity_items"))
                        .icon(() -> new ItemStack(ModItems.DRAGON_HEART))
                        .entries((displayContext, entries) -> {
                            entries.add(ModItems.DRAGON_HEART);
                        })
                        .build());

        THE_GLITCH_ITEMS = Registry.register(Registries.ITEM_GROUP,
                new Identifier(TheWorldRift.MOD_ID, "the_glitch_items"),
                FabricItemGroup.builder()
                        .displayName(Text.translatable("itemgroup.the_world_rift.the_glitch_items"))
                        .icon(() -> new ItemStack(ModItems.GLITCHED_BLOOD))
                        .entries((displayContext, entries) -> {
                            entries.add(ModItems.GLITCHED_BLOOD);
                        })
                        .build());
    }
}
