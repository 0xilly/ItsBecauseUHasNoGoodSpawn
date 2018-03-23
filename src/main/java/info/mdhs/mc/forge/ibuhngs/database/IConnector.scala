package info.mdhs.mc.forge.ibuhngs.database

import info.mdhs.mc.forge.ibuhngs.api.team.ITeam

import net.minecraft.entity.player.EntityPlayer

trait IConnector {

  def initTables:Unit

  def addTeam(player:EntityPlayer, team: ITeam)


}
