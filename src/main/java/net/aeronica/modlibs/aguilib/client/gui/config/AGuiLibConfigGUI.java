package net.aeronica.modlibs.aguilib.client.gui.config;

import net.aeronica.modlibs.aguilib.AGuiLib;
import net.aeronica.modlibs.aguilib.client.gui.element.CheckboxElement;
import net.aeronica.modlibs.aguilib.client.gui.element.ColorElement;
import net.aeronica.modlibs.aguilib.client.gui.element.Element;
import net.aeronica.modlibs.aguilib.server.property.IBooleanProperty;
import net.aeronica.modlibs.aguilib.server.property.IIntProperty;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

@SideOnly(Side.CLIENT)
public class AGuiLibConfigGUI extends ConfigGUI {
    private static final List<ConfigProperty> APPEARANCE_PROPERTIES = new ArrayList<>();

    static {
        AGuiLibConfigGUI.APPEARANCE_PROPERTIES.add(new ConfigProperty("Accent Color") {
            @Override
            public Element<ConfigGUI> provideElement(ConfigGUI gui, float x, float y) {
                return new ColorElement<>(gui, x, y, 195, 149, new IIntProperty() {
                    @Override
                    public int getInt() {
                        return AGuiLib.CONFIG.getAccentColor();
                    }

                    @Override
                    public void setInt(int value) {
                        AGuiLib.CONFIG.setAccentColor(value);
                    }

                    @Override
                    public boolean isValidInt(int value) {
                        return true;
                    }
                });
            }
        });
        AGuiLibConfigGUI.APPEARANCE_PROPERTIES.add(new ConfigProperty("Dark Mode") {
            @Override
            public Element<ConfigGUI> provideElement(ConfigGUI gui, float x, float y) {
                return new CheckboxElement<>(gui, x, y, new IBooleanProperty() {
                    @Override
                    public boolean getBoolean() {
                        return AGuiLib.CONFIG.getColorMode().equals("dark");
                    }

                    @Override
                    public void setBoolean(boolean value) {
                        AGuiLib.CONFIG.setColorMode(value ? "dark" : "light");
                    }

                    @Override
                    public boolean isValidBoolean(boolean value) {
                        return true;
                    }
                });
            }
        });
    }

    public AGuiLibConfigGUI(GuiScreen parent) {
        super(parent, AGuiLib.instance(), null);
        this.categories.add(new ConfigCategory("Appearance", AGuiLibConfigGUI.APPEARANCE_PROPERTIES));
    }

    @Override
    public void onGuiClosed() {
        AGuiLib.CONFIG.save();
        super.onGuiClosed();
    }
}
