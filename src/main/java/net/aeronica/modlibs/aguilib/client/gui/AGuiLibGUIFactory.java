package net.aeronica.modlibs.aguilib.client.gui;

import net.aeronica.modlibs.aguilib.client.gui.config.AGuiLibConfigGUI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Set;

@SideOnly(Side.CLIENT)
public class AGuiLibGUIFactory implements IModGuiFactory
{
    @Override
    public void initialize(Minecraft mc) {
    }

    @Override
    public boolean hasConfigGui() {
        return true;
    }

    @Override
    public GuiScreen createConfigGui(GuiScreen parentScreen) {
        return new AGuiLibConfigGUI(parentScreen);
    }

    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
        return null;
    }
}
