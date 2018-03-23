package info.mdhs.mc.forge.ibuhngs.api.team;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;

public interface ITeamRegistry
{
    void createTeam(EntityPlayer player, String name);

    List<ITeam> getTeams();

    void setTeamColor(ITeam team, String color);

//    void get
}
