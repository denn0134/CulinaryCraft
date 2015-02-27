package com.pfeffamonster.culinarycraft.blocks;

import com.pfeffamonster.culinarycraft.CulinaryCraft;
import com.pfeffamonster.culinarycraft.Items.ModItems;
import com.pfeffamonster.culinarycraft.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockReed;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by spdennis on 10/14/2014.
 */
public class PiperNigrumBlock extends BlockBush implements IGrowable {

    private String name = "piperNigrumBlock";
    private int maxGrowth = 4;
    private int maxHeight = 4;
    private int minLightLevel = 9;

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public PiperNigrumBlock() {
        super(Material.plants);

        setBlockName(Constants.MOD_ID + "_" + name);
        setCreativeTab((CreativeTabs)null);
        setHardness(0.0F);
        setStepSound(soundTypeGrass);
        setLightOpacity(0);

        GameRegistry.registerBlock(this, name);
    }

    @Override
    public int quantityDropped(Random random) {
        return 1 + random.nextInt(2);
    }



    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
        if(meta == 3) {
            ItemStack stack = new ItemStack(ModItems.piperNigrumItem, 1, 0);
            return stack.getItem();
        }
        else {
            return null;
        }
    }

    @Override
    public int getRenderType() {
        //use the flower render type
        return 1;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        //create the icon array and register the icons for the various meta data values
        icons = new IIcon[maxGrowth];

        for (int i = 0; i < maxGrowth; i++) {
            icons[i] = iconRegister.registerIcon(Constants.MOD_ID + ":" + name + i);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
        if((meta < 0) ||
           (meta >= maxGrowth)) {
            //meta data is outside the allowed range - log an error message and return the lowest growth icon
            System.out.printf(CulinaryCraft.errInvalidMetaData, name, meta);
            return icons[0];
        }
        else {
            return icons[meta];
        }
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
        int metadata = world.getBlockMetadata(x, y, z);
        switch(metadata) {
            case 0:
                setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
                break;
            case 1:
                setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 0.75F, 0.875F);
                break;
            case 2:
                setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 1.0F, 0.875F);
                break;
            case 3:
                setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 1.0F, 0.875F);
        }
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        return null;
    }

    //IGrowable methods
    //these methods deal with using bonemeal on the plant
    @Override
    public boolean func_149851_a(World world, int x, int y, int z, boolean par5) {
        //determines if bonemeal can be applied to this block - allow as long as the block is not fully grown
        return piperNigrumCanGrow(world, x, y, z, false);

    }

    @Override
    public boolean func_149852_a(World world, Random random, int x, int y, int z) {
        //checks for a random chance that the bonemeal works
        return true;
    }

    @Override
    public void func_149853_b(World world, Random random, int x, int y, int z) {
        //applies the effects of a successful bonemeal application
        int nextGrowthStage = world.getBlockMetadata(x, y, z);
        ++nextGrowthStage;

        if(nextGrowthStage >= maxGrowth){
            //check if the block above is air
            if(world.getBlock(x, y + 1, z) == Blocks.air) {
                world.setBlock(x, y + 1, z, this, 0, 3);
            }
        }
        else {
            world.setBlockMetadataWithNotify(x, y, z, nextGrowthStage, 2);
        }
    }
    //end of IGrowable methods

    @Override
    protected boolean canPlaceBlockOn(Block block) {
        return ((block == Blocks.farmland) ||
                (block == ModBlocks.piperNigrumBlock));
    }

    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        Block block = world.getBlock(x, y - 1, z);
        return this.canPlaceBlockOn(block);
    }

    public void updateTick(World world, int x, int y, int z, Random random) {
        super.updateTick(world, x, y, z, random);

        //now see if the plant will grow
        if (piperNigrumCanGrow(world, x, y, z, true)) {
            //check for a random chance that the plant will grow
            if (random.nextInt(1) == 0) {
                int currentGrowth = world.getBlockMetadata(x, y, z);
                if (currentGrowth == maxGrowth - 1) {
                    if (world.getBlock(x, y + 1, z) == Blocks.air) {
                        world.setBlock(x, y + 1, z, this, 0, 3);
                    }
                } else {
                    ++currentGrowth;
                    world.setBlockMetadataWithNotify(x, y, z, currentGrowth, 2);
                }
            }
        }

    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int p_149749_6_) {
        //check the block above this one and if it is also piperNigrum then check if it can stay
        Block above = world.getBlock(x, y + 1, z);
        if(above == ModBlocks.piperNigrumBlock) {
            ((PiperNigrumBlock)above).checkAndDropBlock(world, x, y + 1, z);
        }
    }

    private boolean piperNigrumCanGrow(World world, int x, int y, int z, boolean checkLight) {
        //reasons the plant would not be able to grow
        //1: light level not strong enough
        //2: this block is fully grown and there is already a piper nigrum above it
        //3: this block is fully grown and the block is at the max height for the plant
        int currentGrowth = world.getBlockMetadata(x, y, z);
        if((currentGrowth < 0) || (currentGrowth >= maxGrowth)) {
            System.out.printf(CulinaryCraft.errInvalidMetaData, name, currentGrowth);
            return false;
        }
        else {
            if((checkLight) &&
               (world.getBlockLightValue(x, y + 1, z) < minLightLevel)) {
                //case 1: insufficient light
                return false;
            }
            else if(currentGrowth == maxGrowth - 1) {
                //cases 2 & 3: block is fully grown
                Block oneUp = world.getBlock(x, y + 1, z);
                Block threeDown = world.getBlock(x, y - (maxHeight - 1), z);
                if((oneUp == ModBlocks.piperNigrumBlock) ||
                   (threeDown == ModBlocks.piperNigrumBlock)) {
                    return false;
                }
                else {
                    return true;
                }
            }
            else {
                return true;
            }
        }
    }
}
