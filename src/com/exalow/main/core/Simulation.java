package com.exalow.main.core;

import com.exalow.main.entities.Player;
import com.exalow.main.event.Event;
import com.exalow.main.event.EventManager;

import java.util.List;

public class Simulation {

    private EventManager manager = new EventManager();
    private Game game = new Game();
    private int cycle;
    private String day;

    public void start() {

        game.load();

        while (!game.hasWinner()) {
            day();
            night();
            cycle++;
        }
        stop();
    }

    public void day() {
        System.out.println(day = "[JOUR " + cycle + "]");

        for (Event event : manager.getLastDeaths("[NUIT " + (cycle - 1) + "]")) {
            event.getPlayer().printDeathMessage();
        }
    }

    public void night() {
        System.out.println(day = "[NUIT " + cycle + "]");
    }

    private void stop() {
        System.out.println("\n[INFO] L'équipe " + game.getWinner() + " a gagnée !");
        this.manager.addEvent(new Event(day, game.getWinner()));
        this.manager.writeElements();
    }

}
