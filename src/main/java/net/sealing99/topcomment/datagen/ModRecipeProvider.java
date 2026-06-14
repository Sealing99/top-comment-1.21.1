package net.sealing99.topcomment.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.sealing99.topcomment.TopCommentMod;
import net.sealing99.topcomment.block.ModBlocks;
import net.sealing99.topcomment.item.ModItems;
import net.sealing99.topcomment.effect.ModPotions;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BAGUETTE, 1)
                .pattern("  B")
                .pattern(" B ")
                .pattern("B  ")
                .input('B', Items.BREAD)
                .criterion(hasItem(Items.BREAD), conditionsFromItem(Items.BREAD))
                .offerTo(exporter, Identifier.of(TopCommentMod.MOD_ID, "baguette"));

        // Dorito from 4 corn_seed
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.DORITO, 1)
                .pattern("SS")
                .pattern("SS")
                .input('S', ModItems.CORN_SEED)
                .criterion(hasItem(ModItems.CORN_SEED), conditionsFromItem(ModItems.CORN_SEED))
                .offerTo(exporter, Identifier.of(TopCommentMod.MOD_ID, "dorito_from_seeds"));

        // 9 Dorito into 1 Bag
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DORITO_BAG, 1)
                .pattern("DDD")
                .pattern("DDD")
                .pattern("DDD")
                .input('D', ModItems.DORITO)
                .criterion(hasItem(ModItems.DORITO), conditionsFromItem(ModItems.DORITO))
                .offerTo(exporter, Identifier.of(TopCommentMod.MOD_ID, "dorito_bag_from_doritos"));

        // Dorito Bag into 9 Dorito
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.DORITO, 9)
                .input(ModItems.DORITO_BAG)
                .criterion(hasItem(ModItems.DORITO_BAG), conditionsFromItem(ModItems.DORITO_BAG))
                .offerTo(exporter, Identifier.of(TopCommentMod.MOD_ID, "dorito_from_bag"));

        // Corn -> 9 Corn Seeds
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CORN_SEED, 9)
                .input(ModItems.CORN)
                .criterion(hasItem(ModItems.CORN), conditionsFromItem(ModItems.CORN))
                .offerTo(exporter, Identifier.of(TopCommentMod.MOD_ID, "corn_seed"));

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(Potions.AWKWARD, ModItems.DORITO_BAG, ModPotions.MOVEMENT_POTION);
        });

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.DIAMOND_SHARD, RecipeCategory.MISC, Items.DIAMOND);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SLINGSHOT, 1)
                .pattern("ISI")
                .pattern(" I ")
                .pattern(" I ")
                .input('I', Items.STICK)
                .input('S', Items.STRING)
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .offerTo(exporter);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.EMERITE_INGOT, RecipeCategory.MISC, ModBlocks.EMERITE_BLOCK);

        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.EMPTY,
                Ingredient.ofItems(Items.NETHERITE_INGOT),
                Ingredient.ofItems(Items.EMERALD),
                RecipeCategory.MISC,
                ModItems.EMERITE_INGOT
        )
        .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
        .offerTo(exporter, "emerite_smithing_table");

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.EMPTY,
                        Ingredient.ofItems(Items.NETHERITE_HELMET),
                        Ingredient.ofItems(ModItems.EMERITE_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.EMERITE_HELMET
                )
                .criterion(hasItem(ModItems.EMERITE_INGOT), conditionsFromItem(ModItems.EMERITE_INGOT))
                .offerTo(exporter, Identifier.of(TopCommentMod.MOD_ID, "emerite_helmet_smithing"));
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.EMPTY,
                        Ingredient.ofItems(Items.NETHERITE_CHESTPLATE),
                        Ingredient.ofItems(ModItems.EMERITE_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.EMERITE_CHESTPLATE
                )
                .criterion(hasItem(ModItems.EMERITE_INGOT), conditionsFromItem(ModItems.EMERITE_INGOT))
                .offerTo(exporter, Identifier.of(TopCommentMod.MOD_ID, "emerite_chestplate_smithing"));
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.EMPTY,
                        Ingredient.ofItems(Items.NETHERITE_LEGGINGS),
                        Ingredient.ofItems(ModItems.EMERITE_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.EMERITE_LEGGINGS
                )
                .criterion(hasItem(ModItems.EMERITE_INGOT), conditionsFromItem(ModItems.EMERITE_INGOT))
                .offerTo(exporter, Identifier.of(TopCommentMod.MOD_ID, "emerite_leggings_smithing"));
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.EMPTY,
                        Ingredient.ofItems(Items.NETHERITE_BOOTS),
                        Ingredient.ofItems(ModItems.EMERITE_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.EMERITE_BOOTS
                )
                .criterion(hasItem(ModItems.EMERITE_INGOT), conditionsFromItem(ModItems.EMERITE_INGOT))
                .offerTo(exporter, Identifier.of(TopCommentMod.MOD_ID, "emerite_boots_smithing"));
    }
}
