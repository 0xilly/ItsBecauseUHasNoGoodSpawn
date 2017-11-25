package io.github.illyohs.ibuhngs.api.team;

import java.util.List;
import java.util.UUID;

public interface ITeam
{
    UUID getLeader();
    String getName();
    String getcolor();
    List<UUID> getMembers();
}
