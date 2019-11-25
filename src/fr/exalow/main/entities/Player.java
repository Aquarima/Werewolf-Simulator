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

    public void vote(Game game) {
        this.role.vote(game);
    }

    public void useAbility() {
        this.role.useAbility(game.getDeathManager());
    }

    public void onDeath() {

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

    @Override
    public String toString() {
        return "Name : " + name + " -  Role " + role;
    }
}
