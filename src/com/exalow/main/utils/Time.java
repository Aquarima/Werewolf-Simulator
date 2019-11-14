package com.exalow.main.utils;

import com.exalow.main.core.Game;
import com.exalow.main.entities.Player;

public class Time {

    private Game game;
    private DateFormat df = new SimpleDateFormat("hh:mm:ss");
    private String time = df.format(new Date());

    public Time(Game game) {
        this.game = game;
    }

    public void onDay(int day) {
        System.out.println("\n[JOUR " + day + "]");
    }

    public void onNight(int day) {
        System.out.println("\n[NUIT " + day + "]");
    }

}
