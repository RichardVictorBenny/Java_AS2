/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentalsystem.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 
 * @author Richard
 *
 */
public class Tenant extends Person implements Serializable{
    private String extTenantID;
    private String gender;
    private static Integer tenantID = 5000;
    private LocalDate dateOfBirth;

    /**
     * default constructor
     * 
     * @param tenantID
     * @param firstName 
     * @param surName
     * @param eMail
     * @param dateOfBirth
     * @param phoneNumber
     * 
     */

    public Tenant(){}

    public Tenant(String tenantID, String firstName, String surName, String gender, String eMail, LocalDate dateOfBirth, String phoneNumber) {
        super(firstName, surName, eMail, phoneNumber);
        this.extTenantID = tenantID;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public Tenant(String firstName, String surName,String gender, String eMail, LocalDate dob, String phoneNumber) {
        super(firstName, surName,  eMail, phoneNumber);
        Tenant.tenantID++;
        this.gender= gender;
        this.dateOfBirth = dob;
    }

    public String toString(){
        String string = (this.firstName+this.surName+this.gender+this.eMail+this.getFormatedDob(this.dateOfBirth)+phoneNumber+this.tenantID);
        System.out.println(string);
        return string;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String value){
        this.gender = gender;
    }
    public String getFormatedDob(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return formatter.format(date);
    }

    public String[] getDataArray(){
        String[] dataArray = {String.valueOf(tenantID), this.gender, this.firstName, this.surName, this.eMail, this.phoneNumber, this.getFormatedDob(dateOfBirth)};
        return dataArray;
    }

    

    

    
}

