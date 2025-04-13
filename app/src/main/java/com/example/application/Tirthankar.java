package com.example.application;

public class Tirthankar {
    private int imageResId;
    private String name;
    private String lanchan;

    public Tirthankar(int imageResId, String name, String lanchan) {
        this.imageResId = imageResId;
        this.name = name;
        this.lanchan = lanchan;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }

    public String getLanchan() {
        return lanchan;
    }
}
