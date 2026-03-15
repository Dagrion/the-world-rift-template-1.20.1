package dagrion.the_world_rift.datagen;

import dagrion.the_world_rift.block.ModBlocks;
import dagrion.the_world_rift.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        // -----------------------
        // BASIC ITEMS / BLOCKS
        // -----------------------
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.NETHER_STAR_SHARD, 4)
                .input(Items.NETHER_STAR)
                .criterion(hasItem(ModItems.NETHER_STAR_SHARD), conditionsFromItem(ModItems.NETHER_STAR_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.NETHER_STAR_SHARD)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.NETHER_STAR, 1)
                .pattern("SS")
                .pattern("SS")
                .input('S', ModItems.NETHER_STAR_SHARD)
                .criterion(hasItem(ModItems.NETHER_STAR_SHARD), conditionsFromItem(ModItems.NETHER_STAR_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(Items.NETHER_STAR)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.NETHER_STAR_POWDER, 1)
                .input(ModItems.NETHER_STAR_SHARD)
                .criterion(hasItem(ModItems.NETHER_STAR_POWDER), conditionsFromItem(ModItems.NETHER_STAR_POWDER))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.NETHER_STAR_POWDER)));
        offerReversibleCompactingRecipes(exporter,
                RecipeCategory.MISC, ModItems.NETHERITE_NUGGET,
                RecipeCategory.MISC, Items.NETHERITE_INGOT );
        offerReversibleCompactingRecipes(exporter,
                RecipeCategory.MISC, ModItems.BLOODSTAINED_INGOT,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLOODSTAINED_BLOCK);
        offerReversibleCompactingRecipes(exporter,
                RecipeCategory.MISC, ModItems.BLOODSTEEL_INGOT,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLOODSTEEL_BLOCK );
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EMPTY_VIAL, 2)
                .pattern("D D")
                .pattern(" D ")
                .input('D', Items.DIAMOND)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.EMPTY_VIAL)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BLOOD_CRYSTAL, 2)
                .pattern("AVA")
                .pattern("ACA")
                .pattern("AAA")
                .input('C', ModItems.BLOOD_CRYSTAL)
                .input('V', ModItems.BLOOD_VIAL)
                .input('A', Items.AMETHYST_SHARD)
                .criterion(hasItem(ModItems.BLOOD_CRYSTAL), conditionsFromItem(ModItems.BLOOD_CRYSTAL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLOOD_CRYSTAL)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HARDENED_BLOOD_CRYSTAL, 2)
                .pattern("CC")
                .pattern("CC")
                .input('C', ModItems.HARDENED_BLOOD_CRYSTAL)
                .criterion(hasItem(ModItems.HARDENED_BLOOD_CRYSTAL), conditionsFromItem(ModItems.HARDENED_BLOOD_CRYSTAL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HARDENED_BLOOD_CRYSTAL)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_BLOCK, 1)
                .pattern("SS")
                .pattern("SS")
                .input('S', ModItems.STEEL_PLATE)
                .criterion(hasItem(ModItems.STEEL_PLATE), conditionsFromItem(ModItems.STEEL_PLATE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.STEEL_BLOCK)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STEEL_PLATE, 4)
                .input(ModBlocks.STEEL_BLOCK)
                .criterion(hasItem(ModBlocks.STEEL_BLOCK), conditionsFromItem(ModBlocks.STEEL_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.STEEL_PLATE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HAZARD_BLOCK, 5)
                .pattern("SYS")
                .pattern("YSB")
                .pattern("SBS")
                .input('Y', Items.YELLOW_DYE)
                .input('B', Items.BLACK_DYE)
                .input('S', ModBlocks.STEEL_BLOCK)
                .criterion(hasItem(ModBlocks.STEEL_BLOCK), conditionsFromItem(ModBlocks.STEEL_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.HAZARD_BLOCK)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PLATE_BLOCK, 1)
                .pattern(" S ")
                .pattern("SOS")
                .pattern(" S ")
                .input('O', Blocks.OBSIDIAN)
                .input('S', ModBlocks.STEEL_BLOCK)
                .criterion(hasItem(ModItems.STEEL_PLATE), conditionsFromItem(ModItems.STEEL_PLATE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PLATE_BLOCK)));
        // TOOLS
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.STINGER, 1)
                .pattern(" N")
                .pattern("N ")
                .input('N', ModItems.NETHERITE_NUGGET)
                .criterion(hasItem(ModItems.NETHERITE_NUGGET), conditionsFromItem(ModItems.NETHERITE_NUGGET))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.STINGER)));
        // WEAPONS
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CLAYMORE, 1)
                .pattern("  N")
                .pattern("NN ")
                .pattern("SN ")
                .input('N', Items.NETHERITE_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CLAYMORE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SCYTHE, 1)
                .pattern("NNN")
                .pattern(" SN")
                .pattern("S  ")
                .input('N', Items.NETHERITE_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SCYTHE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.HAMMER, 1)
                .pattern("NN ")
                .pattern("NSN")
                .pattern(" S ")
                .input('N', Items.NETHERITE_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HAMMER)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.DUAL_BLADE, 1)
                .pattern(" NN")
                .pattern(" S ")
                .pattern("NN ")
                .input('N', Items.NETHERITE_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DUAL_BLADE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.HALBERD, 1)
                .pattern("NNN")
                .pattern("NS ")
                .pattern(" S ")
                .input('N', Items.NETHERITE_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HALBERD)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.GLAIVE, 1)
                .pattern(" NN")
                .pattern("NN ")
                .pattern("S  ")
                .input('N', Items.NETHERITE_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GLAIVE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.KNIFE, 1)
                .pattern(" N")
                .pattern("S ")
                .input('N', Items.NETHERITE_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KNIFE)));
        // -----------------------
        // BLOODSTAINED
        // -----------------------
        // WEAPONS
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BLOODSTAINED_CLAYMORE, 1)
                .pattern(" VB")
                .pattern("SBV")
                .pattern("RS ")
                .input('R', ModItems.RUINED_BLOODSTAINED_SWORD)
                .input('B', ModItems.BLOODSTAINED_INGOT)
                .input('S', ModItems.NETHER_STAR_SHARD)
                .input('V', ModItems.BLOOD_VIAL)
                .criterion(hasItem(ModItems.BLOODSTAINED_CLAYMORE), conditionsFromItem(ModItems.BLOODSTAINED_CLAYMORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLOODSTAINED_CLAYMORE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BLOODSTAINED_SCYTHE, 1)
                .pattern("RVB")
                .pattern("VSS")
                .pattern("B  ")
                .input('R', ModItems.RUINED_BLOODSTAINED_SCYTHE)
                .input('B', ModItems.BLOODSTAINED_INGOT)
                .input('S', ModItems.NETHER_STAR_SHARD)
                .input('V', ModItems.BLOOD_VIAL)
                .criterion(hasItem(ModItems.BLOODSTAINED_SCYTHE), conditionsFromItem(ModItems.BLOODSTAINED_SCYTHE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLOODSTAINED_SCYTHE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BLOODSTAINED_HAMMER, 1)
                .pattern("BVB")
                .pattern("SRS")
                .pattern(" V ")
                .input('R', ModItems.RUINED_BLOODSTAINED_HAMMER)
                .input('B', ModItems.BLOODSTAINED_INGOT)
                .input('S', ModItems.NETHER_STAR_SHARD)
                .input('V', ModItems.BLOOD_VIAL)
                .criterion(hasItem(ModItems.BLOODSTAINED_HAMMER), conditionsFromItem(ModItems.BLOODSTAINED_HAMMER))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLOODSTAINED_HAMMER)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BLOODSTAINED_DUAL_BLADE, 1)
                .pattern(" VB")
                .pattern("SRS")
                .pattern("BV ")
                .input('R', ModItems.RUINED_BLOODSTAINED_DUAL_BLADE)
                .input('B', ModItems.BLOODSTAINED_INGOT)
                .input('S', ModItems.NETHER_STAR_SHARD)
                .input('V', ModItems.BLOOD_VIAL)
                .criterion(hasItem(ModItems.BLOODSTAINED_DUAL_BLADE), conditionsFromItem(ModItems.BLOODSTAINED_DUAL_BLADE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLOODSTAINED_DUAL_BLADE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BLOODSTAINED_HALBERD, 1)
                .pattern(" VB")
                .pattern("SBV")
                .pattern("RS ")
                .input('R', ModItems.RUINED_BLOODSTAINED_HALBERD)
                .input('B', ModItems.BLOODSTAINED_INGOT)
                .input('S', ModItems.NETHER_STAR_SHARD)
                .input('V', ModItems.BLOOD_VIAL)
                .criterion(hasItem(ModItems.BLOODSTAINED_HALBERD), conditionsFromItem(ModItems.BLOODSTAINED_HALBERD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLOODSTAINED_HALBERD)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BLOODSTAINED_GLAIVE, 1)
                .pattern(" SB")
                .pattern("VBS")
                .pattern("RV ")
                .input('R', ModItems.RUINED_BLOODSTAINED_GLAIVE)
                .input('B', ModItems.BLOODSTAINED_INGOT)
                .input('S', ModItems.NETHER_STAR_SHARD)
                .input('V', ModItems.BLOOD_VIAL)
                .criterion(hasItem(ModItems.BLOODSTAINED_GLAIVE), conditionsFromItem(ModItems.BLOODSTAINED_GLAIVE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLOODSTAINED_GLAIVE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BLOODSTAINED_KNIFE, 1)
                .pattern("SV")
                .pattern("RB")
                .input('R', ModItems.RUINED_BLOODSTAINED_KNIFE)
                .input('B', ModItems.BLOODSTAINED_INGOT)
                .input('S', ModItems.NETHER_STAR_SHARD)
                .input('V', ModItems.BLOOD_VIAL)
                .criterion(hasItem(ModItems.BLOODSTAINED_KNIFE), conditionsFromItem(ModItems.BLOODSTAINED_KNIFE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLOODSTAINED_KNIFE)));
        // BASIC
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.BLOOD_CRYSTAL),
                Ingredient.ofItems(Items.DIAMOND_HELMET),
                Ingredient.ofItems(ModItems.BLOODSTAINED_INGOT),
                RecipeCategory.COMBAT,
                ModItems.BLOODSTAINED_HELMET)
                .criterion(hasItem(ModItems.BLOODSTAINED_HELMET), conditionsFromItem(ModItems.BLOODSTAINED_HELMET))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLOODSTAINED_HELMET)));
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.BLOOD_CRYSTAL),
                        Ingredient.ofItems(Items.DIAMOND_CHESTPLATE),
                        Ingredient.ofItems(ModItems.BLOODSTAINED_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.BLOODSTAINED_CHESTPLATE)
                .criterion(hasItem(ModItems.BLOODSTAINED_CHESTPLATE), conditionsFromItem(ModItems.BLOODSTAINED_CHESTPLATE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLOODSTAINED_CHESTPLATE)));
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.BLOOD_CRYSTAL),
                        Ingredient.ofItems(Items.DIAMOND_LEGGINGS),
                        Ingredient.ofItems(ModItems.BLOODSTAINED_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.BLOODSTAINED_LEGGINGS)
                .criterion(hasItem(ModItems.BLOODSTAINED_LEGGINGS), conditionsFromItem(ModItems.BLOODSTAINED_LEGGINGS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLOODSTAINED_LEGGINGS)));
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.BLOOD_CRYSTAL),
                        Ingredient.ofItems(Items.DIAMOND_BOOTS),
                        Ingredient.ofItems(ModItems.BLOODSTAINED_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.BLOODSTAINED_BOOTS)
                .criterion(hasItem(ModItems.BLOODSTAINED_BOOTS), conditionsFromItem(ModItems.BLOODSTAINED_BOOTS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLOODSTAINED_BOOTS)));
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.BLOOD_CRYSTAL),
                        Ingredient.ofItems(Items.DIAMOND_SWORD),
                        Ingredient.ofItems(ModItems.BLOODSTAINED_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.BLOODSTAINED_SWORD)
                .criterion(hasItem(ModItems.BLOODSTAINED_SWORD), conditionsFromItem(ModItems.BLOODSTAINED_SWORD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLOODSTAINED_SWORD)));
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.BLOOD_CRYSTAL),
                        Ingredient.ofItems(Items.DIAMOND_AXE),
                        Ingredient.ofItems(ModItems.BLOODSTAINED_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.BLOODSTAINED_AXE)
                .criterion(hasItem(ModItems.BLOODSTAINED_AXE), conditionsFromItem(ModItems.BLOODSTAINED_AXE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLOODSTAINED_AXE)));
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.BLOOD_CRYSTAL),
                        Ingredient.ofItems(Items.DIAMOND_PICKAXE),
                        Ingredient.ofItems(ModItems.BLOODSTAINED_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.BLOODSTAINED_PICKAXE)
                .criterion(hasItem(ModItems.BLOODSTAINED_PICKAXE), conditionsFromItem(ModItems.BLOODSTAINED_PICKAXE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLOODSTAINED_PICKAXE)));
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.BLOOD_CRYSTAL),
                        Ingredient.ofItems(Items.DIAMOND_SHOVEL),
                        Ingredient.ofItems(ModItems.BLOODSTAINED_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.BLOODSTAINED_SHOVEL)
                .criterion(hasItem(ModItems.BLOODSTAINED_SHOVEL), conditionsFromItem(ModItems.BLOODSTAINED_SHOVEL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLOODSTAINED_SHOVEL)));
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.BLOOD_CRYSTAL),
                        Ingredient.ofItems(Items.DIAMOND_HOE),
                        Ingredient.ofItems(ModItems.BLOODSTAINED_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.BLOODSTAINED_HOE)
                .criterion(hasItem(ModItems.BLOODSTAINED_HOE), conditionsFromItem(ModItems.BLOODSTAINED_HOE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLOODSTAINED_HOE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BORDER_BREAKER, 1)
                .pattern("B B")
                .pattern("SVS")
                .pattern(" B ")
                .input('B', ModItems.BLOODSTAINED_INGOT)
                .input('S', ModItems.NETHER_STAR_SHARD)
                .input('V', ModItems.BLOOD_VIAL)
                .criterion(hasItem(ModItems.BORDER_BREAKER), conditionsFromItem(ModItems.BORDER_BREAKER))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BORDER_BREAKER)));

        // -----------------------
        // BLOODSTEEL
        // -----------------------
        // BASIC
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.HARDENED_BLOOD_CRYSTAL),
                        Ingredient.ofItems(ModItems.BLOODSTAINED_HELMET),
                        Ingredient.ofItems(ModItems.BLOODSTEEL_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.BLOODSTEEL_HELMET)
                .criterion(hasItem(ModItems.BLOODSTEEL_HELMET), conditionsFromItem(ModItems.BLOODSTEEL_HELMET))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLOODSTEEL_HELMET)));
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.HARDENED_BLOOD_CRYSTAL),
                        Ingredient.ofItems(ModItems.BLOODSTAINED_CHESTPLATE),
                        Ingredient.ofItems(ModItems.BLOODSTEEL_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.BLOODSTEEL_CHESTPLATE)
                .criterion(hasItem(ModItems.BLOODSTEEL_CHESTPLATE), conditionsFromItem(ModItems.BLOODSTEEL_CHESTPLATE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLOODSTEEL_CHESTPLATE)));
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.HARDENED_BLOOD_CRYSTAL),
                        Ingredient.ofItems(ModItems.BLOODSTAINED_LEGGINGS),
                        Ingredient.ofItems(ModItems.BLOODSTEEL_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.BLOODSTEEL_LEGGINGS)
                .criterion(hasItem(ModItems.BLOODSTEEL_LEGGINGS), conditionsFromItem(ModItems.BLOODSTEEL_LEGGINGS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLOODSTEEL_LEGGINGS)));
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.HARDENED_BLOOD_CRYSTAL),
                        Ingredient.ofItems(ModItems.BLOODSTAINED_BOOTS),
                        Ingredient.ofItems(ModItems.BLOODSTEEL_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.BLOODSTEEL_BOOTS)
                .criterion(hasItem(ModItems.BLOODSTEEL_BOOTS), conditionsFromItem(ModItems.BLOODSTEEL_BOOTS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLOODSTEEL_BOOTS)));
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.HARDENED_BLOOD_CRYSTAL),
                        Ingredient.ofItems(ModItems.BLOODSTAINED_SWORD),
                        Ingredient.ofItems(ModItems.BLOODSTEEL_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.BLOODSTEEL_SWORD)
                .criterion(hasItem(ModItems.BLOODSTEEL_SWORD), conditionsFromItem(ModItems.BLOODSTEEL_SWORD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLOODSTEEL_SWORD)));
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.HARDENED_BLOOD_CRYSTAL),
                        Ingredient.ofItems(ModItems.BLOODSTAINED_AXE),
                        Ingredient.ofItems(ModItems.BLOODSTEEL_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.BLOODSTEEL_AXE)
                .criterion(hasItem(ModItems.BLOODSTEEL_AXE), conditionsFromItem(ModItems.BLOODSTEEL_AXE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLOODSTEEL_AXE)));
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.HARDENED_BLOOD_CRYSTAL),
                        Ingredient.ofItems(ModItems.BLOODSTAINED_PICKAXE),
                        Ingredient.ofItems(ModItems.BLOODSTEEL_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.BLOODSTEEL_PICKAXE)
                .criterion(hasItem(ModItems.BLOODSTEEL_PICKAXE), conditionsFromItem(ModItems.BLOODSTEEL_PICKAXE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLOODSTEEL_PICKAXE)));
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.HARDENED_BLOOD_CRYSTAL),
                        Ingredient.ofItems(ModItems.BLOODSTAINED_SHOVEL),
                        Ingredient.ofItems(ModItems.BLOODSTEEL_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.BLOODSTEEL_SHOVEL)
                .criterion(hasItem(ModItems.BLOODSTEEL_SHOVEL), conditionsFromItem(ModItems.BLOODSTEEL_SHOVEL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLOODSTEEL_SHOVEL)));
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.HARDENED_BLOOD_CRYSTAL),
                        Ingredient.ofItems(ModItems.BLOODSTAINED_HOE),
                        Ingredient.ofItems(ModItems.BLOODSTEEL_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.BLOODSTEEL_HOE)
                .criterion(hasItem(ModItems.BLOODSTEEL_HOE), conditionsFromItem(ModItems.BLOODSTEEL_HOE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLOODSTEEL_HOE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.FRONTIER_BREAKER, 1)
                .pattern("B B")
                .pattern("SVS")
                .pattern(" B ")
                .input('B', ModItems.BLOODSTEEL_INGOT)
                .input('S', ModItems.NETHER_STAR_SHARD)
                .input('V', ModItems.BLOOD_VIAL)
                .criterion(hasItem(ModItems.FRONTIER_BREAKER), conditionsFromItem(ModItems.FRONTIER_BREAKER))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FRONTIER_BREAKER)));

    }
}
