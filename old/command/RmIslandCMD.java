package io.github.illyohs.ibuhngs.command;

import io.github.illyohs.ibuhngs.IBuhngs;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.server.permission.PermissionAPI;

import javax.annotation.Nullable;
import java.util.List;

public class RmIslandCMD extends CommandBase
{
    @Override
    public String getName()
    {
        return "rmisland";
    }

    @Override
    public int getRequiredPermissionLevel()
    {
        return 0;
    }

    @Override
    public String getUsage(ICommandSender sender)
    {
        return "rm <IslandName> | removes island from island list";
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
            if (PermissionAPI.hasPermission(getCommandSenderAsPlayer(sender),"ibuhngs.island.rm"))
            {
                if (args.length == 1)
                {
                    IBuhngs.instnace.islandHandler.removeIsland(args[0]);
                } else {
                    getCommandSenderAsPlayer(sender).sendStatusMessage(new TextComponentString("Incorrect usage or island does not exist"));
                }
            } else {
                getCommandSenderAsPlayer(sender).sendStatusMessage(new TextComponentString("You must be op to use this command"));
            }
        } else {
            sender.sendMessage(new TextComponentString("This command can only be issued by a player."));
        }
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos)
    {
        return getListOfStringsMatchingLastWord(args, IBuhngs.instnace.islandHandler.islandMap.keySet());
    }
}
