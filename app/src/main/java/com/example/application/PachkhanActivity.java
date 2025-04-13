package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class PachkhanActivity extends AppCompatActivity {

    WebView  videoWebView1, videoWebView2,videoWebView3,videoWebView4,videoWebView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pachkhan);

        videoWebView1 = findViewById(R.id.videoWebView1);
        videoWebView2 = findViewById(R.id.videoWebView2);
        videoWebView3 = findViewById(R.id.videoWebView3);
        videoWebView4 = findViewById(R.id.videoWebView4);
        videoWebView5 = findViewById(R.id.videoWebView5);

        // Load YouTube videos
        loadYouTubeVideo(videoWebView1, "7xcyNkR1t64");
        loadYouTubeVideo(videoWebView2, "P5sPVZDKMkQ");
        loadYouTubeVideo(videoWebView3, "LMIsAlovkco");
        loadYouTubeVideo(videoWebView4, "gA5qocBjQB8");
        loadYouTubeVideo(videoWebView5, "zooJU5gN810");

        // PDF (upload your PDF to Google Drive or server, then use link below)
        Button pdfButton = findViewById(R.id.pdfButton);

        pdfButton.setOnClickListener(v -> {
            String url = "https://www.jainfoundation.in/JAINLIBRARY/books/Pachchakkhans_269173_std.pdf";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        });
    }
    private void loadYouTubeVideo(WebView webView, String videoId) {
        String html = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/"
                + videoId + "\" frameborder=\"0\" allowfullscreen></iframe>";
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadData(html, "text/html", "utf-8");
    }

}
