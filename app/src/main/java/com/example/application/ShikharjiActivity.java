package com.example.application;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class ShikharjiActivity extends AppCompatActivity {

    WebView shikharjiVideo;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shikharji);

        shikharjiVideo = findViewById(R.id.shikharji_video);

        // Enable JavaScript for video playback
        WebSettings webSettings = shikharjiVideo.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Load YouTube video
        String videoEmbed = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/3t34FYVGtiw\" frameborder=\"0\" allowfullscreen></iframe>";
        shikharjiVideo.loadData(videoEmbed, "text/html", "utf-8");
    }
}
