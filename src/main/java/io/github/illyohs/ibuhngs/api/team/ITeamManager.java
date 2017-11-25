package io.github.illyohs.ibuhngs.api.team;

import java.util.List;

public interface ITeamManager
{
    void createTeam(ITeam team);

    List<ITeam> getTeams();

    void setTeamColor(ITeam team, String color);

//    void get
}
