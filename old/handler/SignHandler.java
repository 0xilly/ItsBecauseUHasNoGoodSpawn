package io.github.illyohs.ibuhngs.handler;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSign;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by anthony on 12/1/16.
 */
public class SignHandler
{


    @SubscribeEvent
    public void playerHitSign(RightClickBlock event)
    {
        Block blk = event.getEntityPlayer().world.getBlockState(new BlockPos(event.getHitVec())).getBlock();
        if (blk instanceof BlockSign)
        {
            World world = event.getEntityPlayer().world;
            TileEntity tile = world.getTileEntity(new BlockPos(event.getHitVec()));
            String sign = tile.getTileData().getCompoundTag("Sign").getString("Text0");


            System.out.println(sign);
        }
    }
}
