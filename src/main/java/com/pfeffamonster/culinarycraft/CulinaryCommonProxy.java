package com.pfeffamonster.culinarycraft;

import com.pfeffamonster.culinarycraft.Achievements.CraftingHandler;
import com.pfeffamonster.culinarycraft.Achievements.CulinaryAchievements;
import com.pfeffamonster.culinarycraft.Events.LivingEventHandler;
import com.pfeffamonster.culinarycraft.GUI.CulinaryGUIHandler;
import com.pfeffamonster.culinarycraft.Items.ModItems;
import com.pfeffamonster.culinarycraft.Items.PiperNigrumItem;
import com.pfeffamonster.culinarycraft.TileEntities.GrinderTileEntity;
import com.pfeffamonster.culinarycraft.TileEntities.TimerTileEntity;
import com.pfeffamonster.culinarycraft.blocks.ModBlocks;
import com.pfeffamonster.culinarycraft.recipes.CondimentRecipes;
import com.pfeffamonster.culinarycraft.recipes.FoodRecipes;
import com.pfeffamonster.culinarycraft.recipes.ToolRecipes;
import com.pfeffamonster.culinarycraft.world.CulinaryWorldGenerator;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by spdennis on 10/13/2015.
 */
public class CulinaryCommonProxy {
    public void preInit(FMLPreInitializationEvent event){
        ModBlocks.init();
        ModItems.init();

        GameRegistry.registerWorldGenerator(new CulinaryWorldGenerator(), 1);

        //tile entities
        GameRegistry.registerTileEntity(TimerTileEntity.class, "timerTileEntity");
        GameRegistry.registerTileEntity(GrinderTileEntity.class, "grinderTileEntity");
    }

    public void init(FMLInitializationEvent event){
        NetworkRegistry.INSTANCE.registerGuiHandler(CulinaryCraft.instance, new CulinaryGUIHandler());

        //add some recipes
        CondimentRecipes.initRecipes();
        ToolRecipes.initRecipes();
        FoodRecipes.initFoodRecipes();

        //add the culinary achievements
        CulinaryAchievements.initCulinaryAchievements();

        //register the crafting handler
        FMLCommonHandler.instance().bus().register(new CraftingHandler());
        MinecraftForge.EVENT_BUS.register(new LivingEventHandler());
    }

    public void postInit(FMLPostInitializationEvent event){

    }
}
