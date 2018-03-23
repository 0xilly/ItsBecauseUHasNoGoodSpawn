package info.mdhs.mc.forge.ibuhngs.util;

import net.minecraftforge.common.config.Config;

import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(ModInfo.MOD_ID)
public class ModCgf
{
    @Config.Comment("Auto make islands on login")
    public static boolean AutoMakeIsland      = true;

    @Config.Comment("Allow island teleportion if player is not OP")
    public static boolean AllowIslandTp       = false;

    @Config.Comment("Allow island creation if player is not OP")
    public static boolean AllowIslandCreation = false;

    @Config.Comment("Allows safe island creation")
    public static boolean AllowSafeIslandCreation =false;

    @Config.Comment("Distance between islands")
    public static int     distance            = 500;

    @Config.Comment("Should be the same as the platform in YUMakeNoGoodMap")
    public static String  platform            = "TREE";
}
