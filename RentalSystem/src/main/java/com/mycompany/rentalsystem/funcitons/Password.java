package com.mycompany.rentalsystem.funcitons;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Richard
 */
public class Password {
    private static Database database = new Database();

    /**
     * Saves new passowrd into the database.
     * 
     * @param username String - username
     * @param password String - password
     * @param userMode String - user type
     * @throws SQLException
     * @throws NoSuchAlgorithmException
     */
    public static void savePassword(String username, String password, String userMode)
            throws SQLException, NoSuchAlgorithmException {
        String filename = switch (userMode) {
            case "Tenant" -> "tenantpasswords";
            case "Landlord" -> "landlordpasswords";
            default -> "";
        };

        ArrayList<Object> record = new ArrayList<>();
        record.add(username);

        record.add(Hashing.doHashing(password, username));
        database.insert(filename, "username, password", record);
    }
}
