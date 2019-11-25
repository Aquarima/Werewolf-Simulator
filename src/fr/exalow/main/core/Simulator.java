package fr.exalow.main.core;

import fr.exalow.main.manager.DeathManager;
import fr.exalow.main.utils.SaveLoader;

public class Simulator {

    private Game game = new Game(new SaveLoader());
    private DeathManager deathManager = game.getDeathManager();

    public void start() {

    }

    public void day() {

    }

    public void night() {

    }

    public void stop() {
        this.deathManager.writeElements();
    }
}
