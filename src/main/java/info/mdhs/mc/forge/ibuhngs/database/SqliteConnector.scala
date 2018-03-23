package info.mdhs.mc.forge.ibuhngs.database
import java.sql.{Connection, DriverManager, Statement}

import info.mdhs.mc.forge.ibuhngs.api.team.ITeam

import net.minecraft.entity.player.EntityPlayer

class SqliteConnector extends IConnector {

  var con:Connection = _
  con = DriverManager.getConnection("jdbc:sqlite:ibugngs.db")
  var statement:Statement = con.createStatement()
  statement.setQueryTimeout(15)

  override def initTables: Unit = {
    statement.execute("CREATE TABLE IF NOT EXISTS buhn (" +
      "LEADER TEXT NOT NULL," +
      "NAME TEXT NOT NULL," +
      "COLOR TEXT NOT NULL," +
      "MEMBERS TEXT[] NOT NULL)")
  }

  override def addTeam(player: EntityPlayer, team: ITeam): Unit = {

  }
}
