package com.exalow.main.roles;

import com.exalow.main.entities.Team;

public class Werewolf implements Role{

    @Override
    public String getName() {
        return "Loup-Garou";
    }

    @Override
    public Team getTeam() {
        return Team.WEREWOLVES;
    }

    @Override
    public void useAbility() {
        // Doesn't have ability
    }
}
