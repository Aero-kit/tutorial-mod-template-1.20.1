package net.aerokit.tutorialmod.datagen;

import net.aerokit.tutorialmod.Item.ModItems;
import net.aerokit.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> RUBY_SMELTABLES = List.of(ModItems.RAW_RUBY, ModBlocks.RUBY_ORE,
            ModBlocks.DEEPSLATE_RUBY_ORE, ModBlocks.NETHER_RUBY_ORE, ModBlocks.END_STONE_RUBY_ORE);

    private static final List<ItemConvertible> CITRINE_SMELTABLES = List.of(ModItems.RAW_CITRINE, ModBlocks.CITRINE_ORE,
            ModBlocks.DEEPSLATE_CITRINE_ORE, ModBlocks.NETHER_CITRINE_ORE, ModBlocks.END_STONE_CITRINE_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        offerSmelting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
                0.7f, 200, "ruby");
        offerBlasting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
                0.7f, 100, "ruby");

        offerSmelting(exporter, CITRINE_SMELTABLES, RecipeCategory.MISC, ModItems.CITRINE,
                0.7f, 200, "citrine");
        offerBlasting(exporter, CITRINE_SMELTABLES, RecipeCategory.MISC, ModItems.CITRINE,
                0.7f, 100, "citrine");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY, RecipeCategory.DECORATIONS,
                ModBlocks.RUBY_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.CITRINE, RecipeCategory.DECORATIONS,
                ModBlocks.CITRINE_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.METAL_DETECTOR, 1)
                .pattern("   ")
                .pattern(" 1 ")
                .pattern("2  ")
                .input('1', Items.STICK)
                .input('2', Items.IRON_INGOT)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.METAL_DETECTOR)));
    }
}
