package com.pfeffamonster.culinarycraft.TileEntities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import java.util.UUID;

/**
 * Created by spdennis on 3/13/2015.
 */
public class TimerTileEntity extends TileEntity {
    public static final int TIMER_IDLE = 0;
    public static final int TIMER_RUNNING = 1;
    public static final int TIMER_ALARM = 2;

    private int counter = 0;
    private int elapsed;
    private int metaData;
    private int timerInterval = 10;
    private boolean counterEnabled = true;

    @Override
    public void updateEntity() {
        if (counterEnabled){
            metaData = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
            if ((metaData == TIMER_IDLE) || (metaData == TIMER_ALARM)){
                counterEnabled = false;
                return;
            }

            counter++;

            if (counter == 20){
                counter = 0;
                elapsed++;

                if (elapsed == timerInterval){
                    metaData = TIMER_ALARM;
                    counterEnabled = false;

                    if(!worldObj.isRemote)
                        worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, metaData, 2);
                }
            }
        }

        super.updateEntity();
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);

        counter = tag.getInteger("counter");
        elapsed = tag.getInteger("elapsed");
        counterEnabled = tag.getBoolean("counterEnabled");
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);

        tag.setInteger("counter", counter);
        tag.setInteger("elapsed", elapsed);
        tag.setBoolean("counterEnabled", counterEnabled);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        this.readFromNBT(pkt.func_148857_g());
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        this.writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }

    public void editCounter() {
        counterEnabled = !counterEnabled;
        markDirty();
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

    public void interact() {
        metaData = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);

        switch (metaData){
            case TIMER_IDLE:
                counterEnabled = true;
                counter = 0;
                elapsed = 0;
                metaData = TIMER_RUNNING;
                break;
            case TIMER_RUNNING:
            case TIMER_ALARM:
                counterEnabled = false;
                metaData = TIMER_IDLE;
                break;
        }

        if (!worldObj.isRemote)
            worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, metaData, 2);

        markDirty();
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }
}
