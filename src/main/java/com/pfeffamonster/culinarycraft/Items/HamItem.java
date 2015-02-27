package com.pfeffamonster.culinarycraft.Items;

import com.pfeffamonster.culinarycraft.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;

/**
 * Created by spdennis on 10/9/2014.
 */
public class HamItem extends ItemFood {

    private String name = "hamItem";

    public HamItem(int foodValue, float saturationValue, boolean isWolfFood) {

        super(foodValue, saturationValue, isWolfFood);

        setUnlocalizedName(Constants.MOD_ID + "_" + name);
        setCreativeTab(CreativeTabs.tabFood);
        setTextureName(Constants.MOD_ID + ":" + name);
        setPotionEffect(Potion.regeneration.id, 10, 0, 1F);
        GameRegistry.registerItem(this, name);
    }

}
