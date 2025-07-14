/**
 * Class : CreateFilesController.java
 * @author: Sidibaba Simpara, Malik Key, Britney Familia, Angelica Jones
 * @version: 2.0
 * Course: ITEC 3860, Summer 2025
 *
 * This class calls into the model to build the database if it doesn't exist.
 */

package controller;

import java.sql.SQLException;

import gameExceptions.GameException;
import model.GameDBCreate;


public class CreateFilesController {

    public void createFile() throws GameException {
        try {
            GameDBCreate sdb = new GameDBCreate();
            sdb.buildTables();

        } catch(SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}
