package com.exalow.main.roles;

import com.exalow.main.entities.Team;

public class Villager implements Role {

    @Override
    public String getName() {
        return "Simple-Villageois";
    }

    @Override
    public Team getTeam() {
        return Team.VILLAGE;
    }

    @Override
    public void useAbility() {
        // Doesn't have ability
    }
}
