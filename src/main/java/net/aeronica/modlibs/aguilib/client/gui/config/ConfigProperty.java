package net.aeronica.modlibs.aguilib.client.gui.config;


import net.aeronica.modlibs.aguilib.client.gui.element.Element;

public abstract class ConfigProperty {
    public final String name;
    public final String description;

    public ConfigProperty(String name) {
        this(name, "");
    }

    public ConfigProperty(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public abstract Element<ConfigGUI> provideElement(ConfigGUI gui, float x, float y);
}
