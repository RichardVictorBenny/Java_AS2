package com.mycompany.rentalsystem.funcitons;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Map;

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
      * @param tableName String - table name
      * @param record Map<String, Object> - the values 
      * @param idColumnLabel STring - column name of the primary
      * @param id String - valuse of the primarykey 
      * @throws SQLException
      */
    public void update(String tableName, Map<String, Object> record, String idColumnLabel, String id) throws SQLException{
        //generating set part.
        StringBuilder set = new StringBuilder();
        for(String key : record.keySet()){
            if(!key.equals(idColumnLabel)){
                set.append(key).append(" = ?, ");
            }
        }
        //removing the comma at the very end
        set.delete(set.length() - 2, set.length());
        String query = "UPDATE "+tableName+" SET "+set+" WHERE "+idColumnLabel+" = ?";
        this.statement = this.connnection.prepareStatement(query);
        int index = 1;
        for (String key: record.keySet()){
            if(!key.equals(idColumnLabel)){
                this.statement.setObject(index++, record.get(key));
            }
        }
        this.statement.setObject(index, id);
        this.statement.execute();

    }

    @Override
    public String toString() {
        return "Database [username=" + username + ", password=" + password + ", database=" + database + ", url=" + url
                + "]";
    }

}
