package com.example.application;

public class LearningTopic {
    private String title;
    private int imageResId;

    public LearningTopic(String title, int imageResId) {
        this.title = title;
        this.imageResId = imageResId;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResId() {
        return imageResId;
    }
}

