package com.pfeffamonster.culinarycraft.Achievements;

import com.pfeffamonster.culinarycraft.Items.HaliteItem;
import com.pfeffamonster.culinarycraft.Items.ModItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.lwjgl.Sys;

/**
 * Created by spdennis on 2/24/2015.
 */
public class CraftingHandler {
    @SubscribeEvent
    public void onCrafting(PlayerEvent.ItemCraftedEvent event){
        Item item = event.crafting.getItem();

        //check for any achievements which may have been gotten
        if (item.equals(ModItems.haliteItem)){
            //check if the item was table salt
            if (event.crafting.getItemDamage() == HaliteItem.HALITE_TABLE_SALT){
                event.player.addStat(CulinaryAchievements.tableSaltAchievement, 1);
            }
        }
        else if (item.equals(ModItems.hamItem)){
            event.player.addStat(CulinaryAchievements.hamAchievement, 1);
        }

        //check if the crafting was using a grinder item
        for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++){
            ItemStack stack = event.craftMatrix.getStackInSlot(i);
            if (stack != null){
                Item slotItem = stack.getItem();
                int meta = stack.getItemDamage();
                if (slotItem.equals(ModItems.grinderItem)){
                    //replace the item stack with one that has an extra item in it
                    ItemStack replace = new ItemStack(slotItem, 2, meta);
                    event.craftMatrix.setInventorySlotContents(i, replace);
                }
            }
        }
    }
}
