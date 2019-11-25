package fr.exalow.main.utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PseudoGenerator {

    private List<String> names = new LinkedList<>();

    public PseudoGenerator() {
        names.add("Jerry");
        names.add("Delta");
        names.add("Sierra");
        names.add("November");
        names.add("Yankee");
    }

    public String getRandomName() {
        final Random random = new Random();
        String randomName = names.get(random.nextInt(names.size()));
        names.remove(randomName);
        return randomName;
    }
}
