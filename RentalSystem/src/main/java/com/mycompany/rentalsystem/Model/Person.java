package com.mycompany.rentalsystem.Model;


public class Person {
    protected String firstName, surName, eMail;
    protected String phoneNumber;

    public Person(){}

    public Person(String firstName, String surName, String eMail, String phoneNumber) {
        this.firstName = firstName;
        this.surName = surName;
        this.eMail = eMail;
    
        this.phoneNumber = phoneNumber;
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
        return eMail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSurName() {
        return surName;
    }



   
}
