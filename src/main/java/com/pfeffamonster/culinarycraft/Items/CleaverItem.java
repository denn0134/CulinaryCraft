package com.pfeffamonster.culinarycraft.Items;

import com.pfeffamonster.culinarycraft.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

/**
 * Created by spdennis on 2/28/2015.
 */
public class CleaverItem extends ItemSword {
    private String name = "cleaverItem";

    public CleaverItem(Item.ToolMaterial toolMaterial) {
        super(toolMaterial);

        setUnlocalizedName(Constants.MOD_ID + "_" + name);
        setCreativeTab(CreativeTabs.tabTools);
        setTextureName(Constants.MOD_ID + ":" + name);

        GameRegistry.registerItem(this, name);
    }
}
