package com.mycompany.rentalsystem;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.mycompany.rentalsystem.funcitons.Database;
import com.mycompany.rentalsystem.funcitons.Hashing;
import com.mycompany.rentalsystem.Model.*;

public class LandlordPasswordReset {
    private static Database database = new Database();

    public static void main(String[] args) {
        System.out.println("Reset password Landlord");
        System.out.println("""
                1 => Login and change password
                2 => User Secret key to change password
                """);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select from option: 1 | 2");
        String userSelect = scanner.next();

        switch (userSelect) {
            case "1":
                System.out.println("Enter username: ");
                String username = scanner.next();
                System.out.println("Enter password: ");
                String password = scanner.next();
                String hashedPassword = null;
                Map<String, Object> record = new HashMap<>();
                
                if(!new LoginModel().validate(username, password, "Landlord")){
                    System.out.println("login failed");
                } else {
                    System.out.println("Enter new password");
                    String newPassowrd = scanner.next();
                    try {
                        hashedPassword = Hashing.doHashing(newPassowrd, username);
                        record.put("password", hashedPassword);
                        database.update("landlordpasswords",
                                record, "username",
                                username);
                        System.out.println("update successful");
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }

                break;
            case "2":
                System.out.println("contact admin");
                break;

            default:
                break;
        }
    }
}
