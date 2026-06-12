package net.sealing99.topcomment.item;

import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sealing99.topcomment.TopCommentMod;
import net.sealing99.topcomment.block.ModBlocks;
import net.sealing99.topcomment.item.custom.SlingshotItem;

public class ModItems {
    public static final Item BAGUETTE = registerItem("baguette", new Item(new Item.Settings().food(ModFoodComponents.BAGUETTE)));
    public static final Item BANANA = registerItem("banana", new Item(new Item.Settings().food(ModFoodComponents.BANANA)));

    public static final Item CORN = registerItem("corn", new Item(new Item.Settings().food(ModFoodComponents.CORN)));
    public static final Item CORN_SEED = registerItem("corn_seed", new AliasedBlockItem(ModBlocks.CORN_CROP, new Item.Settings()));
    public static final Item DORITO = registerItem("dorito", new Item(new Item.Settings().food(ModFoodComponents.DORITO)));
    public static final Item DORITO_BAG = registerItem("dorito_bag", new Item(new Item.Settings().food(ModFoodComponents.DORITO_BAG)));

    public static final Item SLINGSHOT = registerItem("slingshot", new SlingshotItem(new Item.Settings().maxDamage(256)));
    public static final Item DIAMOND_SHARD = registerItem("diamond_shard", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item ) {
        return Registry.register(Registries.ITEM, Identifier.of(TopCommentMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TopCommentMod.LOGGER.info("Registering Mod Items for " + TopCommentMod.MOD_ID);
    }
}
