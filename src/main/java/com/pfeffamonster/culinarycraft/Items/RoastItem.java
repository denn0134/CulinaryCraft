package com.pfeffamonster.culinarycraft.Items;

import com.pfeffamonster.culinarycraft.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

import java.util.List;

/**
 * Created by spdennis on 3/6/2015.
 */
public class RoastItem extends ItemFood {
    private String name = "roastItem";
    private String[] names = { "beefRoast", "brisket", "porkRoast", "porkBelly", "muttonRoast", "lambRack" };
    private int subItems = 6;
    private IIcon[] icons;

    public static final int ROAST_BEEF_ROAST = 0;
    public static final int ROAST_BRISKET = 1;
    public static final int ROAST_PORK_ROAST = 2;
    public static final int ROAST_PORK_BELLY = 3;
    public static final int ROAST_MUTTON_ROAST = 4;
    public static final int ROAST_LAMB_RACK = 5;

    public RoastItem(int foodValue, float saturationValue, boolean isWolfFood) {
        super(foodValue, saturationValue, isWolfFood);

        setUnlocalizedName(Constants.MOD_ID + "_" + name);
        setHasSubtypes(true);
        setCreativeTab(CreativeTabs.tabFood);

        GameRegistry.registerItem(this, name);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, 15);
        return super.getUnlocalizedName() + "." + names[meta];
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister iconRegister) {
        icons = new IIcon[subItems];
        for (int i = 0; i < subItems; i++){
            icons[i] = iconRegister.registerIcon(Constants.MOD_ID + ":" + name + "." + names[i]);
        }
    }

    @Override
    public IIcon getIconFromDamage(int meta) {
        return icons[meta];
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @SideOnly(Side.CLIENT)

    @Override
    public void getSubItems(Item item, CreativeTabs creativeTabs, List list) {
        for (int i = 0; i < subItems; i++){
            list.add(new ItemStack(this, 1, i));
        }
    }
}
