package Person;

public class Person {
    protected String firstName, surName, eMail, streetName,
            city, postCode, dateOfBirth, phoneNumber;

    public Person(String firstName, String surName, String eMail, String streetName, String city, String postCode, String dateOfBirth, String phoneNumber) {
        this.firstName = firstName;
        this.surName = surName;
        this.eMail = eMail;
        this.streetName = streetName;
        this.city = city;
        this.postCode = postCode;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getCity() {
        return city;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
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

    public String getPostCode() {
        return postCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getSurName() {
        return surName;
    }
}
