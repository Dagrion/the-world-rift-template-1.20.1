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
    public static final ItemGroup THE_SCARLET_REALM_BEHIND_THE_DARK_VEIL_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TheWorldRift.MOD_ID, "blood_moon"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BLOOD_MOON))
                    .displayName(Text.translatable("itemgroup.the_world_rift.the_blood_moon_items"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.ENCHANTED_CARROT);

                        entries.add(ModItems.NETHERITE_NUGGET);
                        entries.add(ModItems.STINGER);
                        entries.add(ModItems.END_STONE_DUST);
                        entries.add(ModItems.NETHER_STAR_SHARD);
                        entries.add(ModItems.NETHER_STAR_POWDER);
                        entries.add(ModItems.MOON_DUST);
                        entries.add(ModItems.BLOOD_MOON_DUST);
                        entries.add(ModItems.BLOOD_MOON);
                        entries.add(ModItems.EMPTY_VIAL);
                        entries.add(ModItems.BLOOD_VIAL);
                        entries.add(ModItems.BLOOD_CRYSTAL);
                        entries.add(ModItems.BLOODY_INGOT);

                        entries.add(ModBlocks.BLOODY_BLOCK);
                        entries.add(ModItems.BLOODY_HELMET);
                        entries.add(ModItems.BLOODY_CHESTPLATE);
                        entries.add(ModItems.BLOODY_LEGGINGS);
                        entries.add(ModItems.BLOODY_BOOTS);
                        entries.add(ModItems.BORDER_BREAKER);
                        entries.add(ModItems.BLOODY_SWORD);

                        entries.add(ModItems.BROKEN_BLOODY_SWORD);
                        entries.add(ModItems.BROKEN_BLOODY_SCYTHE);
                        entries.add(ModItems.BROKEN_BLOODY_HAMMER);
                        entries.add(ModItems.BROKEN_BLOODY_DUAL_BLADE);
                        entries.add(ModItems.BROKEN_BLOODY_GLAIVE);
                        entries.add(ModItems.BROKEN_BLOODY_TRIDENT);
                        entries.add(ModItems.BROKEN_BLOODY_KNIFE);

                        entries.add(ModItems.TRUE_BLOODY_SWORD);
                        entries.add(ModItems.BLOODY_SCYTHE);
                        entries.add(ModItems.BLOODY_HAMMER);
                        entries.add(ModItems.BLOODY_DUAL_BLADE);
                        entries.add(ModItems.BLOODY_GLAIVE);
                        entries.add(ModItems.BLOODY_TRIDENT);
                        entries.add(ModItems.BLOODY_KNIFE);

                        entries.add(ModItems.FLESH_PILE);

                    }).build());

    public static final ItemGroup THE_RUINS_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TheWorldRift.MOD_ID, "Bloodstel_ingot"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BLOODSTEEL_INGOT))
                    .displayName(Text.translatable("itemgroup.the_world_rift.the_ruins_items"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.BLOODSTEEL_INGOT);
                        entries.add(ModItems.HARDENED_BLOOD_CRYSTAL);

                        entries.add(ModItems.BLOODSTEEL_HELMET);
                        entries.add(ModItems.BLOODSTEEL_CHESTPLATE);
                        entries.add(ModItems.BLOODSTEEL_LEGGINGS);
                        entries.add(ModItems.BLOODSTEEL_BOOTS);

                        entries.add(ModItems.BLOODSTEEL_SWORD);


                    }).build());

    public static final ItemGroup THE_SEVEN_CALAMITY_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TheWorldRift.MOD_ID, "dragon_heart"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.DRAGON_HEART))
                    .displayName(Text.translatable("itemgroup.the_world_rift.the_seven_calamity_items"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.BLOOD_OF_THE_IMMORTAL);
                        entries.add(ModItems.DRAGON_HEART);
                        entries.add(ModItems.DARK_CLOTH);

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