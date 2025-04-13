package com.example.application;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class PavapuriActivity extends AppCompatActivity {

    WebView pavapuriVideo;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pavapuri);

        pavapuriVideo = findViewById(R.id.pavapuri_video);

        WebSettings webSettings = pavapuriVideo.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Load YouTube video
        String videoEmbed = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/qlR1XZ-ubXw\" frameborder=\"0\" allowfullscreen></iframe>";
        pavapuriVideo.loadData(videoEmbed, "text/html", "utf-8");
    }
}
