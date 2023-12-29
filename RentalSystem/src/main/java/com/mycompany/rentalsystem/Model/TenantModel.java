/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentalsystem.Model;



/**
 * 
 * @author Richard
 *
 */
public class TenantModel {

    public int findIndex(String buttonPressed) {
        int index;
        switch (buttonPressed) {
            case "Dashboard":
                index = 0;
                break;
            case "Payments":
                index = 1;
                break;
            case "Maintenance":
                index = 2;
                break;
            case "Contracts":
                index = 3;
                break;
            case "Others":
                index = 4;
                break;
            default:
                index = 0;
                break;
        }
        return index;
    }

    
}

