package info.mdhs.mc.forge.ibuhngs.apiimpl.team

import java.util
import java.util.UUID

import info.mdhs.mc.forge.ibuhngs.api.team.{ITeam, ITeamRegistry}

import net.minecraft.entity.player.EntityPlayer
//import scala.collection.JavaConversions._

class TeamRegistry extends ITeamRegistry {

  private val teamList:util.List[ITeam] = util.ArrayList[ITeam]

  override def createTeam(entity:EntityPlayer, name:String): Unit = {

    teamList.add(new Team(entity.getUniqueID, name, "WHITE", util.Arrays.asList(entity.getUniqueID)))
  }

  override def getTeams: util.List[ITeam] = {

  }

  override def setTeamColor(team: ITeam, color: String): Unit = {

  }
}

class Team(leader: UUID, name:String, color:String, members:util.List[UUID]) extends ITeam {
  override def getLeader: UUID = leader

  override def getName: String = name

  override def getColor(): String = color

  override def getMembers: util.List[UUID] = members
}
