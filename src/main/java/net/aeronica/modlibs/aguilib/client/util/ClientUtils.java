package net.aeronica.modlibs.aguilib.client.util;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author iLexiconn
 * @since 1.0.0
 */
@SideOnly(Side.CLIENT)
public class ClientUtils
{
    private static long lastUpdate = System.currentTimeMillis();

    /**
     * Update the current time.
     */
    public static void updateLast() {
        lastUpdate = System.currentTimeMillis();
    }

    /**
     * Update a value with the default factor of 0.5.
     *
     * @param current the current value
     * @param target the target
     * @return the updated value
     */
    public static float updateValue(float current, float target) {
        return ClientUtils.updateValue(current, target, 0.5F);
    }

    /**
     * Update a value with a custom factor. How higher the factor, how slower the update. The value will get updated
     * slower if the user has a low framerate.
     *
     * @param current the current value
     * @param target the target
     * @param factor the factor
     * @return the updated value
     */
    public static float updateValue(float current, float target, float factor) {
        float times = (System.currentTimeMillis() - ClientUtils.lastUpdate) / 16.666666666666668F;
        float off = (off = target - current) > 0.01F || off < -0.01F ? off * (float) Math.pow(factor, times) : 0.0F;
        return target - off;
    }

    public static float interpolate(float prev, float current, float partialTicks) {
        return prev + partialTicks * (current - prev);
    }

    public static float interpolateRotation(float prev, float current, float partialTicks) {
        float shortest = ((current - prev) % 360 + 540) % 360 - 180;
        return prev + shortest * partialTicks;
    }
}
