package io.github.illyohs.ibuhngs.api.island;

import io.github.illyohs.ibuhngs.api.team.ITeam;
import net.minecraft.util.math.BlockPos;

import java.util.List;

public interface IIslandManager
{
    void createIsland(BlockPos pos);

    List<IIsland> getIslands();

    void wipeIsland(IIsland island);

    void createTeamIslands(ITeam team, IIsland island);

}
