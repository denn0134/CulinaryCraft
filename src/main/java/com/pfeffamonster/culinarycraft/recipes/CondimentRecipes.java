package com.pfeffamonster.culinarycraft.recipes;

import com.pfeffamonster.culinarycraft.Items.GrinderItem;
import com.pfeffamonster.culinarycraft.Items.HaliteItem;
import com.pfeffamonster.culinarycraft.Items.ModItems;
import com.pfeffamonster.culinarycraft.Items.PiperNigrumItem;
import com.pfeffamonster.culinarycraft.blocks.ModBlocks;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by spdennis on 10/17/2014.
 */
public class CondimentRecipes {
    public static void initRecipes() {
        //grind rock salt into table salt
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.haliteItem, 2, HaliteItem.HALITE_TABLE_SALT),
                new ItemStack(ModItems.grinderItem, 1, GrinderItem.GRINDER_ITEM_SPICE_GRINDER),
                new ItemStack(ModItems.haliteItem, 1, HaliteItem.HALITE_ROCK_SALT));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.haliteItem, 4, HaliteItem.HALITE_TABLE_SALT),
                new ItemStack(ModItems.grinderItem, 1, GrinderItem.GRINDER_ITEM_SPICE_MILL),
                new ItemStack(ModItems.haliteItem, 1, HaliteItem.HALITE_ROCK_SALT));

        //grind peppercorns into black pepper
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.piperNigrumItem, 2, PiperNigrumItem.PIPER_NIGRUM_BLACK_PEPPER),
                new ItemStack(ModItems.grinderItem, 1, GrinderItem.GRINDER_ITEM_SPICE_GRINDER),
                new ItemStack(ModItems.piperNigrumItem, 1, PiperNigrumItem.PIPER_NIGRUM_PEPPERCORNS));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.piperNigrumItem, 4, PiperNigrumItem.PIPER_NIGRUM_BLACK_PEPPER),
                new ItemStack(ModItems.grinderItem, 1, GrinderItem.GRINDER_ITEM_SPICE_MILL),
                new ItemStack(ModItems.piperNigrumItem, 1, PiperNigrumItem.PIPER_NIGRUM_PEPPERCORNS));

        //2 table salt --> 1 rock salt
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.haliteItem, 1, HaliteItem.HALITE_ROCK_SALT),
                new ItemStack(ModItems.haliteItem, 1, HaliteItem.HALITE_TABLE_SALT),
                new ItemStack(ModItems.haliteItem, 1, HaliteItem.HALITE_TABLE_SALT),
                new ItemStack(ModItems.haliteItem, 1, HaliteItem.HALITE_TABLE_SALT),
                new ItemStack(ModItems.haliteItem, 1, HaliteItem.HALITE_TABLE_SALT));

        //1 salt block --> 4 rock salt
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.haliteItem, 4, HaliteItem.HALITE_ROCK_SALT), ModBlocks.haliteBlock);

        //4 rock salt --> 1 salt block - shaped recipe
        GameRegistry.addRecipe(new ItemStack(ModBlocks.haliteBlock), "RR", "RR", 'R', new ItemStack(ModItems.haliteItem, 1, HaliteItem.HALITE_ROCK_SALT));

        //smelt 1 pepper berry --> to 1 peppercorn
        GameRegistry.addSmelting(new ItemStack(ModItems.piperNigrumItem, 1, PiperNigrumItem.PIPER_NIGRUM_BERRIES),
                                 new ItemStack(ModItems.piperNigrumItem, 1, PiperNigrumItem.PIPER_NIGRUM_PEPPERCORNS), 0.2F);
    }
}
