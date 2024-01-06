/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentalsystem.Model;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;

import javax.annotation.processing.Filer;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * 
 * @author Richard
 *
 */
public class Tenant implements Serializable{
    private String sessionId;
    private String extTenantID;
    private String gender, firstName, surName, eMail, phoneNumber;
    private static Integer tenantID = 5000;
    private static Integer totalTenantCount = 0;
    private String houseId;
    private LocalDate dateOfBirth;

    public Tenant() throws IOException{
        //reading session file for getting correct object
        //FileReader in = new FileReader("src/main/java/com/mycompany/rentalsystem/files/SESSION.txt");
        Scanner in = new Scanner(new FileReader("src/main/java/com/mycompany/rentalsystem/files/SESSION.txt"));
        this.sessionId = in.nextLine();
        in.close();
    }


    public Tenant( String firstName, String surName, String eMail, String phoneNumber, String tenantID, String gender,  LocalDate dateOfBirth,  String houseId) {
        this.extTenantID = tenantID;
        this.firstName = firstName;
        this.surName = surName;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.houseId = houseId;
    }

    public Tenant(String firstName, String surName, String eMail, String phoneNumber, String gender,  LocalDate dob, String houseId) {
        Tenant.tenantID++;
        Tenant.totalTenantCount++;
        this.firstName = firstName;
        this.surName = surName;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.extTenantID = String.valueOf(Tenant.tenantID);
        this.gender= gender;
        this.dateOfBirth = dob;
        this.houseId = houseId;
    }

    public String toString(){
        String string = (this.firstName+this.surName+this.gender+this.eMail+this.getFormatedDob(this.dateOfBirth)+phoneNumber+this.extTenantID+this.houseId);
        return string;
    }

    public String getGender(){
        return gender;
    }

    public Date getDateOfBirth(LocalDate localDate){
        // https://java2blog.com/java-localdate-to-date/
        return (Date) Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public void setGender(String value){
        this.gender = value;
    }
    public String getFormatedDob(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return formatter.format(date);
    }
    public LocalDate getDob(){
        return this.dateOfBirth;
    }       

    public String[] getDataArray(){
        String[] dataArray = {String.valueOf(extTenantID), this.gender, this.firstName, this.surName, this.eMail, this.phoneNumber, this.getFormatedDob(dateOfBirth)};
        return dataArray;
    }

    public void setExtTenantId(String id){
        this.extTenantID = id;
    }

    public String getTenantId(){
        return this.extTenantID;
    }

    public static void setTenantId(Integer id){
        Tenant.tenantID = id;
    }
    public static Integer getTotalTenantCount(){
        return totalTenantCount;
    }

    public String getHouseId() {
        return houseId;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }



    public String geteMail() {
        return this.eMail;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getSurName() {
        return this.surName;
    }


    public String getSessionId() {
        return sessionId;
    }


    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    

    

    
}

