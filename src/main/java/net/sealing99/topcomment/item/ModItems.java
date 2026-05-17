package net.sealing99.topcomment.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sealing99.topcomment.TopCommentMod;

public class ModItems {
    public static final Item BAGUETTE = registerItem("baguette", new Item(new Item.Settings().food(ModFoodComponents.BAGUETTE)));
    public static final Item BANANA = registerItem("banana", new Item(new Item.Settings().food(ModFoodComponents.BANANA)));

    private static Item registerItem(String name, Item item ) {
        return Registry.register(Registries.ITEM, Identifier.of(TopCommentMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TopCommentMod.LOGGER.info("Registering Mod Items for " + TopCommentMod.MOD_ID);
    }
}
