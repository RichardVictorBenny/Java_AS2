/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentalsystem.Model;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mycompany.rentalsystem.funcitons.*;

/**
 * Does the necessary calculations and validates the user and password.
 * 
 * refernce https://www.baeldung.com/sha-256-hashing-java
 *         https://www.tutorialspoint.com/java_cryptography/java_cryptography_message_digest.htm
 * 
 * @author Richard
 *         
 */
public class LoginModel {
    private Database database = new Database();

    /**
     * Performs validation of the user.
     * 
     * @param username String - username
     * @param password String - password provided by the user
     * @param userMode String - type of user
     * @return
     */
    public boolean validate(String username, String password, String userMode) {
        String hashPassword, filename;
        String savedPassword = "";

        // determining the file needed for validations as per the user type.
        filename = switch (userMode) {
            case "Tenant" -> "tenantpasswords";
            case "Landlord" -> "landlordpasswords";
            default -> "";
        };

        // hashing the password provided by the user for validation
        try {
            hashPassword = Hashing.doHashing(password, username);
        } catch (NoSuchAlgorithmException e) {
            hashPassword = "";
        }
        try (
        ResultSet result = database.find(filename, "username", username)) {
            try {
                if(result.next()){
                    savedPassword = result.getString("password");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e1) {

            e1.printStackTrace();
        }
        try {
            if (hashPassword.equals(savedPassword)) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * @deprecated
     * @param pin
     */
    public void resetPassword(String pin) {
        if (pin.equals("123456798")){
           System.out.println("reset password allowed");
        }
    }
}

