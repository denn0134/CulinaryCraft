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
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * Created by spdennis on 2/24/2015.
 */
public class ToolRecipes {
    public static void initRecipes(){
        //burr grinders
        GameRegistry.addRecipe(new ItemStack(ModItems.burrGrinderItem, 1, BurrGrinderItem.BURR_GRINDER_STONE),
                " G ", "SFS", " G ",
                'G', new ItemStack(BuildCraftCore.stoneGearItem, 1, 0),
                'S', new ItemStack(Blocks.stone_slab),
                'F', new ItemStack(Items.flint, 1, 0));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.burrGrinderItem, 1, BurrGrinderItem.BURR_GRINDER_IRON),
                " G ", "IDI", " G ",
                'G', new ItemStack(BuildCraftCore.ironGearItem, 1, 0),
                'I', "ingotIron",
                'D', "gemDiamond"));

        //spice mills
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.grinderItem, 1, GrinderItem.GRINDER_ITEM_SPICE_GRINDER),
                " I ", "W W", "WGW",
                'I', "ingotGold",
                'W', "plankWood",
                'G', new ItemStack(ModItems.burrGrinderItem, 1, BurrGrinderItem.BURR_GRINDER_STONE)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.grinderItem, 1, GrinderItem.GRINDER_ITEM_SPICE_MILL),
                " O ", "I I", "IGI",
                'O', new ItemStack(Blocks.obsidian, 1, 0),
                'I', "ingotIron",
                'G', new ItemStack(ModItems.burrGrinderItem, 1, BurrGrinderItem.BURR_GRINDER_IRON)));

        //carbon steel ingots
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.carbonSteelBlendItem),
                "CCC", "CIC", "CCC",
                'C', new ItemStack(Items.coal),
                'I', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.carbonSteelBlendItem),
                " C ", "CSC", " C ",
                'C', new ItemStack(Items.coal),
                'S', "ingotSteel"));
    }
}
