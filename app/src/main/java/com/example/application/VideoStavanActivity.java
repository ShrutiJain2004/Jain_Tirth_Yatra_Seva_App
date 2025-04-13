package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;

public class VideoStavanActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_stavan);

        WebView videoWebView1 = findViewById(R.id.videoWebView1);
        WebView videoWebView2 = findViewById(R.id.videoWebView2);
        WebView videoWebView3 = findViewById(R.id.videoWebView3);

        String frameVideo1 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/r5yLu0EP-2E\" frameborder=\"0\" allowfullscreen></iframe>";
        String frameVideo2 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/cx6Nrpm5-w4\" frameborder=\"0\" allowfullscreen></iframe>";
        String frameVideo3 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/tiNlFkr-1Q8\" frameborder=\"0\" allowfullscreen></iframe>";

        videoWebView1.getSettings().setJavaScriptEnabled(true);
        videoWebView2.getSettings().setJavaScriptEnabled(true);
        videoWebView3.getSettings().setJavaScriptEnabled(true);

        videoWebView1.loadData(frameVideo1, "text/html", "utf-8");
        videoWebView2.loadData(frameVideo2, "text/html", "utf-8");
        videoWebView3.loadData(frameVideo3, "text/html", "utf-8");


    }
}