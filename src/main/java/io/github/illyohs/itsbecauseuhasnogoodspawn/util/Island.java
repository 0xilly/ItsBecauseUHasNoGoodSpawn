package io.github.illyohs.itsbecauseuhasnogoodspawn.util;

import java.util.UUID;

/**
 * Created by anthony on 12/1/16.
 */
public class Island
{

    String playerName;
    UUID   playerId;
    String islandName;
    int    posX;
    int    posY;
    int    posZ;

    public Island(String playerName, UUID playerId, String islandName, int posX, int posY, int posZ) {
        this.playerName = playerName;
        this.playerId = playerId;
        this.islandName = islandName;
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
    }

    public String getPlayerName() {
        return playerName;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public String getIslandName() {
        return islandName;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getPosZ() {
        return posZ;
    }
}
