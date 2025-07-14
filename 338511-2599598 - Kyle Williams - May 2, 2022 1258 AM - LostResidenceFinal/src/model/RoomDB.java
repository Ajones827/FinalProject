/**Class: RoomDatabase
 * @author Sidibaba Simpara, Malik Key, Britney Familia, Angelica Jones
 * @version 1.0
 * Course: ITEC 3860, Summer 2025
 *
 *
 * The purpose of this class is to hold methods that update and query the database.
 *
 */

package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class RoomDatabase {

    public static HashMap<Integer, Room> loadRooms(String filename) {
        HashMap<Integer, Room> rooms = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split("\\|");

                int roomID = Integer.parseInt(parts[0].trim());
                String roomName = parts[1].trim();
                String biome = parts[2].trim();
                String description = parts[3].trim();
                boolean visited = Boolean.parseBoolean(parts[4].trim());
                String exitData = parts.length > 5 ? parts[5].trim() : "";

                ArrayList<Exit> exits = new ArrayList<>();
                if (!exitData.isEmpty()) {
                    String[] exitParts = exitData.split(",");
                    for (String exitPair : exitParts) {
                        String[] directionID = exitPair.split(":");
                        if (directionID.length == 2) {
                            String direction = directionID[0].trim();
                            int destID = Integer.parseInt(directionID[1].trim());
                            exits.add(new Exit(direction, destID));
                        }
                    }
                }

                Room room = new Room(roomID, roomName, biome, description, visited, exits);
                rooms.put(roomID, room);
            }

        } catch (IOException e) {
            System.out.println("Error reading room file: " + e.getMessage());
        }

        return rooms;
    }
}
