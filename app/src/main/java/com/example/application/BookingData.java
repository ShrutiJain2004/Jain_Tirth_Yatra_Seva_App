package com.example.application;

public class BookingData {
    public String userId;
    public String dharamshalaName;
    public String checkInDate;
    public String checkOutDate;
    public int numberOfGuests;
    public String guestName;
    public String phoneNumber;
    public String emailAddress;
    public String roomType;
    public String specialRequests;
    public String paymentMethod; // Added paymentMethod
    // You can add more fields here as needed, e.g., transactionId, bookingStatus

    public BookingData() {
        // Default constructor required for Firebase
    }

    public BookingData(String userId, String dharamshalaName, String checkInDate, String checkOutDate, int numberOfGuests, String guestName, String phoneNumber, String emailAddress, String roomType, String specialRequests, String paymentMethod) {
        this.userId = userId;
        this.dharamshalaName = dharamshalaName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfGuests = numberOfGuests;
        this.guestName = guestName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.roomType = roomType;
        this.specialRequests = specialRequests;
        this.paymentMethod = paymentMethod;
    }

    // Getter methods
    public String getUserId() {
        return userId;
    }

    public String getDharamshalaName() {
        return dharamshalaName;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getSpecialRequests() {
        return specialRequests;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    // Setter methods
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setDharamshalaName(String dharamshalaName) {
        this.dharamshalaName = dharamshalaName;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setSpecialRequests(String specialRequests) {
        this.specialRequests = specialRequests;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}