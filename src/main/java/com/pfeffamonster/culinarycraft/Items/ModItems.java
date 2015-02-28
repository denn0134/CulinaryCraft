package com.pfeffamonster.culinarycraft.Items;

import com.pfeffamonster.culinarycraft.blocks.ModBlocks;
import net.minecraft.item.Item;

/**
 * Created by spdennis on 10/6/2014.
 */
public final class ModItems {
    public static Item haliteItem;
    public static Item hamItem;
    public static  Item piperNigrumItem;
    public static Item burrGrinderItem;
    public static Item grinderItem;
    public static Item carbonSteelBlendItem;

    public static void init(){
        haliteItem = new HaliteItem();
        hamItem = new HamItem(8, 12.8F, true);
        piperNigrumItem = new PiperNigrumItem(ModBlocks.piperNigrumBlock);
        burrGrinderItem = new BurrGrinderItem();
        grinderItem = new GrinderItem();
        carbonSteelBlendItem = new CarbonSteelBlendItem();
    }
}
