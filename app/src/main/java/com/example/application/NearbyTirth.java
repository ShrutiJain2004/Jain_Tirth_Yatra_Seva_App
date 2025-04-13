package com.example.application;

public class NearbyTirth {
    private String name;
    private int imageResId;

    public NearbyTirth(String name, int imageResId) {
        this.name = name;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }
}
