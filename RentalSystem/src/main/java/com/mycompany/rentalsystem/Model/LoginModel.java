/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentalsystem.Model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mycompany.rentalsystem.funcitons.*;

/**
 * Does the necessary calculations and validates the user and password.
 * @author Richard
 *         refernce https://www.baeldung.com/sha-256-hashing-java
 *         https://www.tutorialspoint.com/java_cryptography/java_cryptography_message_digest.htm
 */
public class LoginModel {
    private Database database = new Database();

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
        ResultSet result = database.passwordCheck(filename, username);
        try {
            while(result.next()){
                savedPassword = result.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
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

    public void resetPassword(String pin) {
        if (pin.equals("123456798")){
           System.out.println("reset password allowed");
        }
    }
}

