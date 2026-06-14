package net.sealing99.topcomment.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
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

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TEN_THOUSAND_TNT);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.EMERITE_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BANANA, Models.GENERATED);
        itemModelGenerator.register(ModItems.DORITO, Models.GENERATED);
        itemModelGenerator.register(ModItems.DORITO_BAG, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORN, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMERITE_INGOT, Models.GENERATED);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.EMERITE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.EMERITE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.EMERITE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.EMERITE_BOOTS);
    }
}
