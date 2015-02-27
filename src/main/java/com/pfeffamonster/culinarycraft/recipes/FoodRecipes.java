package com.pfeffamonster.culinarycraft.recipes;

import com.pfeffamonster.culinarycraft.Items.HaliteItem;
import com.pfeffamonster.culinarycraft.Items.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by spdennis on 2/24/2015.
 */
public class FoodRecipes {
    public static void initFoodRecipes(){
        //raw porkchop and 8 salt --> tasty ham
        GameRegistry.addRecipe(new ItemStack(ModItems.hamItem),
                "SSS", "SPS", "SSS",
                'P', Items.porkchop,
                'S', new ItemStack(ModItems.haliteItem, 1, HaliteItem.HALITE_TABLE_SALT));
    }
}
