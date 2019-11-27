package fr.exalow.main.roles;

import fr.exalow.main.core.Game;
import fr.exalow.main.entities.Player;
import fr.exalow.main.entities.Team;

public class Villager implements Role {

    @Override
    public Team getTeam() {
        return Team.VILLAGE;
    }

    @Override
    public Player vote(Game game) {
        return game.getRandomPlayer();
    }

    @Override
    public void useAbility(Game game) {
        // Doesn't have ability
    }

    @Override
    public String toString() {
        return "Simple-Villageois";
    }
}
