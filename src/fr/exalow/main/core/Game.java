package fr.exalow.main.core;

import fr.exalow.main.entities.DeathEvent;
import fr.exalow.main.entities.Player;
import fr.exalow.main.entities.Team;
import fr.exalow.main.manager.DeathManager;
import fr.exalow.main.manager.PlayerManager;
import fr.exalow.main.utils.PseudoGenerator;
import fr.exalow.main.utils.SaveLoader;

import java.util.*;

public class Game {

    private DeathManager deathManager = new DeathManager();
    private List<Player> playerList = new LinkedList<>();

    public Game(SaveLoader save) {

        final Map<String, Double> dataSave = new HashMap<>();
        final PseudoGenerator pg = new PseudoGenerator();

        for (String element : dataSave.keySet()) {
            for (int i = 0; i < dataSave.get(element); i++) {
                playerList.add(new Player(this, pg.getRandomName(), PlayerManager.getInstanceFrom(element)));
            }
        }
    }

    public void update(String day) {
        for (DeathEvent event : deathManager.getLastDeaths(day)) {
            this.playerList.remove(event.getPlayer());
        }
    }

    public boolean hasWinner() {
        return this.getVillagerNumber() == 0 || this.getWerewolfNumber() == 0;
    }

    public Team getWinner() {
        if (!hasWinner()) return null;
        return playerList.get(0).getTeam();
    }

    private long getVillagerNumber() {
        return playerList.stream()
                .filter((x) -> x.getTeam() == Team.VILLAGE)
                .count();
    }

    private long getWerewolfNumber() {
        return playerList.stream()
                .filter((x) -> x.getTeam() == Team.WEREWOLVES)
                .count();
    }

    public Player getRandomPlayer() {
        return playerList.get(new Random().nextInt(playerList.size()));
    }

    public DeathManager getDeathManager() {
        return deathManager;
    }
}
