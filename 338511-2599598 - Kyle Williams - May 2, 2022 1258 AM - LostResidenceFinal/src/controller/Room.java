/**Class: Room.java
 * @author Kyle Williams, Rick Price, Bradley Iverson, Miranda Darlington
 * @version 1.0
 * Course: ITEC 3860, Spring 2022
 * Written: 02/18 - 04/27
 *
 *
 * This class serves as the blueprint for all room objects that get stores in the room database.
 *
 */

package controller;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private int roomID;
    private String roomName;
    private String biome;
    private String roomDescription;
    private boolean visited;
    private ArrayList<Exit> exits;

    public Room(int roomID, String roomName, String biome, String roomDescription, boolean visited, ArrayList<Exit> exits) {
        this.roomID = roomID;
        this.roomName = roomName;
        this.biome = biome;
        this.roomDescription = roomDescription;
        this.visited = visited;
        this.exits = exits;
    }

    public Room() {
        this.exits = new ArrayList<>();
    }

    public int getRoomID() {
        return roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getBiome() {
        return biome;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public boolean hasVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Exit> getExits() {
        return exits;
    }

    public void addExit(Exit e) {
        exits.add(e);
    }

    @Override
    public String toString() {
        return "ROOM-ID: " + roomID +
                "\nROOM-NAME: " + roomName +
                "\nBIOME: " + biome +
                "\nDESCRIPTION: " + roomDescription +
                "\nVISITED: " + visited +
                "\nEXITS: " + exits + "\n";
    }
}

