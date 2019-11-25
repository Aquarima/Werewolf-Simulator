package fr.exalow.main.utils;

import fr.exalow.main.entities.Player;

import java.util.ArrayList;
import java.util.List;

public class VoteHandler {

    private List<Player> votes = new ArrayList<>();

    public void addVote(Player player) {
        this.votes.add(player);
    }

    public Player getResult() {
        return null;
    }

    public void reset() {
        this.votes.clear();
    }
}
