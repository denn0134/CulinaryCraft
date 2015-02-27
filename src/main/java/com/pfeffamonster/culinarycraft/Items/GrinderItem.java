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

import java.util.List;

/**
 * Created by spdennis on 2/25/2015.
 */
public class GrinderItem extends Item {
    private String name = "grinderItem";
    private int subItems = 2;
    private String[] names = { "spiceGrinder", "spiceMill" };
    private IIcon[] icons;

    public static final int GRINDER_ITEM_SPICE_GRINDER = 0;
    public static final int GRINDER_ITEM_SPICE_MILL = 1;

    public GrinderItem() {
        setUnlocalizedName(Constants.MOD_ID + "_" + name);
        setHasSubtypes(true);
        setCreativeTab(CreativeTabs.tabMisc);

        GameRegistry.registerItem(this, name);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0 ,15);
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
        for (int i =0; i < subItems; i++){
            list.add(new ItemStack(this, 1, i));
        }
    }
}
