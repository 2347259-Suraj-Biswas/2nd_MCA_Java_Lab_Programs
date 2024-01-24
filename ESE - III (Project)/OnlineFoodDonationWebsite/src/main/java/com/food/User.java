package com.food;
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String mobileNo;
    private String gender;
    private int roleId;
    private String roleName;
    private String uniqueId;
    private String ngoName;

    // Constructors
    public User() {
        // Default constructor
    }

    public User(String firstName, String lastName, String email, String password,
                String mobileNo, String gender, int roleId, String roleName, String uniqueId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.mobileNo = mobileNo;
        this.gender = gender;
        this.roleId = roleId;
        this.roleName = roleName;
        this.uniqueId = uniqueId;
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    // Getter and Setter for NGO name
    public String getNgoName() {
        return ngoName;
    }

    public void setNgoName(String ngoName) {
        this.ngoName = ngoName;
    }

    // toString method for debugging or logging
    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", gender='" + gender + '\'' +
                ", roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", uniqueId='" + uniqueId + '\'' +
                ", ngoName='" + ngoName + '\'' +
                '}';
    }
}
