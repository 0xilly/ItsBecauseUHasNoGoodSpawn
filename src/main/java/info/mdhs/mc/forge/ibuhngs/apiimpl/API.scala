package info.mdhs.mc.forge.ibuhngs.apiimpl

import java.lang.reflect.Field

import info.mdhs.mc.forge.ibuhngs.api.IBuhngsAPI
import info.mdhs.mc.forge.ibuhngs.api.island.IIslandRegistry
import info.mdhs.mc.forge.ibuhngs.api.team.{ITeam, ITeamRegistry}
import info.mdhs.mc.forge.ibuhngs.apiimpl.island.IslandRegistry
import info.mdhs.mc.forge.ibuhngs.apiimpl.team.TeamRegistry


import net.minecraftforge.fml.common.discovery.ASMDataTable

object API {
  private val INSTANCE = new API

  def instance: IBuhngsAPI = INSTANCE

  def bind(adt: ASMDataTable): Unit = {
    val acn = classOf[BindBuhngs].getCanonicalName
    val dataSet = adt.getAll(acn)
    import scala.collection.JavaConversions._
    for (asmData <- dataSet) {
      try {
        val clazz:Class[_] = Class.forName(asmData.getClassName)
        val field:Field = clazz.getField(asmData.getObjectName)

        if (field.getType == classOf[IBuhngsAPI]) {
          field.set(null, INSTANCE)
        }
      }
    }
  }
}

class API extends IBuhngsAPI {

  val team:ITeamRegistry = new TeamRegistry
  val island:IIslandRegistry = new IslandRegistry

  override def getIslandManger: IIslandRegistry = island

  override def getTeamManger: ITeamRegistry = team
}