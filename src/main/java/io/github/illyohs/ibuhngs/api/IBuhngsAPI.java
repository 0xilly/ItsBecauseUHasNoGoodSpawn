package io.github.illyohs.ibuhngs.api;

import io.github.illyohs.ibuhngs.api.island.IIslandManager;
import io.github.illyohs.ibuhngs.api.team.ITeam;

public interface IBuhngsAPI
{
    IIslandManager getIslandManger();
    ITeam getTeamManger();
}
