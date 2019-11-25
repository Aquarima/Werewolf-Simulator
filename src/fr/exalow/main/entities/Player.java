package fr.exalow.main.entities;

import fr.exalow.main.core.Game;
import fr.exalow.main.roles.Role;

public class Player {

    private Game game;
    private String name;
    private Role role;

    public Player(Game game, String name, Role role) {
        this.game = game;
        this.name = name;
        this.role = role;
    }

    public void vote() {
        this.role.vote();
    }

    public void useAbility() {
        this.role.useAbility();
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public Team getTeam() {
        return this.role.getTeam();
    }
}
