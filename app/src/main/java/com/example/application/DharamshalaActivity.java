package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class DharamshalaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dharamshala);

        String tirthName = getIntent().getStringExtra("tirth_name");

        // Set heading or load dharamshala data here
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView heading = findViewById(R.id.tvHeading);
        heading.setText("Dharamshala at " + tirthName);
    }
}
