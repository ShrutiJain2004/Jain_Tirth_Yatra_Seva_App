package com.example.application;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class NavkarMantraActivity extends AppCompatActivity {

    private Button playAudioButton, openYoutubeButton;
    private MediaPlayer mediaPlayer;
    private WebView youtubeWebView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navkar_mantra);

        // Inside onCreate():
        youtubeWebView = findViewById(R.id.youtubeView);
        String videoId = "SAKm4X68X7I";
        String html = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/" + videoId + "\" frameborder=\"0\" allowfullscreen></iframe>";
        youtubeWebView.getSettings().setJavaScriptEnabled(true);
        youtubeWebView.setWebChromeClient(new WebChromeClient());
        youtubeWebView.loadData(html, "text/html", "utf-8");

        openYoutubeButton = findViewById(R.id.openYoutubeButton);
        openYoutubeButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/" + videoId)); // ✅ updated
            intent.setPackage("com.google.android.youtube");
            try {
                startActivity(intent);
            } catch (android.content.ActivityNotFoundException e) {
                intent.setPackage(null);
                startActivity(intent);
            }
        });


        playAudioButton = findViewById(R.id.playAudio);
        // Audio setup
        mediaPlayer = MediaPlayer.create(this, R.raw.navkar_audio);
        playAudioButton.setOnClickListener(view -> {
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                } else {
                    mediaPlayer.start();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
