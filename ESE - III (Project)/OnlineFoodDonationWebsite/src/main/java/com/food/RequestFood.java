package com.food;

public class RequestFood {
    private String ngoName;
    private String category;
    private String food;
    private int quantity;
    private String address;
    private String senderName;
    private String senderContactNo;
    private String status;

    // Constructors
    public RequestFood() {
        // Default constructor
    }

    public RequestFood(String ngoName, String category, String food, int quantity,
                       String address, String senderName, String senderContactNo, String status) {
        this.ngoName = ngoName;
        this.category = category;
        this.food = food;
        this.quantity = quantity;
        this.address = address;
        this.senderName = senderName;
        this.senderContactNo = senderContactNo;
        this.status = status;
    }

    // Getters and Setters
    public String getNgoName() {
        return ngoName;
    }

    public void setNgoName(String ngoName) {
        this.ngoName = ngoName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderContactNo() {
        return senderContactNo;
    }

    public void setSenderContactNo(String senderContactNo) {
        this.senderContactNo = senderContactNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Additional getters and setters if needed

    // toString method for debugging or logging
    @Override
    public String toString() {
        return "RequestFood{" +
                "ngoName='" + ngoName + '\'' +
                ", category='" + category + '\'' +
                ", food='" + food + '\'' +
                ", quantity=" + quantity +
                ", address='" + address + '\'' +
                ", senderName='" + senderName + '\'' +
                ", senderContactNo='" + senderContactNo + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
