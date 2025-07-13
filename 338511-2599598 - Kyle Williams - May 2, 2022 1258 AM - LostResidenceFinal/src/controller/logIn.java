/**Class: logIn
 * @author Malik Key
 * @version 1.0
 * Course: ITEC 3860
 * Written: 07/13/25
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
