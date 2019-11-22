package fr.exalow.main.entities;

import fr.exalow.main.roles.Role;

public class Player {

    private String name;
    private Role role;

    public Player(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public void vote() {

    }

    public void useAbility() {

    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public Team getTeam() {
        return role.getTeam();
    }
}
