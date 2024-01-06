package com.mycompany.rentalsystem.funcitons;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Password {
    private static Database database = new Database();
    public static void savePassword(String username, String password, String userMode){
        String filename = switch (userMode) {
            case "Tenant" -> "tenantpasswords";
            case "Landlord" -> "landlordpasswords";
            default -> "";
        };

        ArrayList<Object> record = new ArrayList<>();
        record.add(username);
        try {
            record.add(Hashing.doHashing(password, username));
            database.insert("tenantpasswords", "username, password", record );
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
