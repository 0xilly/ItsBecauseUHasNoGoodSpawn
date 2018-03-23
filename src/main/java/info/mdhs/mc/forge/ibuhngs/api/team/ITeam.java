package info.mdhs.mc.forge.ibuhngs.api.team;

import java.util.List;
import java.util.UUID;

public interface ITeam
{
    UUID getLeader();
    String getName();
    String getColor();
    List<UUID> getMembers();
}
