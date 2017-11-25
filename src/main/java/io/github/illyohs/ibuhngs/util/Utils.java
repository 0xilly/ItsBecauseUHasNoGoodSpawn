package io.github.illyohs.ibuhngs.util;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anthony on 1/17/17.
 */
public class Utils
{
    public static Chunk getChunkCordsForPos(World world, BlockPos pos)
    {
        return world.getChunkFromBlockCoords(pos);
    }


    public static boolean isValidSpawnLoc(World world, BlockPos pos)
    {
        List<Block> blockList = new ArrayList<>();
        for (int x = 0; x < 16; ++x)
        {
            for (int y = 0; y < 16; ++y)
            {
                for (int z = 0; z < 16; ++z)
                {
                    Block blk= world.getBlockState(new BlockPos(pos.getX() +x, pos.getY() + y, pos.getZ() + z)).getBlock();
                    blockList.add(blk);
                }
            }
        }

        for (Block block: blockList)
        {
            if (block != Blocks.AIR) return false;
        }

        return true;
    }

}
