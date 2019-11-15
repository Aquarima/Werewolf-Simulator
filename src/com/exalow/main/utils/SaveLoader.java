package com.exalow.main.utils;

import com.google.gson.Gson;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SaveLoader {

    private File file = new File("src/save.json");
    private Scanner scan = new Scanner(System.in);

    public Map<String, Double> load() {

        final Gson gson = new Gson();

        System.out.print("[?] Charger une sauvegarde ? : ");

        if ((scan.nextBoolean())) {
            if (file.exists()) {
                System.out.println("\n[!] Chargement de la sauvegarde...\n");
                return gson.fromJson(FileUtils.loadContent(file), Map.class);
            }
            System.err.println("\n[!] Aucune sauvegarde n'est disponible !");
        }

        FileUtils.saveContent(file, false, gson.toJson(userSelection()));

        System.out.println("\n[!] Chargement de la sauvegarde...\n");
        return gson.fromJson(FileUtils.loadContent(file), Map.class);
    }

    private Map<String, Double> userSelection() {

        Map<String, Double> selection = new HashMap<>();

        System.out.print("\nSimple-Villageois : ");
        selection.put("VILLAGER", scan.nextDouble());

        System.out.print("Loup-Garou : ");
        selection.put("WEREWOLF", scan.nextDouble());

        return selection;
    }
}
