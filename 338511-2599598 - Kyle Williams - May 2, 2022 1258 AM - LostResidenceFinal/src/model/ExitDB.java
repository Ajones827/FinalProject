/**Class: ExitDB.java
 * @author Sidibaba Simpara, Malik Key, Britney Familia, Angelica Jones
 * Course: Course: ITEC 3860, Summer 2025
 *
 *
 *
 * 
 *
 */

package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ExitDatabase {

    public static HashMap<Integer, ArrayList<Exit>> loadExits(String filename) {
        HashMap<Integer, ArrayList<Exit>> exitMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split("\\|");
                int roomID = Integer.parseInt(parts[0].trim());
                String direction = parts[1].trim();
                int destinationID = Integer.parseInt(parts[2].trim());

                Exit exit = new Exit(direction, destinationID);

                exitMap.computeIfAbsent(roomID, k -> new ArrayList<>()).add(exit);
            }

        } catch (IOException e) {
            System.out.println("Error reading exit file: " + e.getMessage());
        }

        return exitMap;
    }
}

