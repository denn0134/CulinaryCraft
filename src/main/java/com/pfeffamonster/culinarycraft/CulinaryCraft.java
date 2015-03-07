package com.pfeffamonster.culinarycraft;

import com.pfeffamonster.culinarycraft.Achievements.CraftingHandler;
import com.pfeffamonster.culinarycraft.Achievements.CulinaryAchievements;
import com.pfeffamonster.culinarycraft.Events.LivingEventHandler;
import com.pfeffamonster.culinarycraft.Items.HaliteItem;
import com.pfeffamonster.culinarycraft.Items.ModItems;
import com.pfeffamonster.culinarycraft.Items.PiperNigrumItem;
import com.pfeffamonster.culinarycraft.blocks.ModBlocks;
import com.pfeffamonster.culinarycraft.lib.Constants;
import com.pfeffamonster.culinarycraft.recipes.CondimentRecipes;
import com.pfeffamonster.culinarycraft.recipes.FoodRecipes;
import com.pfeffamonster.culinarycraft.recipes.ToolRecipes;
import com.pfeffamonster.culinarycraft.world.CulinaryWorldGenerator;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by spdennis on 9/3/2014.
 */
@Mod(modid = Constants.MOD_ID, name = Constants.MOD_NAME, version = Constants.MOD_VERSION)
public class CulinaryCraft {
    public static String errInvalidMetaData = "Invalid metadata for %s [%d].%n";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        ModBlocks.init();
        ModItems.init();

        GameRegistry.registerWorldGenerator(new CulinaryWorldGenerator(), 1);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
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

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }


}
