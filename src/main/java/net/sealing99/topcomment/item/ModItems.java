package net.sealing99.topcomment.item;

import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.ArmorItem;
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

    public static final Item EMERITE_INGOT = registerItem("emerite_ingot", new Item(new Item.Settings()));

    public static final Item EMERITE_HELMET = registerItem("emerite_helmet", new ArmorItem(
            ModArmorMaterials.EMERITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
            new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(40))));

    public static final Item EMERITE_CHESTPLATE = registerItem("emerite_chestplate", new ArmorItem(
            ModArmorMaterials.EMERITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
            new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(40))));

    public static final Item EMERITE_LEGGINGS = registerItem("emerite_leggings", new ArmorItem(
            ModArmorMaterials.EMERITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
            new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(40))));

    public static final Item EMERITE_BOOTS = registerItem("emerite_boots", new ArmorItem(
            ModArmorMaterials.EMERITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
            new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(40))));

    private static Item registerItem(String name, Item item ) {
        return Registry.register(Registries.ITEM, Identifier.of(TopCommentMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TopCommentMod.LOGGER.info("Registering Mod Items for " + TopCommentMod.MOD_ID);
    }
}
