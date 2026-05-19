package net.sealing99.topcomment;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.sealing99.topcomment.datagen.ModLootTableProvider;
import net.sealing99.topcomment.datagen.ModModelProvider;
import net.sealing99.topcomment.datagen.ModRecipeProvider;

public class TopCommentModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModLootTableProvider::new);
	}
}
