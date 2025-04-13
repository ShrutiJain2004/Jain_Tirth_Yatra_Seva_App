package com.example.application;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class GirnarjiActivity extends AppCompatActivity {

    WebView girnarjiVideo;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girnarji);

        girnarjiVideo = findViewById(R.id.girnarji_video);

        WebSettings webSettings = girnarjiVideo.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Load YouTube video
        String videoEmbed = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/ni0mnFkwuBE\" frameborder=\"0\" allowfullscreen></iframe>";
        girnarjiVideo.loadData(videoEmbed, "text/html", "utf-8");
    }
}
