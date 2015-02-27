package com.pfeffamonster.culinarycraft.Items;

import com.pfeffamonster.culinarycraft.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.MinecraftForge;

import java.util.List;

/**
 * Created by spdennis on 10/15/2014.
 */
public class PiperNigrumItem extends Item implements IPlantable {
    private String name = "piperNigrumItem";
    private String[] names = {"pepperBerries", "peppercorns", "blackPepper"};
    private int subItems = 3;
    private IIcon[] icons;
    private Block plant;

    public static final int PIPER_NIGRUM_BERRIES = 0;
    public static final int PIPER_NIGRUM_PEPPERCORNS = 1;
    public static final int PIPER_NIGRUM_BLACK_PEPPER = 2;

    public PiperNigrumItem(Block plant) {
        this.plant = plant;

        setUnlocalizedName(Constants.MOD_ID + "_" + name);
        setHasSubtypes(true);
        setCreativeTab(CreativeTabs.tabFood);

        GameRegistry.registerItem(this, name);

        //add black pepper seeds to tall grass drops
        MinecraftForge.addGrassSeed(new ItemStack(ModItems.piperNigrumItem, 1, PiperNigrumItem.PIPER_NIGRUM_BERRIES), 5);
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

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
        return EnumPlantType.Crop;
    }

    @Override
    public Block getPlant(IBlockAccess world, int x, int y, int z) {
        return plant;
    }

    @Override
    public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
        return 0;
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float f1, float f2, float f3) {
        if(side != 1){
            return false;
        }
        //check that the player is allowed to edit the block the item is being used upon and the block directly above it
        else if((player.canPlayerEdit(x, y, z, side, itemStack)) &&
                (player.canPlayerEdit(x, y + 1, z, side, itemStack))) {
            //check that the block it is being used upon is either dirt or grass
            if(world.getBlock(x, y, z) == Blocks.farmland) {
                //check that the block above it is air
                if(world.getBlock(x, y + 1, z) == Blocks.air) {
                    world.setBlock(x, y + 1, z, this.plant);
                    --itemStack.stackSize;
                    return true;
                }
                else {
                    return false;
                }
            }

            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
}
