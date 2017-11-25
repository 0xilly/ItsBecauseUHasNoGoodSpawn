package io.github.illyohs.ibuhngs;

import io.github.illyohs.ibuhngs.util.ModInfo;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.server.permission.DefaultPermissionLevel;
import net.minecraftforge.server.permission.PermissionAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = ModInfo.MOD_ID,
        name = ModInfo.MOD_NAME,
        version = ModInfo.MOD_VERSION,
        certificateFingerprint = ModInfo.FINGERPRINT,
        dependencies = ModInfo.DEPENDENCIES
)
public class IBuhngs
{

    private Logger logger = LogManager.getLogger();

    @Mod.Instance(ModInfo.MOD_ID)
    public static IBuhngs instnace;

//    public IslandHandler islandHandler;

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent e)
    {
//        e.registerServerCommand(new CreateIslandCMD());
//        e.registerServerCommand(new TpIslandCMD());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {
////        islandHandler = new IslandHandler();
//        MinecraftForge.EVENT_BUS.register(islandHandler);

        PermissionAPI.registerNode("ibuhngs.island.rm", DefaultPermissionLevel.OP, "deletes island from list");
    }

//    @Mod.EventHandler
//    public void onFMLFingerprintViolation(FMLFingerprintViolationEvent et)
//    {
//        logger.fatal("*********************************************************************");
//        logger.fatal("* YOU ARE RUNNING AN UNSIGNED VERSION OF " + ModInfo.MOD_NAME+ "  *");
//        logger.fatal("* YOU SHOULD REMOVE THIS IMMEDIATELY AND REPORT THIS TO THE AUTHOR! *");
//        logger.fatal("*********************************************************************");
//    }



    @Config(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME)
    public static class ModConfig
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


}
