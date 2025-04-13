package com.example.application;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class VehicleRentalActivity extends AppCompatActivity {

    TextView headerText;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_rental);

        headerText = findViewById(R.id.headerText);
        headerText.setText("Vehicle Rental");

        // You can later replace this with AI-based form or rental listings
        Toast.makeText(this, "Vehicle rental service coming soon...", Toast.LENGTH_SHORT).show();
    }
}
