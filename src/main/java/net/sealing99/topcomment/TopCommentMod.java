package net.sealing99.topcomment;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.sealing99.topcomment.block.ModBlocks;
import net.sealing99.topcomment.effect.ModEffects;
import net.sealing99.topcomment.item.ModItemGroups;
import net.sealing99.topcomment.item.ModItems;
import net.sealing99.topcomment.item.ModPotions;
import net.sealing99.topcomment.modify.ModLootModifier;
import net.sealing99.topcomment.villager.ModVillagerTrades;
import net.sealing99.topcomment.villager.ModVillagers;
import net.sealing99.topcomment.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TopCommentMod implements ModInitializer {
	public static final String MOD_ID = "topcomment";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModLootModifier.registerModifications();
		ModWorldGeneration.generateModWorldGen();
		ModEffects.registerEffects();
		ModPotions.registerPotions();
		ModVillagers.registerVillagers();
		ModVillagerTrades.registerTrades();

		CompostingChanceRegistry.INSTANCE.add(ModItems.CORN, 0.15f);
	}
}