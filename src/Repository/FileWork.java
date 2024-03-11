package Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileWork {
    public static final String filename = "input.txt";

    public void addAll(ArrayList<String> food) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            for (String line : food) {
                writer.append(' ');
                writer.write(line);
            }
            writer.close();
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // приводит arraylist к hashmap со счетчиком повторяющихся значений
    public HashMap<String, Integer> arrayListToHashMapWithFrequency(ArrayList<String> arrayList) {
        HashMap<String, Integer> a = new HashMap<>();
        for (String word : arrayList) {
            a.put(word, a.getOrDefault(word, 0) + 1);
        }
        return a;
    }

    public static void createFile() {
        try {
            File db = new File(filename);
            if (db.createNewFile()) {
                System.out.println("DB created");
            } else {
                System.out.println("DB already exists");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public ArrayList<String> readAll() {
        ArrayList<String> arr = null;
        try {
            File file = new File(filename);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            line = line.replaceAll("\\s+", " ");
            arr = new ArrayList<>(List.of(line.split(" ")));
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }
}
