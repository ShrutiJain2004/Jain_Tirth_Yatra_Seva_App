package com.example.application;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class PratikramanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pratikraman);

        // Video 1
        WebView videoWebView1 = findViewById(R.id.videoWebView1);
        loadYoutubeVideo(videoWebView1, "8Alqk5QX7rY");

        // Video 2
        WebView videoWebView2 = findViewById(R.id.videoWebView2);
        loadYoutubeVideo(videoWebView2, "XlRkBGh5DMA");

        // PDF Button
        Button pdfButton = findViewById(R.id.pdfButton);
        pdfButton.setOnClickListener(v -> {
            String pdfUrl = "https://www.jainlibrary.org/wp-content/uploads/2021/08/Pratikraman_in_Hindi.pdf";
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(pdfUrl));
            startActivity(browserIntent);
        });
    }

    private void loadYoutubeVideo(WebView webView, String videoId) {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String html = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/" + videoId + "\" frameborder=\"0\" allowfullscreen></iframe>";
        webView.loadData(html, "text/html", "utf-8");
    }
}
