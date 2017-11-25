package io.github.illyohs.ibuhngs.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

/**
 * Created by anthony on 1/28/17.
 */
public class PlaceIslandPosCMD extends CommandBase
{
    @Override
    public String getName()
    {
        return "addislandpos";
    }

    @Override
    public String getUsage(ICommandSender sender)
    {
        return "addislandpos name x y z | Adds a island cords at pos";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {

    }
}
