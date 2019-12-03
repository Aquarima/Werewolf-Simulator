package fr.exalow.main.utils;

import fr.exalow.main.entities.Player;

import java.util.*;

public class VoteHandler {

    private List<Player> votes = new ArrayList<>();

    public void addVote(Player player) {
        this.votes.add(player);
    }

    public Player getResult() {

        Map<Player, Integer> results = new HashMap<>();

        for (Player player : votes) {
            results.put(player, results.get(player) + 1);
        }

        Player moreVotedPlayer = null;

        for (Player player : results.keySet()) {
            if (results.get(player) > results.get(moreVotedPlayer)) {
                moreVotedPlayer = player;
            }
        }

        return moreVotedPlayer;
    }

    public void reset() {
        this.votes.clear();
    }
}
