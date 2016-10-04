package com.pfeffamonster.culinarycraft.blocks;

import net.minecraft.block.Block;

/**
 * Created by spdennis on 9/3/2014.
 */
public final class ModBlocks {

    //public static Block saltBlock;
    public static Block haliteBlock;
    public static Block piperNigrumBlock;

    public static void init(){

        //saltBlock = new SaltBlock();
        haliteBlock = new HaliteBlock();
        piperNigrumBlock = new PiperNigrumBlock();
    }
}
