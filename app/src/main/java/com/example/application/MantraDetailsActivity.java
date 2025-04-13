package com.example.application;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MantraDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mantra_details);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView title = findViewById(R.id.mantra_title);
        String mantraName = getIntent().getStringExtra("MANTRA_NAME");
        title.setText(mantraName);
    }
}
