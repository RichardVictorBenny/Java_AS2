package funcitons;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

/**
 * A class that establishes connection with the database. 
 * 
 * @author Richard
 */
public class Database {
    private String username = "root";
    private String password = "richard";
    private String database = "objects";
    private String url = "jdbc:mysql://localhost:3390/" + database;
    Connection connnection;
    PreparedStatement statement;

    /**
     * Constructor for the database class
     */
    public Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("connection failed");
            // add to logger
        }
        try {
            this.connnection = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * inserts value into the database
     * 
     * @param table  - String table name
     * @param values - String table heading with comma seperation
     * @param record - Arraylist<?> id as String and object as Book
     */
    public void insert(String table, String values, ArrayList<Object> record) {
        /* String values = columnArray.stream().collect(Collectors.joining(",")); */
        int arrLength = record.size();
        String placeHolder = "";
        for (int i = 0; i < arrLength; i++) {
            placeHolder += "?";
            if (i != arrLength - 1) {
                placeHolder += ",";
            }
        }
        String query = "INSERT INTO " + table + " (" + values + ") VALUES(" + placeHolder + ")";
        try {
            this.statement = connnection.prepareStatement(query);
            for (int i = 0; i < arrLength; i++) {
                this.statement.setObject(i + 1, record.get(i));
            }
            this.statement.execute();
            this.statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            // add to logger
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Fetches all the rows in a database.
     * @param table String - table name
     * @return ResultSet
     */
    public ResultSet findAll(String table) {
        try {
            this.statement = connnection.prepareStatement("SELECT * FROM " + table);
            ResultSet result = this.statement.executeQuery();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

/**
 * a function to find the last row of a given table.
 * @param table
 * @param primaryKey
 * @return
 * @throws SQLException
 */
    public ResultSet findLastRow(String table, String primaryKey) throws SQLException{
        String query = "SELECT * FROM "+ table +" ORDER BY "+ primaryKey +" DESC LIMIT 1";
        this.statement = connnection.prepareStatement(query);
        return this.statement.executeQuery();
    }
    /**
     * Finds rows that meets the where condition
     * 
     * @param tableName String - name of table
     * @param idColumnName String - name of the column in the where clause
     * @param idValue String - value in the Where condition
     * @return ResultSet
     */
    public ResultSet find(String tableName, String idColumnName, String idValue) {
        try {
            this.statement = connnection
                    .prepareStatement("SELECT * FROM " + tableName + " WHERE " + idColumnName + " = ?");
            this.statement.setString(1, idValue);
            ResultSet result = this.statement.executeQuery();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Updates the maintenance table; status of the request
     * 
     * @param statusValue String - Status of the request
     * @param idValue String - id of the request
     */
    public void updateMaintenance(String statusValue, String idValue) {
        try {
            this.statement = connnection.prepareStatement("UPDATE maintenance SET status = ? WHERE logId = ?");
            this.statement.setString(1, statusValue);
            this.statement.setString(2, idValue);
            this.statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes the specified row from the specified table
     * @param table String - Name of the table
     * @param columnLabel String - Name of the Column
     * @param id String - value of the column
     */
    public void delete(String table, String columnLabel, String id) {
        String query = "DELETE FROM " + table + " WHERE " + columnLabel + " = " + id;

        try {
            this.statement = connnection.prepareStatement(query);
            this.statement.execute();
            this.statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    /**
     * Update funtion specfic to the password table
     * 
     * @param table String - table name
     * @param newPassword String - new password to be added
     * @param username String - id
     */
    public void updatePassword(String table, String newPassword, String username) {
        String query = "UPDATE " + table + " SET password = ? WHERE username = ?";
        try {
            this.statement = connnection.prepareStatement(query);
            this.statement.setString(1, newPassword);
            this.statement.setString(2, username);
            this.statement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * find function specific for the getting the password of the user
     * @param tableName String - name of table
     * @param username - String - userId
     * @return ResultSet
     */
    public ResultSet passwordCheck(String tableName, String username) {
        String query = "SELECT * FROM " + tableName + " WHERE username = ?";
        try {
            this.statement = this.connnection.prepareStatement(query);
            this.statement.setString(1, username);
            return this.statement.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet update(String tableName, Map<String, Object> record, String idColumnLabel) throws SQLException{

        //generating set part.
        StringBuilder set = new StringBuilder();
        for(String key : record.keySet()){
            if(!key.equals(idColumnLabel)){
                set.append(key).append(" = ?, ");
            }
        }

        ResultSet result = null;
        String query = "UPDATE "+tableName+" SET "+set+" WHERE "+idColumnLabel+" = ID";
        System.out.println(query);
        this.statement = this.connnection.prepareStatement(query);


        return result;
    }

    @Override
    public String toString() {
        return "Database [username=" + username + ", password=" + password + ", database=" + database + ", url=" + url
                + "]";
    }

}
