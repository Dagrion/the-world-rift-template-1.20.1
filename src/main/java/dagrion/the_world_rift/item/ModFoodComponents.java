package dagrion.the_world_rift.item;

import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent ENCHANTED_CARROT = new FoodComponent.Builder()
            .snack()
            .hunger(6)
            .saturationModifier(1.2f)
            .build();
}