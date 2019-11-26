package fr.exalow.main.core;

import fr.exalow.main.Time;
import fr.exalow.main.utils.SaveLoader;

public class Simulator {

    private Game game;
    private int cycle;

    public Simulator() {
        this.game = new Game(new SaveLoader());
    }

    public void start() {

        final Time time = new Time(game);

        while (!game.hasWinner()) {
            time.onNight(cycle);
            time.onDay(cycle);
            cycle++;
        }
        stop();
    }

    private void stop() {
        System.out.println("\nL'équipe " + game.getWinner() + " a gagnée !");
        this.game.getDeathManager().writeElements();
    }
}
