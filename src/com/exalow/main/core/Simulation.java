package com.exalow.main.core;

import com.exalow.main.event.Event;
import com.exalow.main.event.EventManager;
import com.exalow.main.utils.Time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Simulation {

    private EventManager manager = new EventManager();
    private Game game;
    private Time time;
    private int cycle;

    public Simulation() {
        this.game = new Game(manager);
        game.load();
        this.time = new Time(game);
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
        final DateFormat df = new SimpleDateFormat("hh:mm:ss");
        System.out.println("\nL'équipe " + game.getWinner() + " a gagnée !");
        this.manager.addEvent(new Event(df.format(new Date()), game.getWinner()));
    }

}
