package fr.exalow.main.utils;

import fr.exalow.main.entities.Player;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class VoteHandler {

    private List<Player> votes = new ArrayList<>();

    public void addVote(Player player) {
        this.votes.add(player);
    }

    public Optional<Player> getResult() {
        return votes.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey);
    }

    public void reset() {
        this.votes.clear();
    }
}
