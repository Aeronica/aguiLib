
package net.aeronica.modlibs.aguilib;

import net.aeronica.modlibs.aguilib.proxy.ServerProxy;
import net.aeronica.modlibs.aguilib.server.config.ConfigHandler;
import net.aeronica.modlibs.aguilib.server.config.AGuiLibConfig;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

@SuppressWarnings("unused")
@Mod(
        modid = Reference.MOD_ID,
        name = Reference.MOD_NAME,
        version = Reference.MOD_VERSION,
        acceptedMinecraftVersions = Reference.MC_VERSION,
        dependencies = Reference.DEPENDENCIES,
        updateJSON = Reference.UPDATES,
        certificateFingerprint = Reference.FINGERPRINT,
        guiFactory = "net.aeronica.modlibs.aguilib.client.gui.AGuiLibGUIFactory"
)
public class AGuiLib
{
    public static AGuiLibConfig CONFIG = new AGuiLibConfig();
    public static final Logger LOGGER = LogManager.getLogger(Reference.MOD_ID);
    public static final File AGUILIB_ROOT = new File(".", Reference.MOD_NAME);

    private AGuiLib() {/* NOP */}

    private static final class Holder
    {
        private Holder() {/* NOP */}
        private static final AGuiLib INSTANCE = new AGuiLib();
    }

    @Mod.InstanceFactory
    public static AGuiLib instance() {return Holder.INSTANCE;}

    @SidedProxy(clientSide = Reference.PROXY_CLIENT, serverSide = Reference.PROXY_SERVER)
    public static ServerProxy PROXY;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        if (!AGuiLib.AGUILIB_ROOT.exists() && AGuiLib.AGUILIB_ROOT.mkdirs()) {
            LOGGER.info("{} config directory created: {}", Reference.MOD_NAME, AGUILIB_ROOT.getPath());
        }

        for (ModContainer mod : Loader.instance().getModList()) {
            ConfigHandler.INSTANCE.injectConfig(mod, event.getAsmData());
//            NetworkHandler.INSTANCE.injectNetworkWrapper(mod, event.getAsmData());
        }

        AGuiLib.CONFIG.load();
        AGuiLib.PROXY.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        AGuiLib.PROXY.init();
    }

    @EventHandler
    public void onPostInit(FMLPostInitializationEvent event) {
        AGuiLib.PROXY.postInit();
    }


    @EventHandler
    public void onFingerprintViolation(FMLFingerprintViolationEvent event)
    {
        LOGGER.warn("Detected invalid fingerprint for file {}! You will not receive support with this tampered version of aguilib!", event.getSource().getName());
    }

    @EventHandler
    public void onEvent(FMLServerStartingEvent event)
    {
        //event.registerServerCommand(new CommandModelSetup());
        //event.registerServerCommand(new CommandPlayMidi());
    }
}
