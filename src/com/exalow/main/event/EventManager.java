package com.exalow.main.event;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EventManager {

    private List<Event> listeners = new ArrayList<>();

    public void addEvent(Event event) {
        this.listeners.add(event);
    }

    public List<Event> getLastDeaths(String day) {
        return listeners.stream()
                .filter((x) -> x.getDay() == day)
                .collect(Collectors.toList());
    }

    public void writeElements() {

        try {

            final File[] files = new File("src/logs/").listFiles();
            final BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src/logs/game " + (files.length + 1) )));

            for (Event event : listeners) {
                writer.write(event.toString());
                writer.write("\n");
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
