/**Class: logIn
 * @author Sidibaba Simpara, Malik Key, Britney Familia, Angelica Jones
 * @version 1.0
 * Course: ITEC 3860, Summer 2025
 * 
 *
 *
 * Creates the structure for the logIn method to be used in the GameController.
 *
 */

package controller;

import gameExceptions.GameException;

import java.sql.SQLException;

public interface logIn {

    void logIn() throws InterruptedException, SQLException, ClassNotFoundException, GameException;
}
