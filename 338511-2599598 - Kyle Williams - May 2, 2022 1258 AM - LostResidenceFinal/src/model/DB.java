package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class : DB.java
 * @author: Sidibaba Simpara, Malik Key, Britney Familia, Angelica Jones
 * @version: 2.0
 * Purpose: Controls basic DB functionality (Query and Update DB)
 */
public abstract class DB {
    protected String dbName = "Game.db";
    protected String sJdbc;
    protected String sDriverName;
    protected Connection conn;
    protected String sDbUrl;
    protected int timeout = 5;

    /**
     * Initializes the database connection.
     */
    public void initConnection() {
        try {
            Class.forName("org.sqlite.JDBC"); // optional in newer JDBC versions
            sDbUrl = "jdbc:sqlite:" + dbName;
            conn = DriverManager.getConnection(sDbUrl);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Failed to connect to database: " + e.getMessage());
        }
    }

    /**
     * Query the database.
     * @param sql SQL SELECT statement
     * @return ResultSet
     * @throws SQLException
     */
    public ResultSet queryDB(String sql) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.setQueryTimeout(timeout);
        return stmt.executeQuery(sql);
    }

    /**
     * Execute a database update (INSERT, UPDATE, DELETE).
     * @param SQL update statement
     * @return boolean success
     * @throws SQLException
     */
    public boolean updateDB(String SQL) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.execute(SQL);
    }

    /**
     * Get the count of records in the specified table.
     */
    public int count(String table) {
        int cnt = 0;
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT COUNT(*) AS count FROM \"" + table + "\"";
            ResultSet rs = stmt.executeQuery(sql);
            cnt = rs.getInt(1);
        } catch (SQLException sqe) {
            System.out.println(sqe.getMessage());
        }
        return cnt;
    }

    /**
     * Get max value for a column in a table.
     */
    public int getMaxValue(String columnName, String table) {
        int max = 0;
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT MAX(" + columnName + ") FROM " + table;
            ResultSet rs = stmt.executeQuery(sql);
            max = rs.getInt(1);
        } catch (SQLException sqe) {
            System.out.println(sqe.getMessage());
        }
        return max;
    }

    /**
     * Close the database connection safely.
     */
    public void close() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println("Failed to close DB: " + e.getMessage());
        }
    }
}
