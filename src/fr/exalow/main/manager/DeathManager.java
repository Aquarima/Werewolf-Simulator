package fr.exalow.main.manager;

import fr.exalow.main.entities.DeathEvent;
import fr.exalow.main.entities.Player;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class DeathManager {

    private List<DeathEvent> deaths = new LinkedList<>();

    public void registerDeath(DeathEvent death) {
        this.deaths.add(death);
    }

    public void unregisterDeath(Player player) {
        for (DeathEvent death : deaths) {
            if (death.getPlayer() == player) {
                this.deaths.remove(death);
            }
        }
    }

    public List<Player> getLastDeaths(String day) {
        return deaths.stream()
                .filter((x) -> x.getDay().equals(day))
                .map((x) -> x.getPlayer())
                .collect(Collectors.toList());
    }

    public void writeElements() {
        try {
            final File[] elements = new File("src/games/").listFiles();
            final BufferedWriter writer = new BufferedWriter(new FileWriter("src/games/game " + (elements.length + 1)));

            for (DeathEvent death : deaths) {
                writer.write(death.toString() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
