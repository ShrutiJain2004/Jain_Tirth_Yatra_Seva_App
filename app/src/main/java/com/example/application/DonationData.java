package com.example.application;

public class DonationData {
    public String name;
    public String email;
    public String phone;
    public String amount;
    public String donationType;
    public String paymentMethod;

    public DonationData() {
        // Default constructor required for Firebase
    }

    public DonationData(String name, String email, String phone, String amount, String donationType, String paymentMethod) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.amount = amount;
        this.donationType = donationType;
        this.paymentMethod = paymentMethod;
    }
}
