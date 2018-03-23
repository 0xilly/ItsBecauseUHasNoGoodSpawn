package info.mdhs.mc.forge.ibuhngs.api.island;

import net.minecraft.util.math.BlockPos;

import java.util.UUID;

public interface IIsland
{
    String getPlayer();
    UUID   getPlayerID();
    BlockPos getPos();

}
