/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.rentalsystem;

import com.mycompany.rentalsystem.View.LoginView;

/**
 *
 * @author Richard
 */
public class RentalSystem {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        java.awt.EventQueue.invokeLater(() -> {
            new LoginView().setVisible(true);
        });
    }
}
