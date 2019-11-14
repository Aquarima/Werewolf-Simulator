package com.exalow.main.roles;

import com.exalow.main.entities.Team;

public interface Role {

    String getName();

    Team getTeam();

    void useAbility();

}
