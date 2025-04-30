package com.example.application;

// Data class
public class JatraPlanData {
    public String firstName, lastName, email, phoneNumber, residenceArea, residenceCity;
    public String startDate, startTime, startPlace, numberOfDays, vehicleType, tirthCover, comments, generatedPlan;

    public JatraPlanData() {
    }

    public JatraPlanData(String firstName, String lastName, String email, String phoneNumber,
                         String residenceArea, String residenceCity, String startDate, String startTime,
                         String startPlace, String numberOfDays, String vehicleType, String tirthCover,
                         String comments, String generatedPlan) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.residenceArea = residenceArea;
        this.residenceCity = residenceCity;
        this.startDate = startDate;
        this.startTime = startTime;
        this.startPlace = startPlace;
        this.numberOfDays = numberOfDays;
        this.vehicleType = vehicleType;
        this.tirthCover = tirthCover;
        this.comments = comments;
        this.generatedPlan = generatedPlan;
    }
}