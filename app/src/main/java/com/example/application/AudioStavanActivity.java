package com.example.application;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class AudioStavanActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer1, mediaPlayer2, mediaPlayer3;
    Button playStavan1, pauseStavan1, playStavan2, pauseStavan2, playStavan3, pauseStavan3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_stavan);

        // Initialize buttons
        playStavan1 = findViewById(R.id.playStavan1);
        pauseStavan1 = findViewById(R.id.pauseStavan1);
        playStavan2 = findViewById(R.id.playStavan2);
        pauseStavan2 = findViewById(R.id.pauseStavan2);
        playStavan3 = findViewById(R.id.playStavan3);
        pauseStavan3 = findViewById(R.id.pauseStavan3);

        // Replace these URLs with actual audio URLs
        String url1 = "https://example.com/stavan1.mp3";
        String url2 = "https://example.com/stavan2.mp3";
        String url3 = "https://example.com/stavan3.mp3";

        mediaPlayer1 = new MediaPlayer();
        mediaPlayer2 = new MediaPlayer();
        mediaPlayer3 = new MediaPlayer();

        setupPlayer(mediaPlayer1, url1, playStavan1, pauseStavan1);
        setupPlayer(mediaPlayer2, url2, playStavan2, pauseStavan2);
        setupPlayer(mediaPlayer3, url3, playStavan3, pauseStavan3);
    }

    private void setupPlayer(MediaPlayer mediaPlayer, String url, Button playBtn, Button pauseBtn) {
        playBtn.setOnClickListener(v -> {
            try {
                mediaPlayer.reset();
                mediaPlayer.setDataSource(url);
                mediaPlayer.prepareAsync();
                mediaPlayer.setOnPreparedListener(MediaPlayer::start);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        pauseBtn.setOnClickListener(v -> {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer1 != null) mediaPlayer1.release();
        if (mediaPlayer2 != null) mediaPlayer2.release();
        if (mediaPlayer3 != null) mediaPlayer3.release();
    }
}
