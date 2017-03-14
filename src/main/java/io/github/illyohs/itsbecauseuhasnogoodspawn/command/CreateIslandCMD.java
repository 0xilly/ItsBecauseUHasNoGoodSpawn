package io.github.illyohs.itsbecauseuhasnogoodspawn.command;

import net.minecraft.command.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import io.github.illyohs.itsbecauseuhasnogoodspawn.IBuhngs;

import javax.annotation.Nullable;
import java.util.List;

public class CreateIslandCMD extends CommandBase
{
    @Override
    public String getName()
    {
        return "createislandfor";
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
    public String getUsage(ICommandSender sender)
    {
        return "/createislandfor <player> | creates an island and adds it to list";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        Entity sent = sender.getCommandSenderEntity();

        if (IBuhngs.ModConfig.AllowIslandCreation || server.getPlayerList().getOppedPlayers().getGameProfileFromName(sender.getName()) != null) {
            if (args.length == 1) {
                EntityPlayer player = getPlayer(server, sender, args[0]);
                IBuhngs.instnace.islandHandler.spawnIslandForPlayer(player);
            } else {
                throw new WrongUsageException(getUsage(sender));
            }
        } else
        {
            sender.sendMessage(new TextComponentString("You dont have permmsion to use this command"));
        }

//        if ()
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos)
    {
        return getListOfStringsMatchingLastWord(args, server.getOnlinePlayerNames());
    }
}
