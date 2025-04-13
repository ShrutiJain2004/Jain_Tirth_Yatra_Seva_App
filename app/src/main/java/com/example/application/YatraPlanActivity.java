package com.example.application;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class YatraPlanActivity extends AppCompatActivity {

    EditText inputPlaces, inputDays, inputPreferences;
    Button btnGeneratePlan;
    TextView tripPlanOutput;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yatra_plan);

        inputPlaces = findViewById(R.id.inputPlaces);
        inputDays = findViewById(R.id.inputDays);
        inputPreferences = findViewById(R.id.inputPreferences);
        btnGeneratePlan = findViewById(R.id.btnGeneratePlan);
        tripPlanOutput = findViewById(R.id.tripPlanOutput);

        btnGeneratePlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateTripPlan();
            }
        });
    }

    private void generateTripPlan() {
        String places = inputPlaces.getText().toString();
        String days = inputDays.getText().toString();
        String preferences = inputPreferences.getText().toString();

        // For now, we generate a dummy plan. Later you can connect AI or backend.
        String output = "🗺️ Your Trip Plan\n\n" +
                "📍 Places: " + places + "\n" +
                "🕒 Duration: " + days + " days\n" +
                "🎯 Preferences: " + preferences + "\n\n" +
                "Suggested Plan:\n" +
                "- Day 1: Arrival & Darshan\n" +
                "- Day 2: Local Sightseeing\n" +
                "- Day 3: Bhaktambar Path & Evening Satsang\n" +
                "- Day 4: Return\n";

        tripPlanOutput.setText(output);
    }
}
