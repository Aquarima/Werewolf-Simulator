package com.exalow.main.core;

import com.exalow.main.entities.*;
import com.exalow.main.utils.*;
import com.exalow.main.roles.*;

import java.util.*;

public class Game {

    private List<Player> playerList = new LinkedList<>();
    private EventManager manager;

    public Game(EventManager manager) {
       this.manager = manager;
    }

    public void load() {

        final Map<String, Double> save = new SaveLoader().load();
        final PseudoGenerator generator = new PseudoGenerator();

        for (String a : save.keySet()) {
            for (int i = 0; i < save.get(a); i++) {
                playerList.add(new Player(this, generator.getRandomName(), getClassInstanceOf(a)));
            }
        }
    }

    public void removePlayer(Player player) {
        this.playerList.remove(player);
    }

    public long getNumberOfVillager() {
        return playerList.stream()
                .filter((x) -> x.getTeam() == Team.VILLAGE)
                .count();
    }

    public long getNumberOfWolf() {
        return playerList.stream()
                .filter((x) -> x.getTeam() == Team.WEREWOLVES)
                .count();
    }

    public Player getRandomPlayer() {
        return playerList.get(new Random().nextInt(playerList.size()));
    }

    public boolean hasWinner() {
        return getNumberOfVillager() == 0 || getNumberOfWolf() == 0;
    }

    public Team getWinner() {
        return playerList.get(0).getTeam();
    }

    private Role getClassInstanceOf(String role) {
        switch (role) {
            case "VILLAGER":
                return new Villager();
            case "WEREWOLF":
                return new Werewolf();
            default:
                throw new RuntimeException();
        }
    }

}
