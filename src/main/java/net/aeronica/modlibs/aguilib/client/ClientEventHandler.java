package net.aeronica.modlibs.aguilib.client;

import net.aeronica.modlibs.aguilib.client.util.ClientUtils;
import net.aeronica.modlibs.aguilib.server.config.ConfigHandler;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public enum ClientEventHandler
{
    INSTANCE;

    @SubscribeEvent
    public void onRenderUpdate(TickEvent.RenderTickEvent event) {
        ClientUtils.updateLast();
    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        ConfigHandler.INSTANCE.loadConfigForID(event.getModID());
        ConfigHandler.INSTANCE.saveConfigForID(event.getModID());
    }
}
