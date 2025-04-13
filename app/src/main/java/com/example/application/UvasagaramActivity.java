package com.example.application;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class UvasagaramActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    Button playButton, pauseButton;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uvasagaram);

        // WebView for YouTube video
        WebView webView = findViewById(R.id.uvasagaram_video);
        webView.getSettings().setJavaScriptEnabled(true);
        String videoEmbed = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/heodEq4lqVg\" frameborder=\"0\" allowfullscreen></iframe>";
        webView.loadData(videoEmbed, "text/html", "utf-8");

    }
}
