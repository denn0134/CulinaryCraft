package com.pfeffamonster.culinarycraft.Items;

import com.pfeffamonster.culinarycraft.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by spdennis on 2/28/2015.
 */
public class CarbonSteelBlendItem extends Item {
    private String name = "carbonSteelBlendItem";

    public CarbonSteelBlendItem() {
        setUnlocalizedName(Constants.MOD_ID + "_" + name);
        setCreativeTab(CreativeTabs.tabMaterials);
        setTextureName(Constants.MOD_ID + ":" + name);

        GameRegistry.registerItem(this, name);
    }
}
