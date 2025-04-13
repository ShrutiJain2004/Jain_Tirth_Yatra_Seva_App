package com.example.application;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Navkar1 extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    Button playButton, pauseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navkar1);

        // YouTube video setup
        WebView webView = findViewById(R.id.navkar_video);
        webView.getSettings().setJavaScriptEnabled(true);
        String videoEmbed = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/57GbE10a_Is\" frameborder=\"0\" allowfullscreen></iframe>";
        webView.loadData(videoEmbed, "text/html", "utf-8");

        // Audio setup
        playButton = findViewById(R.id.btn_play);
        pauseButton = findViewById(R.id.btn_pause);
        mediaPlayer = MediaPlayer.create(this, R.raw.navkar_audio);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                }
            }
        });
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
