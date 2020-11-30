package net.aeronica.modlibs.aguilib.server.config;

import net.aeronica.modlibs.aguilib.AGuiLib;
import net.aeronica.modlibs.aguilib.client.gui.element.color.ColorMode;
import net.aeronica.modlibs.aguilib.server.nbt.NBTHandler;
import net.aeronica.modlibs.aguilib.server.nbt.NBTMutatorProperty;
import net.aeronica.modlibs.aguilib.server.nbt.NBTProperty;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

import java.awt.*;
import java.io.File;

public class AGuiLibConfig implements INBTSerializable<NBTTagCompound>
{
    @NBTProperty
    private int accentColor = 0xFF038288;
    @NBTMutatorProperty(type = String.class)
    private ColorMode colorMode = ColorMode.LIGHT;
    @NBTProperty
    private boolean tabsAlwaysVisible = false;
    @NBTProperty
    private boolean tabsLeftSide = true;

    public int getPrimaryColor() {
        return this.colorMode.getPrimaryColor();
    }

    public int getSecondaryColor() {
        return this.colorMode.getSecondaryColor();
    }

    public int getTertiaryColor() {
        return this.colorMode.getTertiaryColor();
    }

    public int getPrimarySubcolor() {
        return this.colorMode.getPrimarySubcolor();
    }

    public int getSecondarySubcolor() {
        return this.colorMode.getSecondarySubcolor();
    }

    public int getTextColor() {
        return this.colorMode.getTextColor();
    }

    public int getInvertedTextColor() {
        return this.colorMode.getInvertedTextColor();
    }

    public int getAccentColor() {
        return this.accentColor;
    }

    public void setAccentColor(int accentColor) {
        this.accentColor = accentColor;
    }

    public int getDarkAccentColor() {
        int r = this.accentColor >> 16 & 255;
        int g = this.accentColor >> 8 & 255;
        int b = this.accentColor & 255;
        float[] hsb = Color.RGBtoHSB(r, g, b, null);
        Color newColor = Color.getHSBColor(hsb[0], hsb[1], hsb[2] * 0.85F);
        return newColor.getRGB() | 0xFF000000;
    }

    public String getColorMode() {
        return this.colorMode.getName();
    }

    public void setColorMode(String colorMode) {
        this.colorMode = ColorMode.getColorMode(colorMode);
    }

    public boolean areTabsAlwaysVisible() {
        return this.tabsAlwaysVisible;
    }

    public void setTabsAlwaysVisible(boolean tabsAlwaysVisible) {
        this.tabsAlwaysVisible = tabsAlwaysVisible;
    }

    public boolean areTabsLeftSide() {
        return this.tabsLeftSide;
    }

    public void setTabsLeftSide(boolean tabsLeftSide) {
        this.tabsLeftSide = tabsLeftSide;
    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound compound = new NBTTagCompound();
        NBTHandler.INSTANCE.saveNBTData(this, compound);
        return compound;
    }

    @Override
    public void deserializeNBT(NBTTagCompound compound) {
        NBTHandler.INSTANCE.loadNBTData(this, compound);
    }

    public void load() {
        if (!AGuiLib.AGUILIB_ROOT.exists()) {
            AGuiLib.AGUILIB_ROOT.mkdirs();
        }
        File file = new File(AGuiLib.AGUILIB_ROOT, "config.dat");
        try {
            if (!file.exists() && file.createNewFile()) {
                this.save();
            }
            this.deserializeNBT(CompressedStreamTools.read(file));
        } catch (Exception e) {
            AGuiLib.LOGGER.error("Failed to load config", e);
        }
    }

    public void save() {
        if (!AGuiLib.AGUILIB_ROOT.exists()) {
            AGuiLib.AGUILIB_ROOT.mkdirs();
        }
        File file = new File(AGuiLib.AGUILIB_ROOT, "config.dat");
        try {
            CompressedStreamTools.write(this.serializeNBT(), file);
        } catch (Exception e) {
            AGuiLib.LOGGER.error("Failed to save config", e);
        }
    }
}
