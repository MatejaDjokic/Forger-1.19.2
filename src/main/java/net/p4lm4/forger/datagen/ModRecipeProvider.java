package net.p4lm4.forger.datagen;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.p4lm4.forger.block.ModBlocks;
import net.p4lm4.forger.item.ModItems;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {

        // 9->1 & 1->9 PACKING AND UNPACKING CRAFTING
        nineBlockStorageRecipes(consumer, ModItems.MALVANITE_INGOT.get(), ModBlocks.MALVANITE_BLOCK.get(),
                "malvanite_block_from_malvanite_ingot", "malvanite_block",
                "malvanite_ingots_from_malvanite_block", "malvanite_ingot");
        nineBlockStorageRecipes(consumer, ModItems.MALVANITE_CRYSTAL.get(), ModBlocks.MALVANITE_CRYSTAL_BLOCK.get(),
                "malvanite_crystal_block_from_malvanite_crystal", "malvanite_crystal_block",
                "malvanite_crystal_from_malvanite_crystal_block", "malvanite_crystal");
        nineBlockStorageRecipes(consumer, ModItems.RAW_MALVANITE.get(), ModBlocks.RAW_MALVANITE_BLOCK.get(),
                "raw_malvanite_block_from_raw_malvanite", "raw_malvanite_block",
                "raw_malvanite_from_raw_malvanite_block", "raw_malvanite");
        nineBlockStorageRecipes(consumer, ModItems.MALVANITE_NUGGET.get(), ModItems.MALVANITE_INGOT.get(),
                "malvanite_ingot_from_malvanite_nugget", "malvanite_ingot",
                "malvanite_nugget_from_malvanite_ingot", "malvanite_nugget");

        // SMELTING
        oreSmelting(consumer, List.of(ModItems.RAW_MALVANITE.get()),
                ModItems.MALVANITE_INGOT.get(), 0.7f, 200, "malvanite_ingot_from_raw");
        oreSmelting(consumer, List.of(ModBlocks.MALVANITE_ORE.get()),
                ModItems.MALVANITE_INGOT.get(), 0.7f, 200, "malvanite_ingot_from_ore");
        oreSmelting(consumer, List.of(ModBlocks.DEEPSLATE_MALVANITE_ORE.get()),
                ModItems.MALVANITE_INGOT.get(), 0.7f, 200, "malvanite_ingot_from_deep_ore");

        oreSmelting(consumer, List.of(ModBlocks.MALVANITE_CRYSTAL_ORE.get()),
                ModItems.MALVANITE_CRYSTAL.get(), 0.7f, 200, "malvanite_crystal_from_ore");
        oreSmelting(consumer, List.of(ModBlocks.DEEPSLATE_MALVANITE_CRYSTAL_ORE.get()),
                ModItems.MALVANITE_CRYSTAL.get(), 0.7f, 200, "malvanite_crystal_from_deep_ore");

        oreSmelting(consumer, List.of(ModBlocks.COMPOUND_TUFF.get()),
                ModItems.TUFF_COMPOUND.get(), 0.7f, 200, "tuff_compound_from_compound_tuff");
        oreSmelting(consumer, List.of(ModBlocks.COMPOUND_CALCITE.get()),
                ModItems.CALCITE_COMPOUND.get(), 0.7f, 200, "calcite_compound_from_compound_calcite");
        oreSmelting(consumer, List.of(ModBlocks.COMPOUND_DRIPSTONE.get()),
                ModItems.DRIPSTONE_COMPOUND.get(), 0.7f, 200, "dripstone_compound_from_compound_dripstone");

        oreSmelting(consumer, List.of(ModBlocks.TUFF_BRICKS.get()),
                ModBlocks.CRACKED_CALCITE_BRICKS.get(), 0.7f, 200, "cracked_calcite_bricks_from_calcite_bricks");
        oreSmelting(consumer, List.of(ModBlocks.CALCITE_BRICKS.get()),
                ModBlocks.CRACKED_DRIPSTONE_BRICKS.get(), 0.7f, 200, "cracked_dripstone_bricks_from_dripstone_bricks");
        oreSmelting(consumer, List.of(ModBlocks.DRIPSTONE_BRICKS.get()),
                ModBlocks.CRACKED_DRIPSTONE_BRICKS.get(), 0.7f, 200, "cracked_dripstone_bricks_from_dripstone_bricks");

        // BLASTING
        oreBlasting(consumer, List.of(ModItems.RAW_MALVANITE.get()),
                ModItems.MALVANITE_INGOT.get(), 0.7f, 100, "malvanite_ingot_from_raw");
        oreBlasting(consumer, List.of(ModBlocks.MALVANITE_ORE.get()),
                ModItems.MALVANITE_INGOT.get(), 0.7f, 100, "malvanite_ingot_ore");
        oreBlasting(consumer, List.of(ModBlocks.DEEPSLATE_MALVANITE_ORE.get()),
                ModItems.MALVANITE_INGOT.get(), 0.7f, 100, "malvanite_ingot_deep_ore");

        oreBlasting(consumer, List.of(ModBlocks.MALVANITE_CRYSTAL_ORE.get()),
                ModItems.MALVANITE_CRYSTAL.get(), 0.7f, 100, "malvanite_crystal_from_ore");
        oreBlasting(consumer, List.of(ModBlocks.DEEPSLATE_MALVANITE_CRYSTAL_ORE.get()),
                ModItems.MALVANITE_CRYSTAL.get(), 0.7f, 100, "malvanite_crystal_from_deep_ore");

        oreBlasting(consumer, List.of(ModBlocks.COMPOUND_TUFF.get()),
                ModItems.TUFF_COMPOUND.get(), 0.7f, 100, "tuff_compound_from_compound_tuff");
        oreBlasting(consumer, List.of(ModBlocks.COMPOUND_CALCITE.get()),
                ModItems.CALCITE_COMPOUND.get(), 0.7f, 100, "calcite_compound_from_compound_calcite");
        oreBlasting(consumer, List.of(ModBlocks.COMPOUND_DRIPSTONE.get()),
                ModItems.DRIPSTONE_COMPOUND.get(), 0.7f, 100, "dripstone_compound_from_compound_dripstone");

        // CUSTOM CRAFTING
        ShapedRecipeBuilder.shaped(ModBlocks.MALVANITE_LAMP.get(), 1)
                .define('c', ModItems.MALVANITE_CRYSTAL.get())
                .define('n', ModItems.MALVANITE_NUGGET.get())
                .define('l', Items.REDSTONE_LAMP)
                .pattern("cnc")
                .pattern("nln")
                .pattern("cnc")
                .unlockedBy("has_redstone_lamp", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.REDSTONE_LAMP).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.COMPOUND_TUFF.get(), 1)
                .define('a', Blocks.TUFF)
                .define('b', ModBlocks.POLISHED_TUFF.get())
                .define('c', ModBlocks.TUFF_BRICKS.get())
                .define('d', ModBlocks.CRACKED_TUFF_BRICKS.get())
                .define('e', ModBlocks.TUFF_TILES.get())
                .define('f', ModBlocks.CRACKED_TUFF_TILES.get())
                .pattern("daf")
                .pattern("aba")
                .pattern("cae")
                .unlockedBy("has_cracked_tuff_tiles", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.CRACKED_TUFF_TILES.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.COMPOUND_CALCITE.get(), 1)
                .define('a', Blocks.CALCITE)
                .define('b', ModBlocks.POLISHED_CALCITE.get())
                .define('c', ModBlocks.CALCITE_BRICKS.get())
                .define('d', ModBlocks.CRACKED_CALCITE_BRICKS.get())
                .define('e', ModBlocks.CALCITE_TILES.get())
                .define('f', ModBlocks.CRACKED_CALCITE_TILES.get())
                .pattern("daf")
                .pattern("aba")
                .pattern("cae")
                .unlockedBy("has_cracked_calcite_tiles", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.CRACKED_CALCITE_TILES.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.COMPOUND_DRIPSTONE.get(), 1)
                .define('a', Blocks.DRIPSTONE_BLOCK)
                .define('b', ModBlocks.POLISHED_DRIPSTONE.get())
                .define('c', ModBlocks.DRIPSTONE_BRICKS.get())
                .define('d', ModBlocks.CRACKED_DRIPSTONE_BRICKS.get())
                .define('e', ModBlocks.DRIPSTONE_TILES.get())
                .define('f', ModBlocks.CRACKED_DRIPSTONE_TILES.get())
                .pattern("daf")
                .pattern("aba")
                .pattern("cae")
                .unlockedBy("has_cracked_dripstone_tiles", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.CRACKED_DRIPSTONE_TILES.get()).build()))
                .save(consumer);

        // 2x2 Crafting
        ShapedRecipeBuilder.shaped(ModBlocks.POLISHED_TUFF.get(), 4)
                .define('#', Blocks.TUFF)
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_tuff", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Blocks.TUFF).build()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.TUFF_BRICKS.get(), 4)
                .define('#', ModBlocks.POLISHED_TUFF.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_polished_tuff", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.POLISHED_TUFF.get()).build()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.TUFF_TILES.get(), 4)
                .define('#', ModBlocks.TUFF_BRICKS.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_tuff_bricks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.TUFF_BRICKS.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.POLISHED_CALCITE.get(), 4)
                .define('#', Blocks.CALCITE)
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_calcite", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Blocks.CALCITE).build()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.CALCITE_BRICKS.get(), 4)
                .define('#', ModBlocks.POLISHED_CALCITE.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_polished_calcite", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.POLISHED_CALCITE.get()).build()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.CALCITE_TILES.get(), 4)
                .define('#', ModBlocks.CALCITE_BRICKS.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_calcite_bricks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.CALCITE_BRICKS.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.POLISHED_DRIPSTONE.get(), 4)
                .define('#', Blocks.DRIPSTONE_BLOCK)
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_dripstone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Blocks.DRIPSTONE_BLOCK).build()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.DRIPSTONE_BRICKS.get(), 4)
                .define('#', ModBlocks.POLISHED_DRIPSTONE.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_polished_dripstone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.POLISHED_DRIPSTONE.get()).build()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.DRIPSTONE_TILES.get(), 4)
                .define('#', ModBlocks.DRIPSTONE_BRICKS.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_dripstone_bricks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.DRIPSTONE_BRICKS.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModItems.MALVANITE_ALLOY.get(), 2)
                .define('c', ModBlocks.MALVANITE_CRYSTAL_BLOCK.get())
                .define('m', ModBlocks.MALVANITE_BLOCK.get())
                .pattern("cm")
                .pattern("mc")
                .group("malvanite_alloy_from_2x2")
                .unlockedBy("has_malvanite_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.MALVANITE_BLOCK.get()).build()))
                .unlockedBy("has_malvanite_crystal_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.MALVANITE_CRYSTAL_BLOCK.get()).build()))
                .save(consumer);
    }
}
