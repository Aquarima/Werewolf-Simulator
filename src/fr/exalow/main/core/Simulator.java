package fr.exalow.main.core;

import fr.exalow.main.entities.Player;
import fr.exalow.main.utils.SaveLoader;
import fr.exalow.main.utils.VoteHandler;

public class Simulator {

    private Game game;

    public Simulator() {
        this.game = new Game(new SaveLoader());
    }

    public void start() {
        int cycle = 0;
        while (!game.hasWinner()) {
            onNight(cycle);
            onDay(cycle);
            cycle++;
        }
        stop();
    }

    public void onDay(int cycle) {

        System.out.println("\n[Jour " + cycle + "]\n");
        System.err.print("Le Jour se lève avec " + game.getManager().getPlayerDeath().size() + " mort(s) : ");

        for (Player player : game.getManager().getPlayerDeath()) {
            player.printDeathMessage();
        }

        game.update();
    }

    public void onNight(int cycle) {
        System.out.println("\n[Nuit " + cycle + "]\n");
        System.out.println("La Nuit tombe, les loups vont choisir leurs victime...");
        game.getRandomPlayer().setAlive(true);
    }

    private void stop() {
        System.out.print("\nL'équipe " + game.getWinner() + " a gagnée ! : ");
        for (Player player : game.getManager().getPlayerList()) {
            System.out.println(player.toString() + " ");
        }
    }
}
