package com.food;
public class Ngo {
    private String ownerFirstName;
    private String ownerLastName;
    private String email; // Corresponds to email in the User class
    private String password;
    private String gender;
    private String mobileNo;
    private String uniqueId;
    private String ngoName;

    // Constructors
    public Ngo() {
        // Default constructor
    }

    public Ngo(String ownerFirstName, String ownerLastName, String email, String password,
               String gender, String mobileNo, String uniqueId, String ngoName) {
        this.ownerFirstName = ownerFirstName;
        this.ownerLastName = ownerLastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.mobileNo = mobileNo;
        this.uniqueId = uniqueId;
        this.ngoName = ngoName;
    }

    // Getters and Setters
    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getNgoName() {
        return ngoName;
    }

    public void setNgoName(String ngoName) {
        this.ngoName = ngoName;
    }

    // Additional getters and setters for other fields

    // toString method for debugging or logging
    @Override
    public String toString() {
        return "Ngo{" +
                "ownerFirstName='" + ownerFirstName + '\'' +
                ", ownerLastName='" + ownerLastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", uniqueId='" + uniqueId + '\'' +
                ", ngoName='" + ngoName + '\'' +
                '}';
    }
}
