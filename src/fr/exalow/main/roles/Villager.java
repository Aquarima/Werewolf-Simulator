package fr.exalow.main.roles;

import fr.exalow.main.entities.Player;
import fr.exalow.main.entities.Team;

public class Villager implements Role {

    @Override
    public Team getTeam() {
        return null;
    }

    @Override
    public Player vote() {
        return null;
    }

    @Override
    public void useAbility() {

    }
}
