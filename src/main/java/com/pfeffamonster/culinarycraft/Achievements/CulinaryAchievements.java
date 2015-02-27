package com.pfeffamonster.culinarycraft.Achievements;

import com.pfeffamonster.culinarycraft.Items.HaliteItem;
import com.pfeffamonster.culinarycraft.Items.ModItems;
import com.pfeffamonster.culinarycraft.blocks.ModBlocks;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

/**
 * Created by spdennis on 2/24/2015.
 */
public class CulinaryAchievements {
    public static AchievementPage culinaryAchievements;
    public static Achievement haliteAchievement;
    public static Achievement tableSaltAchievement;
    public static Achievement hamAchievement;

    public static void initCulinaryAchievements(){
        //salt line of achievements
        haliteAchievement = new Achievement("achievement.haliteBlock", "haliteBlockAchievement", 0, 0,
                new ItemStack(ModBlocks.haliteBlock), null).registerStat();
        tableSaltAchievement = new Achievement("achievement.haliteItem", "haliteItemAchievement", 0, 2,
                new ItemStack(ModItems.haliteItem, 1, HaliteItem.HALITE_TABLE_SALT), haliteAchievement).registerStat();
        hamAchievement = new Achievement("achievement.hamItem", "hamItemAchievement", 0, 4,
                new ItemStack(ModItems.hamItem), tableSaltAchievement).registerStat();

        //create an achievement page
        culinaryAchievements = new AchievementPage("CulinaryCraft", haliteAchievement, tableSaltAchievement, hamAchievement);
        AchievementPage.registerAchievementPage(culinaryAchievements);
    }
}
