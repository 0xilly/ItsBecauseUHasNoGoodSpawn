package io.github.illyohs.ibuhngs.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import io.github.illyohs.ibuhngs.IBuhngs;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by anthony on 12/5/16.
 */
public class TpIslandCMD extends CommandBase
{
    @Override
    public String getName()
    {
        return "tpisland";
    }

    @Override
    public String getUsage(ICommandSender sender)
    {
        return "/tptoisland <islandname> | Teleports player to island";
    }

    @Override
    public int getRequiredPermissionLevel()
    {
        return 0;
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender)
    {
        return true;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {

        if (sender instanceof EntityPlayer)
        {
            EntityPlayer playerSender = (EntityPlayer) sender.getCommandSenderEntity();
            if (args.length == 1)
            {
                if (IBuhngs.ModConfig.AllowIslandTp || server.getPlayerList().getOppedPlayers().getGameProfileFromName(playerSender.getName()) != null)
                {
                    IBuhngs.instnace.islandHandler.teleportToPlayerIsland(playerSender, args[0]);
                } else
                {
                    ((EntityPlayer) sender).sendStatusMessage(new TextComponentString("You dont have permmsion to use this command"));
                }
            }
        } else
        {
            if (args.length == 2)
            {
                EntityPlayerMP targetPlayer = server.getPlayerList().getPlayerByUsername(args[0]);
                IBuhngs.instnace.islandHandler.teleportToPlayerIsland(targetPlayer, args[1]);
            }

        }
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos)
    {
        return getListOfStringsMatchingLastWord(args, IBuhngs.instnace.islandHandler.islandMap.keySet());
    }
}
