package com.pfeffamonster.culinarycraft.blocks;

import com.pfeffamonster.culinarycraft.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by spdennis on 3/9/2015.
 */
public class GrinderBlock extends Block {
    private String name = "grinderBlock";
    private int subIcons = 4;

    public static final int TEXTURE_FRONT = 0;
    public static final String TEXTURE_NAME_FRONT = "front";
    public static final int TEXTURE_SIDE = 1;
    public static final String TEXTURE_NAME_SIDE = "side";
    public static final int TEXTURE_TOP = 2;
    public static final String TEXTURE_NAME_TOP = "top";
    public static final int TEXTURE_BOTTOM = 3;
    public static final String TEXTURE_NAME_BOTTOM = "bottom";

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public GrinderBlock() {
        super(Material.piston);

        setBlockName(Constants.MOD_ID + "_" + name);
        setCreativeTab(CreativeTabs.tabMisc);
        setHardness(2.0F);

        GameRegistry.registerBlock(this, name);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        icons = new IIcon[subIcons];

        icons[GrinderBlock.TEXTURE_FRONT] = iconRegister.registerIcon(Constants.MOD_ID + ":" + name + "." + GrinderBlock.TEXTURE_NAME_FRONT);
        icons[GrinderBlock.TEXTURE_SIDE] = iconRegister.registerIcon(Constants.MOD_ID + ":" + name + "." + GrinderBlock.TEXTURE_NAME_SIDE);
        icons[GrinderBlock.TEXTURE_TOP] = iconRegister.registerIcon(Constants.MOD_ID + ":" + name + "." + GrinderBlock.TEXTURE_NAME_TOP);
        icons[GrinderBlock.TEXTURE_BOTTOM] = iconRegister.registerIcon(Constants.MOD_ID + ":" + name + "." + GrinderBlock.TEXTURE_NAME_BOTTOM);
    }

    @SideOnly(Side.CLIENT)

    @Override
    public IIcon getIcon(int side, int metaData) {
        System.out.println("GrinderBlock.getIcon: side=" + side + "; metaData=" + metaData);
        switch (side){
            case 0:
                return icons[GrinderBlock.TEXTURE_BOTTOM];
            case 1:
                return icons[GrinderBlock.TEXTURE_TOP];
            case 2:
                return icons[GrinderBlock.TEXTURE_FRONT];
            default:
                return icons[GrinderBlock.TEXTURE_SIDE];
        }
    }
}
