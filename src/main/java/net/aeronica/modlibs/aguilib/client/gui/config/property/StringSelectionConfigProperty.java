package net.aeronica.modlibs.aguilib.client.gui.config.property;

import net.aeronica.modlibs.aguilib.client.gui.config.ConfigGUI;
import net.aeronica.modlibs.aguilib.client.gui.element.DropdownButtonElement;
import net.aeronica.modlibs.aguilib.client.gui.element.Element;
import net.aeronica.modlibs.aguilib.server.property.IStringSelectionProperty;
import net.minecraftforge.common.config.Property;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class StringSelectionConfigProperty extends StringConfigPropertyBase implements IStringSelectionProperty
{
    private final Set<String> validStringValues;

    public StringSelectionConfigProperty(Property property) {
        super(property);
        this.validStringValues = new HashSet<>();
        Collections.addAll(this.validStringValues, property.getValidValues());
    }

    @Override
    public Element<ConfigGUI> provideElement(ConfigGUI gui, float x, float y) {
        return new DropdownButtonElement(gui, x, y, 192, 12, this);
    }

    @Override
    public Set<String> getValidStringValues() {
        return this.validStringValues;
    }
}
