package fr.exalow.main.utils;

import java.io.*;

public class FileUtils {

    public static void createFile(File file) {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveContent(File file, boolean useSameFile, String content) {
        try {

            final PrintWriter writer = new PrintWriter(new FileWriter(file, useSameFile));
            writer.print(content);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String loadContent(File file) {

        StringBuilder builder = new StringBuilder();

        try {

            final BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
