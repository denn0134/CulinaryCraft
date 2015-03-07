package com.pfeffamonster.culinarycraft.Events;

import com.pfeffamonster.culinarycraft.Items.CleaverItem;
import com.pfeffamonster.culinarycraft.Items.ModItems;
import com.pfeffamonster.culinarycraft.Items.RoastItem;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import org.lwjgl.Sys;

import java.util.ArrayList;

/**
 * Created by spdennis on 2/28/2015.
 */
public class LivingEventHandler {
    private Item getEquippedItem(Entity player) {
        if (player instanceof EntityPlayerMP) {
            EntityPlayerMP playerMP = (EntityPlayerMP)player;
            ItemStack currentItem = playerMP.getCurrentEquippedItem();
            if (currentItem != null) {
                return currentItem.getItem();
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }

    private void onCowDeath(Entity entity, DamageSource source, ArrayList<EntityItem> drops){
        Item causeOfDeath = getEquippedItem(source.getEntity());
        if (causeOfDeath != null){
            if (causeOfDeath.equals(ModItems.cleaverItem)) {
                for (int i = 0; i < drops.size(); i++) {
                    if (drops.get(i).getEntityItem().getItem().equals(Items.beef)) {
                        int roastType = MathHelper.getRandomIntegerInRange(entity.worldObj.rand,
                                RoastItem.ROAST_BEEF_ROAST, RoastItem.ROAST_BRISKET);
                        ItemStack newDrop = new ItemStack(ModItems.roastItem, 1, roastType);
                        drops.set(i, new EntityItem(entity.worldObj, entity.posX, entity.posY, entity.posZ, newDrop));
                    }
                }
            }
        }
    }

    private void onPigDeath(Entity entity, DamageSource source, ArrayList<EntityItem> drops) {
        Item causeOfDeath = getEquippedItem(source.getEntity());
        if (causeOfDeath != null){
            if (causeOfDeath.equals(ModItems.cleaverItem)){
                for (int i = 0; i < drops.size(); i++) {
                    if (drops.get(i).getEntityItem().getItem().equals(Items.porkchop)) {
                        int roastType = MathHelper.getRandomIntegerInRange(entity.worldObj.rand,
                                RoastItem.ROAST_PORK_ROAST, RoastItem.ROAST_PORK_BELLY);
                        ItemStack newDrop = new ItemStack(ModItems.roastItem, 1, roastType);
                        drops.set(i, new EntityItem(entity.worldObj, entity.posX, entity.posY, entity.posZ, newDrop));
                    }
                }
            }
        }
    }

    private void onSheepDeath(Entity entity, DamageSource source, ArrayList<EntityItem> drops) {
        Item causeOfDeath = getEquippedItem(source.getEntity());
        if (causeOfDeath != null){
            if (causeOfDeath.equals(ModItems.cleaverItem)){
                int randNum = MathHelper.getRandomIntegerInRange(entity.worldObj.rand, 0, 2);
                for (int i = 0; i < randNum; i++){
                    int roastType = MathHelper.getRandomIntegerInRange(entity.worldObj.rand,
                            RoastItem.ROAST_MUTTON_ROAST, RoastItem.ROAST_LAMB_RACK);
                    ItemStack newDrop = new ItemStack(ModItems.roastItem, 1, roastType);
                    drops.add(new EntityItem(entity.worldObj, entity.posX, entity.posY, entity.posZ, newDrop));
                }
            }
        }
    }

    @SubscribeEvent
    public void onEntityDrop(LivingDropsEvent event){
        //determine what just died
        if (event.entity instanceof EntityCow){ onCowDeath(event.entity, event.source, event.drops); }
        else if (event.entity instanceof EntityPig){ onPigDeath(event.entity, event.source, event.drops); }
        else if (event.entity instanceof EntitySheep){ onSheepDeath(event.entity, event.source, event.drops); }
    }
}
