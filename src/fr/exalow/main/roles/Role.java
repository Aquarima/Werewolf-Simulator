package fr.exalow.main.roles;

import fr.exalow.main.entities.Player;
import fr.exalow.main.entities.Team;

public interface Role {

    Team getTeam();
    Player vote();
    void useAbility();
}
