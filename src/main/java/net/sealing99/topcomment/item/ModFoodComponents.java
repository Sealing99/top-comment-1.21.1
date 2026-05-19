package net.sealing99.topcomment.item;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent BAGUETTE = new FoodComponent.Builder().nutrition(10).saturationModifier(0.3f).build();
    public static final FoodComponent BANANA = new FoodComponent.Builder().nutrition(1).saturationModifier(0.4f).build();

    public static final FoodComponent CORN = new FoodComponent.Builder().nutrition(5).saturationModifier(0.3f).build();
    public static final FoodComponent DORITO = new FoodComponent.Builder().nutrition(2).saturationModifier(0.7f).build();
    public static final FoodComponent DORITO_BAG = new FoodComponent.Builder().nutrition(14).saturationModifier(0.6f).build();
}
