package com.example.application;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ChaityavandanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chaityavandan);

        TextView heading = findViewById(R.id.headingText);
        heading.setText("Chaityavandan");

        // Load YouTube video in WebView
        WebView videoView = findViewById(R.id.youtubeWebView);
        WebSettings webSettings = videoView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        videoView.loadData(
                "<iframe width=\"100%\" height=\"200\" src=\"https://www.youtube.com/embed/Gj4zcDf3O3c\" frameborder=\"0\" allowfullscreen></iframe>",
                "text/html",
                "utf-8"
        );

        TextView description = findViewById(R.id.descriptionText);
        description.setText("Chaityavandan is a deeply spiritual Jain ritual of reverence towards Tirthankars, temples (Chaityalay), and sacred scriptures. It involves chanting specific prayers and performing meditative acts of devotion, helping one connect with divinity and cultivate inner peace.");

        Button pdfButton = findViewById(R.id.pdfButton);
        pdfButton.setOnClickListener(v -> {
            // Hindi PDF link of Chaityavandan
            String pdfUrl = "https://www.jainfoundation.in/JAINLIBRARY/books/Chaityavandan_Samayik_010693_std.pdf";
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(pdfUrl));
            startActivity(browserIntent);
        });

    }
}
