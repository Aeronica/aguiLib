
package net.aeronica.modlibs.aguilib.proxy;

import net.aeronica.modlibs.aguilib.client.ClientEventHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Timer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;


public class ClientProxy extends ServerProxy
{
    public static final Minecraft MINECRAFT = Minecraft.getMinecraft();
    public static final Timer TIMER = ReflectionHelper.getPrivateValue(Minecraft.class, ClientProxy.MINECRAFT, "timer", "field_71428_T", "aa");

    @Override
    public void preInit()
    {
        super.preInit();
        MinecraftForge.EVENT_BUS.register(ClientEventHandler.INSTANCE);
    }

    @Override
    public void init()
    {
        super.init();
    }

    @Override
    public void postInit()
    {
        super.postInit();       
    }

    @Override
    public Side getPhysicalSide() {return Side.CLIENT;}

    @Override
    public Side getEffectiveSide() {return FMLCommonHandler.instance().getEffectiveSide();}

    @Override
    public Minecraft getMinecraft() {return Minecraft.getMinecraft();}

    @Override
    public EntityPlayer getClientPlayer() {return Minecraft.getMinecraft().player;}

    @Override
    public World getClientWorld() {return Minecraft.getMinecraft().world;}

    @Override
    public World getWorldByDimensionId(int dimension)
    {
        Side effectiveSide = FMLCommonHandler.instance().getEffectiveSide();
        if (effectiveSide == Side.SERVER)
        {
            return FMLClientHandler.instance().getServer().getWorld(dimension);
        } else
        {
            return getClientWorld();
        }
    }

    @Override
    public float getPartialTicks() {
        return ClientProxy.TIMER.renderPartialTicks;
    }
}
