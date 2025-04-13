package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

public class AartiActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aarti);

        WebView videoWebView1 = findViewById(R.id.videoWebView1);
        WebView videoWebView2 = findViewById(R.id.videoWebView2);
        TextView pdfLink1 = findViewById(R.id.pdfLink1);
        TextView pdfLink2 = findViewById(R.id.pdfLink2);

// Enable JavaScript for video playback
        videoWebView1.getSettings().setJavaScriptEnabled(true);
        videoWebView2.getSettings().setJavaScriptEnabled(true);

// Load YouTube embed videos
        String frameVideo1 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/LvkRKbjz-fA\" frameborder=\"0\" allowfullscreen></iframe>";
        String frameVideo2 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Q69DEEvSG_w\" frameborder=\"0\" allowfullscreen></iframe>";

        videoWebView1.loadData(frameVideo1, "text/html", "utf-8");
        videoWebView2.loadData(frameVideo2, "text/html", "utf-8");

// Set PDF links (replace with your actual PDF URLs)
        pdfLink1.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://jainsquare.wordpress.com/2011/09/25/mangal-divo/"));
            startActivity(browserIntent);
        });

        pdfLink2.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://jainworld.jainworld.com/JWMarathi/library/jaintirthavandana/mahavir%20%20%26%20%20padyavti%20%20arti.pdf"));
            startActivity(browserIntent);
        });

    }
}