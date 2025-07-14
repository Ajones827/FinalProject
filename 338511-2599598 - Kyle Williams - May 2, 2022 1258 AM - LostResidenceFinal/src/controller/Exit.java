/**Class: Exit
 * @author Sidibaba Simpara, Malik Key, Britney Familia, Angelica Jones
 * Course: Course: ITEC 3860, Summer 2025
 *
 *
 *
 *
 *
 */

package controller;


public class Exit {
    private String direction;
    private int destinationID;

    public Exit(String direction, int destinationID) {
        this.direction = direction;
        this.destinationID = destinationID;
    }

    public String getDirection() {
        return direction;
    }

    public int getDestinationID() {
        return destinationID;
    }

    @Override
    public String toString() {
        return direction + " → Room " + destinationID;
    }
}

