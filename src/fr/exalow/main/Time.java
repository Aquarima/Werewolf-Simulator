package fr.exalow.main;

import fr.exalow.main.core.Game;
import fr.exalow.main.entities.DeathEvent;
import fr.exalow.main.entities.Player;

public class Time {

    private Game game;
    private String day;

    public Time(Game game) {
        this.game = game;
    }

    public void onDay(int cycle) {

        System.out.println("\n[Jour " + cycle + "]");
        System.err.println("\nLe Jour se lève avec " + game.getDeathManager().getLastDeaths(day).size() + " mort : ");

        for (Player player : game.getDeathManager().getLastDeaths(day)) {
            player.printDeathMessage();
        }

        this.game.update(day);
        this.day = "[Jour " + cycle + "]";
    }

    public void onNight(int cycle) {
        System.out.println("\n[Nuit " + cycle + "]");
        this.day = "[Nuit " + cycle + "]";
        this.game.getDeathManager().registerDeath(new DeathEvent(game.getRandomPlayer(), day, "Just a test !"));
    }

}
