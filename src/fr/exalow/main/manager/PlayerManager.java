package fr.exalow.main.manager;

import fr.exalow.main.entities.Player;
import fr.exalow.main.roles.Role;
import fr.exalow.main.roles.Villager;
import fr.exalow.main.roles.Werewolf;

import java.util.List;

public class PlayerManager {

    public static Player getPlayerByRole(List<Player> playerlist, Role role) {
        return null;
    }

    public static Role getInstanceFrom(String role) {
        switch (role) {
            case "VILLAGER":
                return new Villager();
            case "WEREWOLF":
                return new Werewolf();
            default:
                throw new RuntimeException("Name not found !");
        }
    }
}
