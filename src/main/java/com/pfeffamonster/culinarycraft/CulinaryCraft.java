package com.pfeffamonster.culinarycraft;

import com.pfeffamonster.culinarycraft.Achievements.CraftingHandler;
import com.pfeffamonster.culinarycraft.Achievements.CulinaryAchievements;
import com.pfeffamonster.culinarycraft.GUI.CulinaryGUIHandler;
import com.pfeffamonster.culinarycraft.Events.LivingEventHandler;
import com.pfeffamonster.culinarycraft.Items.ModItems;
import com.pfeffamonster.culinarycraft.blocks.ModBlocks;
import com.pfeffamonster.culinarycraft.lib.Constants;
import com.pfeffamonster.culinarycraft.recipes.CondimentRecipes;
import com.pfeffamonster.culinarycraft.recipes.FoodRecipes;
import com.pfeffamonster.culinarycraft.recipes.ToolRecipes;
import com.pfeffamonster.culinarycraft.world.CulinaryWorldGenerator;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by spdennis on 9/3/2014.
 */
@Mod(modid = Constants.MOD_ID, name = Constants.MOD_NAME, version = Constants.MOD_VERSION)
public class CulinaryCraft {
    public static String errInvalidMetaData = "Invalid metadata for %s [%d].%n";

    @SidedProxy(clientSide = "com.pfeffamonster.culinarycraft.Client.CulinaryClientProxy", serverSide = "com.pfeffamonster.culinarycraft.Server.CulinaryServerProxy")
    public static CulinaryCommonProxy proxy;

    @Mod.Instance(Constants.MOD_ID)
    public static CulinaryCraft instance;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        proxy.postInit(event);
    }


}
