
package net.aeronica.modlibs.aguilib.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.server.FMLServerHandler;

public class ServerProxy
{
    public void preInit() {/* NOP */}

    public void init() {/* NOP */}

    public void postInit() {/* NOP */}

    public Side getPhysicalSide() {return Side.SERVER;}

    public Side getEffectiveSide() {return getPhysicalSide();}

    public EntityPlayer getClientPlayer() {return null;}

    public Minecraft getMinecraft() {return null;}

    public World getClientWorld() {return null;}

    public World getWorldByDimensionId(int dimension)
    {
        return FMLServerHandler.instance().getServer().getWorld(dimension);
    }
}
