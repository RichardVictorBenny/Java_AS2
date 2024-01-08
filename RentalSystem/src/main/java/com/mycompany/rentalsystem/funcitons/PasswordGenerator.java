package com.mycompany.rentalsystem.funcitons;

import java.security.SecureRandom;

/**
 * A class that generates random passwords using the SecureRandom Class.
 * Password have characters and number and special characters.
 * @author Richard
 * @version 1.5
 */
public class PasswordGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
    private static final int PASSWORD_LENGTH = 10;

    private static final SecureRandom RANDOM = new SecureRandom();

    /**
     * Generates a random password using the defined characters.
     * @return String - represents a random password.
     */
    public static String generatePassword() {
        char[] password = new char[PASSWORD_LENGTH];

        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int index = RANDOM.nextInt(CHARACTERS.length());

            password[i] = CHARACTERS.charAt(index);
        }

        return new String(password);
    }
}

