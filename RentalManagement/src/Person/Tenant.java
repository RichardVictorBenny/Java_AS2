package Person;

public class Tenant extends Person{
    private String tenantID, tenantPassword;
    public Tenant(String firstName, String surName, String eMail, String streetName, String city,
                  String postCode, String dateOfBirth, String phoneNumber, String tenantID, String tenantPassword) {
        super(firstName, surName, eMail, streetName, city, postCode, dateOfBirth, phoneNumber);
        this.tenantID = tenantID;
        this.tenantPassword = tenantPassword;
    }
}
