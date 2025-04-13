package com.example.application;

public class Temple {
    private String name;
    private String city;
    private int imageResId;
    private String mapUrl;
    private String address;
    private String history;
    private String contact;

    public Temple(String name, String city, int imageResId, String mapUrl, String address, String history, String contact) {
        this.name = name;
        this.city = city;
        this.imageResId = imageResId;
        this.mapUrl = mapUrl;
        this.address = address;
        this.history = history;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public String getAddress() {
        return address;
    }

    public String getHistory() {
        return history;
    }
    public String getContact() {
        return contact;
    }
}
