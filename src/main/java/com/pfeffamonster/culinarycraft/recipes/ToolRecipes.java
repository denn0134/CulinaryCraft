package com.pfeffamonster.culinarycraft.recipes;

import buildcraft.BuildCraftCore;
import com.pfeffamonster.culinarycraft.Items.BurrGrinderItem;
import com.pfeffamonster.culinarycraft.Items.GrinderItem;
import com.pfeffamonster.culinarycraft.Items.ModItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by spdennis on 2/24/2015.
 */
public class ToolRecipes {
    public static void initRecipes(){
        //burr grinders
        GameRegistry.addRecipe(new ItemStack(ModItems.burrGrinderItem, 1, BurrGrinderItem.BURR_GRINDER_STONE),
                " G ", "SFS", " G ",
                'G', new ItemStack(BuildCraftCore.stoneGearItem, 1, 0),
                'S', new ItemStack(Blocks.stone_slab, 1, 0),
                'F', new ItemStack(Items.flint, 1, 0));
        GameRegistry.addRecipe(new ItemStack(ModItems.burrGrinderItem, 1, BurrGrinderItem.BURR_GRINDER_IRON),
                " G ", "IDI", " G ",
                'G', new ItemStack(BuildCraftCore.ironGearItem, 1, 0),
                'I', new ItemStack(Items.iron_ingot, 1, 0),
                'D', new ItemStack(Items.diamond, 1, 0));

        //spice mills
        GameRegistry.addRecipe(new ItemStack(ModItems.grinderItem, 1, GrinderItem.GRINDER_ITEM_SPICE_GRINDER),
                " C ", "W W", "WGW",
                'C', new ItemStack(Items.gold_ingot, 1, 0),
                'W', new ItemStack(Blocks.planks, 1, 0),
                'G', new ItemStack(ModItems.burrGrinderItem, 1, BurrGrinderItem.BURR_GRINDER_STONE));
        GameRegistry.addRecipe(new ItemStack(ModItems.grinderItem, 1, GrinderItem.GRINDER_ITEM_SPICE_MILL),
                " O ", "I I", "IGI",
                'O', new ItemStack(Blocks.obsidian, 1, 0),
                'I', new ItemStack(Items.iron_ingot, 1, 0),
                'G', new ItemStack(ModItems.burrGrinderItem, 1, BurrGrinderItem.BURR_GRINDER_IRON));
    }
}
