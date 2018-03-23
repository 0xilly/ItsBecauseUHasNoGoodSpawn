package info.mdhs.mc.forge.ibuhngs

import info.mdhs.mc.forge.ibuhngs.util.ModInfo
import net.minecraftforge.common.config.Config
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLServerStartingEvent
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, version = ModInfo.MOD_VERSION, certificateFingerprint = ModInfo.FINGERPRINT, dependencies = ModInfo.DEPENDENCIES)
object IBuhngs {

  @Mod.Instance(ModInfo.MOD_ID)
  var instnace: IBuhngs = null

  private val logger = LogManager.getLogger

  //    public IslandHandler islandHandler;
  @Mod.EventHandler
  def serverStarting(e: FMLServerStartingEvent): Unit = {
    //        e.registerServerCommand(new CreateIslandCMD());
    //        e.registerServerCommand(new TpIslandCMD());
  }

  @Mod.EventHandler
  def postInit(e: FMLPostInitializationEvent): Unit = {
    ////        islandHandler = new IslandHandler();
    //        MinecraftForge.EVENT_BUS.register(islandHandler);
  }
}