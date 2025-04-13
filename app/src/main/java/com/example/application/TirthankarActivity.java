package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class TirthankarActivity extends AppCompatActivity {

    WebView youtubeWebView;
    Button btnTirthankars, btnTirthankarStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tirthankar);

        youtubeWebView = findViewById(R.id.youtubeWebView);
        btnTirthankars = findViewById(R.id.btnTirthankars);
        btnTirthankarStory = findViewById(R.id.btnTirthankarStory);

        // Load YouTube video using WebView
        String videoId = "TSdrYD3OjSU";
        String html = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/" + videoId + "\" frameborder=\"0\" allowfullscreen></iframe>";
        youtubeWebView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = youtubeWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        youtubeWebView.setWebChromeClient(new WebChromeClient());
        youtubeWebView.loadData(html, "text/html", "utf-8");

        // Buttons click actions
        btnTirthankars.setOnClickListener(v -> {
            Intent intent = new Intent(TirthankarActivity.this, TirthankarListActivity.class);
            startActivity(intent);
        });

        btnTirthankarStory.setOnClickListener(v -> {
            Intent intent = new Intent(TirthankarActivity.this, TirthankarStoryActivity.class);
            startActivity(intent);
        });
    }
}
