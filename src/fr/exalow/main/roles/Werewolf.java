package fr.exalow.main.roles;

import fr.exalow.main.core.Game;
import fr.exalow.main.entities.Player;
import fr.exalow.main.entities.Team;

public class Werewolf implements Role {

    @Override
    public Team getTeam() {
        return Team.WEREWOLVES;
    }

    @Override
    public Player vote(Game game) {
        Player player;
        do {
            player = game.getRandomPlayer();
        } while (player.getTeam() == this.getTeam());
        return player;
    }

    @Override
    public void useAbility(Game game) {
        // Doesn't have ability
    }

    @Override
    public String toString() {
        return "Loup-Garou";
    }
}
