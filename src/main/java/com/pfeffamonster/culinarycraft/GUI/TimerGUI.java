package com.pfeffamonster.culinarycraft.GUI;

import com.pfeffamonster.culinarycraft.lib.Constants;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.main.Main;
import net.minecraft.util.ResourceLocation;

import java.awt.*;
import java.io.IOException;

/**
 * Created by spdennis on 3/15/2015.
 */
public class TimerGUI extends GuiScreen {
    private GuiButton a;
    private GuiButton b;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        //1996840
        //this.fontRendererObj.drawString("TEST 1", 10, 10, 1996840, false);

        this.mc.getTextureManager().bindTexture(new ResourceLocation("culinaryCraft:textures/gui/timerGUI.png"));
        this.drawTexturedModalRect(this.width / 2 - 128, this.height / 2 - 83, 0, 0, 256, 165);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void initGui() {
        //this.buttonList.add(this.a = new GuiButton(0, this.width / 2 - 100, this.height / 2 - 24, "This is button a"));
        //this.buttonList.add(this.b = new GuiButton(1, this.width / 2 - 100, this.height / 2 + 4, "This is button b"));
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if(button == this.a){
            this.mc.displayGuiScreen(null);
            if(this.mc.currentScreen == null)
                this.mc.setIngameFocus();
        }

        if(button == this.b){
            this.mc.displayGuiScreen(null);
            if(this.mc.currentScreen == null)
                this.mc.setIngameFocus();
        }
    }
}
