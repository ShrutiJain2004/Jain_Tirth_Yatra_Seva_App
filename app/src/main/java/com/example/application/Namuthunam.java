package com.example.application;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Namuthunam extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    Button playButton, pauseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_namuthunam);

        WebView webView = findViewById(R.id.namuthunam_video);
        webView.getSettings().setJavaScriptEnabled(true);
        String videoEmbed = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/hrKy7egCYZ8\" frameborder=\"0\" allowfullscreen></iframe>";
        webView.loadData(videoEmbed, "text/html", "utf-8");

    }
}
