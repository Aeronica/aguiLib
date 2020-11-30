package net.aeronica.modlibs.aguilib.client.gui.config.property;

import net.aeronica.modlibs.aguilib.client.gui.config.ConfigGUI;
import net.aeronica.modlibs.aguilib.client.gui.element.Element;
import net.aeronica.modlibs.aguilib.client.gui.element.PropertyInputElement;
import net.minecraftforge.common.config.Property;

public class StringConfigProperty extends StringConfigPropertyBase {
    public StringConfigProperty(Property property) {
        super(property);
    }

    @Override
    public Element<ConfigGUI> provideElement(ConfigGUI gui, float x, float y) {
        return new PropertyInputElement(gui, x, y, 192, this);
    }

    @Override
    public boolean isValidString(String value) {
        return false;
    }
}
