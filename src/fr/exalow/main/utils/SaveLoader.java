package fr.exalow.main.utils;

import com.google.gson.Gson;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SaveLoader {

    private Scanner scan = new Scanner(System.in);

    public Map<String, Double> loadDataSave() {

        final File dateFile = new File("src/save.json");
        final Gson gson = new Gson();

        System.out.print("[?] Charger une sauvegarde ? : ");

        if ((scan.nextBoolean())) {
            if (dateFile.exists()) {
                System.out.println("\n[!] Chargement de la sauvegarde...\n");
                return gson.fromJson(FileUtils.loadContent(dateFile), Map.class);
            }
            System.err.println("\n[!] Aucune sauvegarde n'est disponible !");
        }

        FileUtils.saveContent(dateFile, false, gson.toJson(createDataSave()));

        System.out.println("\n[!] Chargement de la sauvegarde...\n");
        return gson.fromJson(FileUtils.loadContent(dateFile), Map.class);
    }

    private Map<String, Double> createDataSave() {

        Map<String, Double>  data = new HashMap<>();

        System.out.print("\nSimple-Villageois : ");
        data.put("VILLAGER", scan.nextDouble());

        System.out.print("Loup-Garou : ");
        data.put("WEREWOLF", scan.nextDouble());

        return data;
    }
}
