package fr.exalow.main.core;

import fr.exalow.main.entities.Player;
import fr.exalow.main.entities.Team;
import fr.exalow.main.manager.PlayerManager;
import fr.exalow.main.utils.PseudoGenerator;
import fr.exalow.main.utils.SaveLoader;

import java.util.*;

public class Game {

    private PlayerManager manager = new PlayerManager();

    public Game(SaveLoader save) {

        final Map<String, Double> dataSave = new SaveLoader().loadDataSave();
        final PseudoGenerator pg = new PseudoGenerator();

        for (String element : dataSave.keySet()) {
            for (int i = 0; i < dataSave.get(element); i++) {
                manager.addPlayer(new Player(this, pg.getRandomName(), manager.getRoleFromString(element)));
            }
        }
    }

    public void update() {
        for (Player player : manager.getPlayerDeath()) {
            if (!player.isAlive()) manager.removePlayer(player);
        }
    }

    public boolean hasWinner() {
        return manager.getVillagerNumber() == 0 || manager.getWerewolfNumber() == 0;
    }

    public Team getWinner() {
        if (!hasWinner()) return null;
        return manager.getPlayerList().get(0).getTeam();
    }

    public Player getRandomPlayer() {
        return manager.getPlayerList().get(new Random().nextInt(manager.getPlayerList().size()));
    }

    public PlayerManager getManager() {
        return manager;
    }
}
