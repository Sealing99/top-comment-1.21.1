package net.sealing99.topcomment.modify;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.block.Blocks;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.registry.RegistryKey;
import net.sealing99.topcomment.item.ModItems;

public class ModLootModifier {
    private static final RegistryKey<LootTable> jungleLeavesLootTableKey = Blocks.JUNGLE_LEAVES.getLootTableKey();

    public static void registerModifications() {
        LootTableEvents.MODIFY.register(((key, tableBuilder, source, registries) -> {
            if (source.isBuiltin() && jungleLeavesLootTableKey.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .with(ItemEntry.builder(ModItems.BANANA));

                tableBuilder.pool(poolBuilder);
            }
        }));
    }
}
