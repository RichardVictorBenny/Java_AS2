package com.mycompany.rentalsystem.funcitons;

import java.sql.*;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.Collection;


public class Database {
    

    private String username = "root";
    private String password = "richard";
    private String database = "objects";
    private String url = "jdbc:mysql://localhost:3390/" + database;
    Connection connnection;
    PreparedStatement statement;
    
    
    /**
     * Database
     */
    public Database(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("connection failed");
            //add to logger
        }
        try {
            this.connnection = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param table - String table name
     * @param values - String table heading with comma seperation
     * @param record - Arraylist<?> id as String and object as Book
     */
    public void insert(String table, HashMap<String, Object> record){
        Collection<String> keyValues = record.keySet();
        String values = keyValues.stream().collect(Collectors.joining(","));

        String query = "INSERT INTO "+ table + " ("+values+") VALUES(?,?)";
        try {
            this.statement = connnection.prepareStatement(query);
            this.statement.setObject(1, record.get("houseId"));
            this.statement.setObject(2, record.get("houseObject"));
            this.statement.execute();
            this.statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            //add to logger
        }
    }

    public ResultSet findAll(String table){
        try {
            this.statement = connnection.prepareStatement("SELECT * FROM "+table);
            ResultSet result = this.statement.executeQuery();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }

    public void delete(String table, String id ){
        try {
            this.statement = connnection.prepareStatement("DELETE FROM "+table+" WHERE houseId = (?)");
            this.statement.setString(1, id);
            this.statement.execute();
            this.statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(String table, HashMap<String, Object> record){
        Collection<String> keyValues = record.keySet();
        String value = keyValues.stream().collect(Collectors.joining(","));

        String query = "UPDATE "+ table+" SET houseObject = (?) WHERE houseId = (?)";
        try {
            System.out.println(String.valueOf(record.get("houseId")));
            this.statement = connnection.prepareStatement(query);
            this.statement.setObject(1, record.get("houseObject"));
            this.statement.setObject(2, record.get("houseId"));
            this.statement.execute();
            this.statement.close();
            System.out.println("updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Database [username=" + username + ", password=" + password + ", database=" + database + ", url=" + url
                + "]";
    }
}

