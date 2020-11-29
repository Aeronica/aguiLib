
package net.aeronica.modlibs.aguilib;

import net.aeronica.modlibs.aguilib.proxy.ServerProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("unused")
@Mod(
        modid = Reference.MOD_ID,
        name = Reference.MOD_NAME,
        version = Reference.MOD_VERSION,
        acceptedMinecraftVersions = Reference.MC_VERSION,
        dependencies = Reference.DEPENDENCIES,
        updateJSON = Reference.UPDATES,
        certificateFingerprint = Reference.FINGERPRINT
)
public class AGuiLib
{
    private AGuiLib() {/* NOP */}

    private static final class Holder
    {
        private Holder() {/* NOP */}
        private static final AGuiLib INSTANCE = new AGuiLib();
    }

    @Mod.InstanceFactory
    public static AGuiLib instance() {return Holder.INSTANCE;}

    @SidedProxy(clientSide = Reference.PROXY_CLIENT, serverSide = Reference.PROXY_SERVER)
    public static ServerProxy proxy;

    //public static final CreativeTabs MOD_TAB = new ModTab();
    private static final Logger LOGGER = LogManager.getFormatterLogger(Reference.MOD_ID);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        //ModLogger.setLogger(event.getModLog());
        //proxy.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        //NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        //proxy.init();
    }

    @EventHandler
    public void onFingerprintViolation(FMLFingerprintViolationEvent event)
    {
        //LOGGER.warn("Problem with Signed Jar: %s", event.description());
    }

    @EventHandler
    public void onEvent(FMLServerStartingEvent event)
    {
        //event.registerServerCommand(new CommandModelSetup());
        //event.registerServerCommand(new CommandPlayMidi());
    }
}
