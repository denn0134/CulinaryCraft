package com.pfeffamonster.culinarycraft.GUI;

import com.pfeffamonster.culinarycraft.CulinaryCraft;
import com.pfeffamonster.culinarycraft.TileEntities.TimerTileEntity;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by spdennis on 3/15/2015.
 */
public class CulinaryGUIHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch(ID){
            case CulinaryGUIs.GUI_TIMER:
                return null;
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch(ID){
            case CulinaryGUIs.GUI_TIMER:
                return new TimerGUI();
        }
        return null;
    }
}
