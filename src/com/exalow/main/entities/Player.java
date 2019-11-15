package com.exalow.main.entities;

import com.exalow.main.core.Game;
import com.exalow.main.roles.Role;

public class Player {

    private Game game;
    private String name;
    private Role role;

    public Player(Game game, String name, Role role) {
        this.game = game;
        this.name = name;
        this.role = role;
    }

    public void printDeathMessage() {
        System.out.println(name + " est mort, Il était " + role + " !");
    }

    public String getName() {
        return name;
    }

    public String getRoleName() {
        return role.getName();
    }

    public Team getTeam() {
        return this.role.getTeam();
    }
}
