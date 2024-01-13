/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentalsystem.Model;

import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;


import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * implements the serializable interface
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
    private LocalDate rentPayDate;

    /**
     * Contructor that gets the sessionId from the file.
     * To be used only when the controller is initiated.
     * @throws IOException
     */
    public Tenant() throws IOException{
        //reading session file for getting correct object
        Scanner in = new Scanner(new FileReader("src/main/java/com/mycompany/rentalsystem/files/SESSION.txt"));
        this.sessionId = in.nextLine();
        in.close();
    }

    /**
     * Constructor used to create a instance of the object taken from the database.
     * 
     * @param firstName 
     * @param surName
     * @param eMail
     * @param phoneNumber
     * @param tenantID
     * @param gender
     * @param dateOfBirth
     * @param houseId
     */
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

    /**
     * Constructor that creates a new Tenant from the details provided. 
     * Id is assigned automatically
     * 
     * @param firstName
     * @param surName
     * @param eMail
     * @param phoneNumber
     * @param gender
     * @param dob
     * @param houseId
     */
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
        this.rentPayDate = LocalDate.now().plusDays(7);
    }


    @Override
    public String toString(){
        String string = (this.firstName+this.surName+this.gender+this.eMail+this.getFormatedDob(this.dateOfBirth)+phoneNumber+this.extTenantID+this.houseId);
        return string;
    }


    /*
     * Getters and setters
     */
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
    
    /**
     * converts Localdate to String
     * @param date LocalDate - provided by user
     * @return String - date in the format DD-MM-YYYY
     */
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


    public LocalDate getRentPayDate() {
        return rentPayDate;
    }

    public void setRentPayDate(LocalDate rentPayDate) {
        this.rentPayDate = rentPayDate;
    }

    public String getSessionId() {
        return sessionId;
    }


    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

}

