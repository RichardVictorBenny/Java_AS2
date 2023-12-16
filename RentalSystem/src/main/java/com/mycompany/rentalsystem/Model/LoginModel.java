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
import java.util.ArrayList;

import com.mycompany.rentalsystem.funcitons.*;

/**
 *
 * @author Richard
 *         refernce https://www.baeldung.com/sha-256-hashing-java
 *         https://www.tutorialspoint.com/java_cryptography/java_cryptography_message_digest.htm
 */
public class LoginModel {
    // should have login verification.
    // variables to hold values.

    // hash the given password and validate the user.

    //

    public boolean validate(String username, String password, String userMode) {
        String hashPassword, fileUsername, filename;
        String filePassword = "";
        ArrayList<String> credentials = new ArrayList<>();

        // determining the user type.
        switch (userMode) {
            case "Tenant":
                filename = "src/main/java/com/mycompany/rentalsystem/files/TenatLogin.bin";
                break;

            case "Landlord":
                filename = "src/main/java/com/mycompany/rentalsystem/files/LandlordLogin.bin";
                break;

            case "Admin":
                filename = "src/main/java/com/mycompany/rentalsystem/files/AdminLogin.bin";
                break;
            default:
                filename = "";
                break;
        }

        // hashing the password provided by the user for validation
        try {
            hashPassword = Hashing.doHashing(password, username);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            hashPassword = "";
        }

        // retieving all the data inside the relevant file
        try {
            FileInputStream fileIn;
            fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            while (true) {
                try {
                    credentials.add(in.readUTF());
                } catch (EOFException eof) {
                    break;
                }
            }
            in.close();

            for (int i = 0; i < credentials.size(); i++) {
                String element = credentials.get(i);
                String[] divide = element.split("-");
                fileUsername = divide[0];
                if (username.equals(fileUsername)) {
                    filePassword = divide[1];
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        //doing validation
        try {
            if (hashPassword.equals(filePassword)) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public void resetPassword(String pin) {
        if (pin.equals("123456798")){
           System.out.println("reset password allowed");
        }
    }
}

