package io.github.illyohs.ibuhngs.handler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import io.github.illyohs.ibuhngs.util.Utils;
import net.minecraft.command.ICommandManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;
import io.github.illyohs.ibuhngs.IBuhngs;
import io.github.illyohs.ibuhngs.api.island.Island;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class IslandHandler
{


    private static IslandHandler instance = null;

    private Path      islandPath = Paths.get("./config/island.json");
    private Gson      gson;
    public  HashMap<String, Island> islandMap = new HashMap<>();

    @SubscribeEvent
    public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent e)
    {
        EntityPlayer player = e.player;
        BlockPos spawnPos = player.world.getSpawnPoint();

        if (islandMap.isEmpty())
        {
            islandMap.put("spawn", new Island("default_island", null, "spawn_island", spawnPos.getX(), spawnPos.getY() + 2, spawnPos.getZ()));
        }
        if (IBuhngs.ModConfig.AutoMakeIsland) {
            if (!islandMap.containsKey(player.getName())) {
                List<Integer> xPosList = new ArrayList<Integer>();
                islandMap.forEach((p, i) -> xPosList.add(i.getPosX()));
                int maxPosX = Collections.max(xPosList);
                if (!IBuhngs.ModConfig.AllowSafeIslandCreation)
                {
                    addToIslandListAndTeleportPlayer(player, "island_" + player.getName(), new BlockPos(maxPosX + IBuhngs.ModConfig.distance, spawnPos.getY(), spawnPos.getZ()));
                } else {
                    if (Utils.isValidSpawnLoc(player.getEntityWorld(), new BlockPos(maxPosX + IBuhngs.ModConfig.distance, spawnPos.getY(), spawnPos.getZ())))
                    {
                        addToIslandListAndTeleportPlayer(player, "island_" + player.getName(), new BlockPos(maxPosX + IBuhngs.ModConfig.distance, spawnPos.getY(), spawnPos.getZ()));
                    } else {
                        int shift = maxPosX + IBuhngs.ModConfig.distance + 16;
                        addToIslandListAndTeleportPlayer(player, "island_" + player.getName(), new BlockPos(shift, spawnPos.getY(), spawnPos.getZ()));
                    }
                }
            }
        }

    }

    @SubscribeEvent
    public void loadIslandList(WorldEvent.Load e)
    {
        File confFile = new File(e.getWorld().getWorldInfo().getWorldName() + "/island.json");
        gson = new Gson();
        try (Reader reader = new FileReader(confFile))
        {
            HashMap<String,Island> newIslandMap = gson.fromJson(reader, new TypeToken<HashMap<String,Island>>(){}.getType());
            islandMap.clear();

            islandMap.putAll(newIslandMap);
            FMLLog.getLogger().info("Found " + islandMap.size() + " islands list now loading islands.");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @SubscribeEvent
    public void saveIslandList(WorldEvent.Save e)
    {
        File confFile = new File(e.getWorld().getWorldInfo().getWorldName() + "/island.json");
        try {
            if (!Files.exists(islandPath))
            {
                Files.createFile(islandPath);
            }

            if (!confFile.exists())
            {
                if (FMLCommonHandler.instance().getSide() == Side.SERVER)
                {
                    confFile.createNewFile();
                }
            }

            gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

            //TODO remove
            if (FMLCommonHandler.instance().getSide() == Side.SERVER)
            {
                try (FileWriter w = new FileWriter(confFile))
                {
                    gson.toJson(islandMap, w);
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    public void addToIslandList(EntityPlayer player, String islandName, BlockPos pos)
    {
        islandMap.put(player.getName(),new Island(player.getName(), player.getUniqueID(), islandName, pos.getX(), pos.getY(), pos.getZ()));
    }

    public void addToIslandListAndTeleportPlayer(EntityPlayer player, String islandName, BlockPos pos)
    {
        addToIslandList(player, islandName, pos);
        createIslandAndTeleport(player, pos);
        player.setPositionAndUpdate(pos.getX(),pos.getY() + 2,pos.getZ());
        System.out.println(pos);

    }

    public void createIslandAndTeleport(EntityPlayer player, BlockPos pos)
    {

        if (player.getServer() != null)
        {
            ICommandManager icm    = player.getEntityWorld().getMinecraftServer().getCommandManager();

            icm.executeCommand(player.getServer(), "/platform spawn yunomakegoodmap:" +
                    IBuhngs.ModConfig.platform +" none " + pos.getX()+ " "+ pos.getY()+ " "+ pos.getZ());
        }
    }

    public void teleportToPlayerIsland(EntityPlayer player, String islandName)
    {
        Island island = islandMap.get(islandName);
        player.setPositionAndUpdate(island.getPosX(), island.getPosY(), island.getPosZ());
    }

    public void removeIsland(String islandName)
    {
        islandMap.remove(islandName);
    }

    public void spawnIslandForPlayer(EntityPlayer player)
    {
        BlockPos spawnPos = player.getEntityWorld().getSpawnPoint();
        if (islandMap.containsKey(player.getName()))
        {
//            islandMap.remove(player.getName());
//            List<Integer> xPosList = new ArrayList<Integer>();
//            islandMap.forEach((p,i) -> xPosList.add(i.getPosX()));
//            int maxPosX = Collections.max(xPosList);
//            addToIslandListAndTeleportPlayer(player, "island_" + player.getName(), new BlockPos(maxPosX +
//                    IBuhngs.ModConfig.distance, spawnPos.getY(), spawnPos.getZ()));

        } else
        {
            List<Integer> xPosList = new ArrayList<Integer>();
            islandMap.forEach((p,i) -> xPosList.add(i.getPosX()));
            int maxPosX = Collections.max(xPosList);
            addToIslandListAndTeleportPlayer(player, "island_" + player.getName(), new BlockPos(maxPosX +
                    IBuhngs.ModConfig.distance, spawnPos.getY(), spawnPos.getZ()));
        }
        Island island = islandMap.get(player.getName());
        player.setPositionAndUpdate(island.getPosX(), island.getPosY(), island.getPosZ());
    }

    //TODO implement
    public void addIsland(EntityPlayer player) throws Exception
    {
        if (islandMap.containsKey(player.getName()))
        {
            throw new Exception("Player Island already exists");
        } else
        {
            islandMap.put(player.getName(), new Island(player.getName(), player.getUniqueID(),"island_" + player.getName(),
                    (int)player.posX, (int)player.posY, (int)player.posZ));
        }
    }

}
