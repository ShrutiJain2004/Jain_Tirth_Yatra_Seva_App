package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class StutisStavansActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stutis_stavans); // make sure this name matches the XML filename

        WebView stutiWebView1 = findViewById(R.id.stutiWebView1);
        WebView stutiWebView2 = findViewById(R.id.stutiWebView2);
        WebView stavanWebView1 = findViewById(R.id.stavanWebView1);
        WebView stavanWebView2 = findViewById(R.id.stavanWebView2);

// Enable JavaScript
        WebSettings settings1 = stutiWebView1.getSettings();
        settings1.setJavaScriptEnabled(true);
        stutiWebView1.loadData("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/eZBbIQac_8Q\" frameborder=\"0\" allowfullscreen></iframe>", "text/html", "utf-8");

        WebSettings settings2 = stutiWebView2.getSettings();
        settings2.setJavaScriptEnabled(true);
        stutiWebView2.loadData("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/o9MGgrPQi3Q\" frameborder=\"0\" allowfullscreen></iframe>", "text/html", "utf-8");

        WebSettings settings3 = stavanWebView1.getSettings();
        settings3.setJavaScriptEnabled(true);
        stavanWebView1.loadData("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/3WPh1-kjFYI\" frameborder=\"0\" allowfullscreen></iframe>", "text/html", "utf-8");

        WebSettings settings4 = stavanWebView2.getSettings();
        settings4.setJavaScriptEnabled(true);
        stavanWebView2.loadData("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/JoUiKbmc_4I\" frameborder=\"0\" allowfullscreen></iframe>", "text/html", "utf-8");


    }
}
