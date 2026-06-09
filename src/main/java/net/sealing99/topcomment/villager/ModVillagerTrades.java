package net.sealing99.topcomment.villager;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.sealing99.topcomment.TopCommentMod;
import net.sealing99.topcomment.block.ModBlocks;
import net.sealing99.topcomment.item.ModItems;

public class ModVillagerTrades {
    public static void registerTrades() {
        TopCommentMod.LOGGER.info("Registering Villager Trades for " + TopCommentMod.MOD_ID);

        TradeOfferHelper.registerVillagerOffers(ModVillagers.SEAL, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.BANANA, 7),
                    new ItemStack(ModItems.CORN, 1),
                    10, 2, 0
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.BANANA, 3),
                    new ItemStack(ModItems.CORN_SEED, 1),
                    5, 3, 0
            ));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.SEAL, 2, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.BANANA, 14),
                    new ItemStack(ModItems.BAGUETTE, 1),
                    10, 3, 0
            ));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.SEAL, 3, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.BANANA, 28),
                    new ItemStack(ModItems.DORITO_BAG, 1),
                    3, 12, 0
            ));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.SEAL, 4, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.BANANA, 34),
                    new ItemStack(ModBlocks.TRIANGULAR_CAKE, 1),
                    2, 20, 0
            ));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.SEAL, 5, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModItems.BANANA, 54),
                    new ItemStack(ModBlocks.THUNDER_KING, 1),
                    1, 26, 0
            ));
        });
    }
}
