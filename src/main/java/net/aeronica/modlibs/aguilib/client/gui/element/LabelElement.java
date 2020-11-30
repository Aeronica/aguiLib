package net.aeronica.modlibs.aguilib.client.gui.element;

import net.aeronica.modlibs.aguilib.AGuiLib;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LabelElement<T extends IElementGUI> extends Element<T> {
    private String text;

    public LabelElement(T handler, String text, float posX, float posY) {
        super(handler, posX, posY, 0, 0);
        this.text = text;
    }

    @Override
    public void render(float mouseX, float mouseY, float partialTicks) {
        this.gui.getFontRenderer().drawString(this.text, this.getPosX(), this.getPosY(), AGuiLib.CONFIG.getTextColor(), false);
    }
}

