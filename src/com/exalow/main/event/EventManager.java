package com.exalow.main.event;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String date = "(" + df.format(new Date()) + ")";

        try {

            final BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src/games/" + date)));

            for (Event event :listeners) {
                writer.write(event.toString());
            }

            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
