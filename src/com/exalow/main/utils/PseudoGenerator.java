package com.exalow.main.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PseudoGenerator {

    private List<String> pseudos = new ArrayList<>();

    public PseudoGenerator() {
        pseudos.add("Delta");
        pseudos.add("Bravo");
        pseudos.add("Sierra");
        pseudos.add("November");
        pseudos.add("Yankee");
    }

    public String getRandomName() {
        Random r = new Random();
        String pseudo = pseudos.get(r.nextInt(pseudos.size()));
        pseudos.remove(pseudo);
        return pseudo;
    }
}
