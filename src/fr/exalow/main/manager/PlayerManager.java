package fr.exalow.main.manager;

import fr.exalow.main.entities.Player;
import fr.exalow.main.entities.Team;
import fr.exalow.main.roles.Role;
import fr.exalow.main.roles.Villager;
import fr.exalow.main.roles.Werewolf;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerManager {

    private List<Player> playerList = new LinkedList<>();

    public void addPlayer(Player player) {
        this.playerList.add(player);
    }

    public void removePlayer(Player player) {
        this.playerList.remove(player);
    }

    public List<Player> getPlayerDeath() {
        return this.playerList.stream()
                .filter((player) -> player.isDead())
                .collect(Collectors.toList());
    }

    public long getVillagerNumber() {
        return playerList.stream()
                .filter((player) -> player.getTeam() == Team.VILLAGE)
                .count();
    }

    public long getWerewolfNumber() {
        return playerList.stream()
                .filter((player) -> player.getTeam() == Team.WEREWOLVES)
                .count();
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public static Role getRoleFromString(String role) {
        switch (role) {
            case "VILLAGER":
                return new Villager();
            case "WEREWOLF":
                return new Werewolf();
            default:
                throw new RuntimeException("Role not found !");
        }
    }
}
