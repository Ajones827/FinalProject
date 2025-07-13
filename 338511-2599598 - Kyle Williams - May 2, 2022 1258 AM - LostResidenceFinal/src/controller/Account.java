/**Class: Account
 * @author Malik Key
 * @version 1.0
 * Course: ITEC 3860
 * Written: 07/13/25
 *
 *
 * This class wasn't really needed but I keep it in here just in case we need to create account objects
 * within the game.
 *
 */

package controller;

public class Account {

    private int acctID;
    private String userID;
    private String password;
    private String saveFileName;

    protected void createAccount(){

    }

    public int getAcctID() {
        return acctID;
    }

    public void setAcctID(int acctID) {
        this.acctID = acctID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSaveFileName() {
        return saveFileName;
    }

    public void setSaveFileName(String saveFileName) {
        this.saveFileName = saveFileName;
    }
}
