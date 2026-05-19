package net.sealing99.topcomment.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;
import net.sealing99.topcomment.block.ModBlocks;
import net.sealing99.topcomment.block.custom.CornCropBlock;
import net.sealing99.topcomment.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.TRIANGULAR_CAKE);
        addDrop(ModBlocks.THUNDER_KING);

        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.CORN_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(CornCropBlock.AGE, CornCropBlock.MAX_AGE-1));
        addDrop(ModBlocks.CORN_CROP, this.cropDrops(ModBlocks.CORN_CROP, ModItems.CORN, ModItems.CORN_SEED, builder2));
    }
}
