package com.mycompany.rentalsystem.funcitons;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.*;


import java.util.ArrayList;
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
    public void insert(String table, String values, ArrayList<Object> record){
        /* String values = columnArray.stream().collect(Collectors.joining(",")); */

        String query = "INSERT INTO "+ table + " ("+values+") VALUES(?,?)";
        try {
            this.statement = connnection.prepareStatement(query);
            this.statement.setObject(1, record.get(0));
            this.statement.setObject(2, record.get(1));
            this.statement.execute();
            this.statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            //add to logger
        } catch (Exception exception){
            exception.printStackTrace();
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

    public ResultSet findTenant(String id){
        try {
            this.statement = connnection.prepareStatement("SELECT * FROM Tenants WHERE tenantId = ?");
            this.statement.setString(1, id);
            ResultSet result = this.statement.executeQuery();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return null;
    }

    public ResultSet findHouse(String id){
        try {
            this.statement = connnection.prepareStatement("SELECT * FROM houses WHERE houseId = ?");
            this.statement.setString(1, id);
            ResultSet result = this.statement.executeQuery();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(String table, String columnLabel, String id ){
        String query = "DELETE FROM "+table+" WHERE "+ columnLabel +" = "+ id;

        try {
            this.statement = connnection.prepareStatement(query);
            this.statement.execute();
            this.statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateHouse(String id, Object house ){

        String query = "UPDATE houses SET houseObject = ? WHERE houseId = ?";
        try {
            byte[] object = FileConvertion.toByteArray(house);
            this.statement = connnection.prepareStatement(query);
            this.statement.setObject(1, object);
            this.statement.setObject(2, id);
            this.statement.execute();
            this.statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTenant(String id, Object tenant ){

        String query = "UPDATE tenants SET tenantObject = ? WHERE tenantId = ?";
        try {
            byte[] object = FileConvertion.toByteArray(tenant); 
            this.statement = connnection.prepareStatement(query);
            this.statement.setObject(1, object);
            this.statement.setObject(2, id);
            this.statement.execute();
            this.statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet passwordCheck(String tableName, String username){
        String query = "SELECT * FROM "+tableName+" WHERE username = ?";
        try {
            this.statement = this.connnection.prepareStatement(query);
            this.statement.setString(1, username);
            return this.statement.executeQuery();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public String toString() {
        return "Database [username=" + username + ", password=" + password + ", database=" + database + ", url=" + url
                + "]";
    }

    
}

