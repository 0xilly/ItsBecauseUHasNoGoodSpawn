package info.mdhs.mc.forge.ibuhngs.api;

import info.mdhs.mc.forge.ibuhngs.api.island.IIslandRegistry;
import info.mdhs.mc.forge.ibuhngs.api.team.ITeamRegistry;

public interface IBuhngsAPI
{
    IIslandRegistry getIslandManger();
    ITeamRegistry getTeamManger();
}
