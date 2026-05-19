package net.sealing99.topcomment.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.sealing99.topcomment.block.ModBlocks;
import net.sealing99.topcomment.block.custom.CornCropBlock;
import net.sealing99.topcomment.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.THUNDER_KING);

        blockStateModelGenerator.registerCrop(ModBlocks.CORN_CROP, CornCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BANANA, Models.GENERATED);
        itemModelGenerator.register(ModItems.DORITO, Models.GENERATED);
        itemModelGenerator.register(ModItems.DORITO_BAG, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORN, Models.GENERATED);
        // SEEDS ARE AUTOMATICALLY GENERATED
    }
}
