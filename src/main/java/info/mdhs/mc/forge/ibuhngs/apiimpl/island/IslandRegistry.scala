package info.mdhs.mc.forge.ibuhngs.apiimpl.island

import java.util

import info.mdhs.mc.forge.ibuhngs.api.island.{IIsland, IIslandRegistry}
import info.mdhs.mc.forge.ibuhngs.api.team.ITeam
import io.github.illyohs.ibuhngs.api.island.{IIsland, IIslandRegistry}
import io.github.illyohs.ibuhngs.api.team.ITeam

import net.minecraft.util.math.BlockPos

class IslandRegistry extends IIslandRegistry {

  override def createIsland(pos: BlockPos): Unit = {

  }

  override def getIslands: util.List[IIsland] = {

  }

  override def wipeIsland(island: IIsland): Unit = {

  }

  override def createTeamIslands(pos: BlockPos, team: ITeam, island: IIsland): Unit = {

  }
}
