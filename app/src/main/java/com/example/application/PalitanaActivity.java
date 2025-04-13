package com.example.application;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class PalitanaActivity extends AppCompatActivity {

    WebView palitanaVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palitana);

        palitanaVideo = findViewById(R.id.palitana_video);
        palitanaVideo.getSettings().setJavaScriptEnabled(true);
        palitanaVideo.loadData(
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/tJvKMa_sYDs\" frameborder=\"0\" allowfullscreen></iframe>",
                "text/html", "utf-8");
    }
}
