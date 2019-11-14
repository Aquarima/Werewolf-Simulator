package com.exalow.main.event;

import com.exalow.main.entities.Player;
import com.exalow.main.entities.Team;

public class Event {

    private String time;
    private String day;
    private String reason;
    private Player player;
    private Team team;

    public Event(String time, String day, Player player, String reason) {
        this.time = time;
        this.day = day;
        this.player = player;
        this.reason = reason;
    }

    public Event(String time, Team team) {
        this.time = time;
        this.team = team;
    }

    public String getTime() {
        return time;
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
        if (team != null) return "[" + time + "] Victoire de l'équipe " + team + " !";
        return "[" + time + "] " + day + " " + player.getName() + " (" + player.getRoleName() + ") " + reason;
    }
}
