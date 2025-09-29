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
    public static final ItemGroup THE_BLOOD_MOON_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TheWorldRift.MOD_ID, "blood_moon"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BLOOD_MOON))
                    .displayName(Text.translatable("itemgroup.the_world_rift.the_blood_moon_items"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.NETHERITE_NUGGET);
                        entries.add(ModItems.STINGER);
                        entries.add(ModItems.NETHER_STAR_SHARD);
                        entries.add(ModItems.NETHER_STAR_POWDER);
                        entries.add(ModItems.EMPTY_VIAL);
                        entries.add(ModItems.BLOOD_VIAL);
                        entries.add(ModItems.BLOOD_CRYSTAL);

                        entries.add(ModItems.ENCHANTED_CARROT);

                        entries.add(ModItems.BLOODSTAINED_INGOT);
                        entries.add(ModBlocks.BLOODSTAINED_BLOCK);

                        entries.add(ModItems.BLOODSTAINED_HELMET);
                        entries.add(ModItems.BLOODSTAINED_CHESTPLATE);
                        entries.add(ModItems.BLOODSTAINED_LEGGINGS);
                        entries.add(ModItems.BLOODSTAINED_BOOTS);

                        entries.add(ModItems.BLOODSTAINED_SWORD);
                        entries.add(ModItems.BROKEN_BLOODSTAINED_SWORD);
                        entries.add(ModItems.TRUE_BLOODSTAINED_SWORD);
                        entries.add(ModItems.BROKEN_BLOODSTAINED_SCYTHE);
                        entries.add(ModItems.BLOODSTAINED_SCYTHE);
                        entries.add(ModItems.BROKEN_BLOODSTAINED_HAMMER);
                        entries.add(ModItems.BLOODSTAINED_HAMMER);
                        entries.add(ModItems.BROKEN_BLOODSTAINED_DUAL_BLADE);
                        entries.add(ModItems.BLOODSTAINED_DUAL_BLADE);
                        entries.add(ModItems.BROKEN_BLOODSTAINED_HALBERD);
                        entries.add(ModItems.BLOODSTAINED_HALBERD);
                        entries.add(ModItems.BROKEN_BLOODSTAINED_KNIFE);
                        entries.add(ModItems.BLOODSTAINED_KNIFE);
                        entries.add(ModItems.BORDER_BREAKER);


                    }).build());

    public static final ItemGroup THE_WORLD_RIFT_DECORATION = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TheWorldRift.MOD_ID, "dungeon_bricks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.DUNGEON_BRICKS))
                    .displayName(Text.translatable("itemgroup.the_world_rift.the_world_rift_decoration"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModBlocks.ANCIENT_LIBRARY);

                        entries.add(ModBlocks.DUNGEON_BRICKS);
                        entries.add(ModBlocks.PORTAL_BLOCK);

                        entries.add(ModBlocks.BLACKSTONE_LETTER_A); entries.add(ModBlocks.BLACKSTONE_LETTER_B); entries.add(ModBlocks.BLACKSTONE_LETTER_C);
                        entries.add(ModBlocks.BLACKSTONE_LETTER_D); entries.add(ModBlocks.BLACKSTONE_LETTER_E); entries.add(ModBlocks.BLACKSTONE_LETTER_F);
                        entries.add(ModBlocks.BLACKSTONE_LETTER_G); entries.add(ModBlocks.BLACKSTONE_LETTER_H); entries.add(ModBlocks.BLACKSTONE_LETTER_I);
                        entries.add(ModBlocks.BLACKSTONE_LETTER_J); entries.add(ModBlocks.BLACKSTONE_LETTER_K); entries.add(ModBlocks.BLACKSTONE_LETTER_L);
                        entries.add(ModBlocks.BLACKSTONE_LETTER_M); entries.add(ModBlocks.BLACKSTONE_LETTER_N); entries.add(ModBlocks.BLACKSTONE_LETTER_O);
                        entries.add(ModBlocks.BLACKSTONE_LETTER_P); entries.add(ModBlocks.BLACKSTONE_LETTER_Q); entries.add(ModBlocks.BLACKSTONE_LETTER_R);
                        entries.add(ModBlocks.BLACKSTONE_LETTER_S); entries.add(ModBlocks.BLACKSTONE_LETTER_T); entries.add(ModBlocks.BLACKSTONE_LETTER_U);
                        entries.add(ModBlocks.BLACKSTONE_LETTER_V); entries.add(ModBlocks.BLACKSTONE_LETTER_W); entries.add(ModBlocks.BLACKSTONE_LETTER_X);
                        entries.add(ModBlocks.BLACKSTONE_LETTER_Y); entries.add(ModBlocks.BLACKSTONE_LETTER_Z);

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