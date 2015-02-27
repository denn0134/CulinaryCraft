package com.pfeffamonster.culinarycraft.Items;

import com.pfeffamonster.culinarycraft.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import org.lwjgl.Sys;

import java.util.List;

/**
 * Created by spdennis on 10/14/2014.
 */
public class HaliteItem extends Item {
    private String name = "haliteItem";
    private int subItems = 2;
    private String[] names = {"rockSalt", "tableSalt"};
    private IIcon[] icons;

    public static final int HALITE_ROCK_SALT = 0;
    public static final int HALITE_TABLE_SALT = 1;

    public HaliteItem() {
        setUnlocalizedName(Constants.MOD_ID + "_" + name);
        setHasSubtypes(true);
        setCreativeTab(CreativeTabs.tabFood);

        GameRegistry.registerItem(this, name);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int metaData = MathHelper.clamp_int(itemStack.getItemDamage(), 0, 15);
        return super.getUnlocalizedName() + "." + names[metaData];
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister iconRegister) {
        icons = new IIcon[subItems];

        for(int i = 0; i < subItems; i++) {
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
        for(int i = 0; i < subItems; i++) {
            list.add(new ItemStack(this, 1, i));
        }
    }
}
