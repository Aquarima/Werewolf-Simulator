package fr.exalow.main.manager;

import fr.exalow.main.entities.Player;
import fr.exalow.main.roles.Role;
import fr.exalow.main.roles.Villager;
import fr.exalow.main.roles.Werewolf;

import java.util.List;

public class PlayerManager {

    public static Player getPlayerByRole(List<Player> playerList, Role role) {
        for (Player player : playerList) {
            if (player.getRole() == role) return player;
        }
        return null;
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
