package com.example.application;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.application.R;

public class SamayikActivity extends AppCompatActivity {

    private WebView videoWebView1, videoWebView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samayik);

        videoWebView1 = findViewById(R.id.videoWebView1);
        videoWebView2 = findViewById(R.id.videoWebView2);
        Button pdfButton = findViewById(R.id.pdfButton);

        // Enable JavaScript
        WebSettings webSettings1 = videoWebView1.getSettings();
        webSettings1.setJavaScriptEnabled(true);
        videoWebView1.setWebViewClient(new WebViewClient());
        videoWebView1.loadData(getYouTubeEmbedHtml("nVSHa2jPvQk"), "text/html", "utf-8");

        WebSettings webSettings2 = videoWebView2.getSettings();
        webSettings2.setJavaScriptEnabled(true);
        videoWebView2.setWebViewClient(new WebViewClient());
        videoWebView2.loadData(getYouTubeEmbedHtml("cz3GoBTfzfA"), "text/html", "utf-8");

        // PDF Button
        pdfButton.setOnClickListener(v -> {
            String pdfUrl = "https://www.vitragvani.com/uploads/pdfs/hindisearch/Samayik-Path_H_searchable_584.pdf";
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(pdfUrl));
            startActivity(browserIntent);
        });
    }

    private String getYouTubeEmbedHtml(String videoId) {
        return "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/" + videoId + "\" frameborder=\"0\" allowfullscreen></iframe>";
    }
}
