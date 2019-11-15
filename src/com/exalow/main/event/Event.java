package com.exalow.main.event;

import com.exalow.main.entities.Player;
import com.exalow.main.entities.Team;

public class Event {

    private String day;
    private String reason;
    private Player player;
    private Team team;

    public Event(String day, Player player, String reason) {
        this.day = day;
        this.player = player;
        this.reason = reason;
    }

    public Event(String day,Team team) {
        this.day = day;
        this.team = team;
    }

    public String getDay() {
        return day;
    }

    public Player getPlayer() {
        return player;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public String toString() {
        if (team != null) return day + " Victoire de l'équipe " + team + " !";
        return  day + " " + player.getName() + " (" + player.getRoleName() + ") " + reason;
    }
}
