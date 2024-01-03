/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentalsystem.Model;


/**
 *
 * @author Richard
 */ 
public class Landlord extends Person{
    private static int landlordID;
    private String extlandlordID;
    
    public Landlord(){}
    public Landlord(String landlordID, String firstName, String surName, String eMail, String phoneNumber){
        super(firstName, surName, eMail, phoneNumber);
        this.extlandlordID = landlordID;
    }
    public Landlord( String firstName, String surName, String eMail, String phoneNumber){
        super(firstName, surName,  eMail, phoneNumber);
        this.landlordID+=1;
    }


    
}
