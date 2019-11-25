package fr.exalow.main.roles;

import fr.exalow.main.core.Game;
import fr.exalow.main.entities.Player;
import fr.exalow.main.entities.Team;
import fr.exalow.main.manager.DeathManager;

public class Villager implements Role {

    @Override
    public Team getTeam() {
        return Team.VILLAGE;
    }

    @Override
    public Player vote(Game game) {
        return null;
    }

    @Override
    public void useAbility(DeathManager manager) {
        // Doesn't have ability
    }
}
