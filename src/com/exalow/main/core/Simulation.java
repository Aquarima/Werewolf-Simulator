package com.exalow.main.core;

import com.exalow.main.event.EventManager;
import com.exalow.main.utils.Time;

public class Simulation {

    private EventManager manager = new EventManager();
    private Game game = new Game();
    private Time time;
    private int cycle;

    public Simulation() {
        this.time = new Time(game);
        game.load();
    }

    public void start() {
        while (!game.hasWinner()) {
            time.onDay(cycle);
            time.onNight(cycle);
            cycle++;
        }
        stop();
    }

    private void stop() {
        System.out.println("\nL'équipe " + game.getWinner() + " a gagnée !");
    }

}
