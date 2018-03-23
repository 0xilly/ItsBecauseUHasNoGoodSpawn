package info.mdhs.mc.forge.ibuhngs.api.island;

import info.mdhs.mc.forge.ibuhngs.api.team.ITeam;

import net.minecraft.util.math.BlockPos;

import java.util.List;

public interface IIslandRegistry
{
    void createIsland(BlockPos pos);

    List<IIsland> getIslands();

    void wipeIsland(IIsland island);

    void createTeamIslands(BlockPos pos, ITeam team, IIsland island);

}
