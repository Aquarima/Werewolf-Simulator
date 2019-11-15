package com.exalow.main.core;

import com.exalow.main.entities.*;
import com.exalow.main.event.Event;
import com.exalow.main.event.EventManager;
import com.exalow.main.utils.*;
import com.exalow.main.roles.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Game {

    private List<Player> playerList = new LinkedList<>();

    public void load() {

        final Map<String, Double> save = new SaveLoader().load();
        final PseudoGenerator generator = new PseudoGenerator();

        for (String a : save.keySet()) {
            for (int i = 0; i < save.get(a); i++) {
                playerList.add(new Player(this, generator.getRandomName(), getClassInstanceOf(a)));
            }
        }
    }

    public void removePlayer(EventManager manager, Player player, String day, String reason) {
        manager.addEvent(new Event(day, player, reason));
        this.playerList.remove(player);
    }

    public long countVillagers() {
        return playerList.stream()
                .filter((x) -> x.getTeam() == Team.VILLAGE)
                .count();
    }

    public long countWerewolves() {
        return playerList.stream()
                .filter((x) -> x.getTeam() == Team.WEREWOLVES)
                .count();
    }

    public boolean hasWinner() {
        return countVillagers() == 0 || countWerewolves() == 0;
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

    public Player getRandomPlayer() {
        return playerList.get(new Random().nextInt(playerList.size()));
    }

    public Team getWinner() {
        return playerList.get(0).getTeam();
    }
}
