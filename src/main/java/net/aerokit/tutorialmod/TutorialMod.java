package net.aerokit.tutorialmod;

import net.aerokit.tutorialmod.Item.ModItemGroups;
import net.aerokit.tutorialmod.Item.ModItems;
import net.aerokit.tutorialmod.block.ModBlocks;
import net.aerokit.tutorialmod.block.entity.ModBlockEntities;
import net.aerokit.tutorialmod.entity.ModEntities;
import net.aerokit.tutorialmod.entity.custom.PorcupineEntity;
import net.aerokit.tutorialmod.recipe.ModRecipes;
import net.aerokit.tutorialmod.screen.ModScreenHandlers;
import net.aerokit.tutorialmod.sound.ModSounds;
import net.aerokit.tutorialmod.util.ModCustomTrades;
import net.aerokit.tutorialmod.util.ModLootTableModifiers;
import net.aerokit.tutorialmod.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModLootTableModifiers.modifyLootTables();
		ModCustomTrades.registerCustomTrades();

		ModVillagers.registerVillagers();
		ModSounds.registerSounds();

		FabricDefaultAttributeRegistry.register(ModEntities.PORCUPINE, PorcupineEntity.createPorcupineAttributes());
		ModBlockEntities.registerBlockEntities();

		ModScreenHandlers.registerScreenHandlers();
		ModRecipes.registerRecipes();

		FuelRegistry.INSTANCE.add(ModItems.COAL_BRIQUETTE, 200);
	}
}