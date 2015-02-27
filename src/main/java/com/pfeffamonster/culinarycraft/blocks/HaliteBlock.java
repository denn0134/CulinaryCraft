package com.pfeffamonster.culinarycraft.blocks;

import com.pfeffamonster.culinarycraft.Achievements.CulinaryAchievements;
import com.pfeffamonster.culinarycraft.CulinaryCraft;
import com.pfeffamonster.culinarycraft.Items.HaliteItem;
import com.pfeffamonster.culinarycraft.Items.ModItems;
import com.pfeffamonster.culinarycraft.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by spdennis on 10/14/2014.
 */
public class HaliteBlock extends Block {
    private String name = "haliteBlock";

    public HaliteBlock() {
        super(Material.rock);

        setBlockName(Constants.MOD_ID + "_" + name);
        setCreativeTab(CreativeTabs.tabBlock);
        setBlockTextureName(Constants.MOD_ID + ":" + name);
        setHardness(1.0F);

        GameRegistry.registerBlock(this, name);
    }

    @Override
    public int quantityDropped(Random random) {

        int dieRoll = random.nextInt(10);
        switch (dieRoll){
            case 0:
                return 1;
            case 1:
            case 2:
                return 2;
            case 3:
            case 4:
            case 5:
                return 3;
            case 6:
            case 7:
            case 8:
            case 9:
                return 4;
            default:
                return 4;
        }//end switch
    }

    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
        ItemStack stack = new ItemStack(ModItems.haliteItem, 1, HaliteItem.HALITE_ROCK_SALT);

        return stack.getItem();
    }

    @Override
    public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
        player.addStat(CulinaryAchievements.haliteAchievement, 1);

        super.onBlockHarvested(world, x, y, z, meta, player);
    }
}
