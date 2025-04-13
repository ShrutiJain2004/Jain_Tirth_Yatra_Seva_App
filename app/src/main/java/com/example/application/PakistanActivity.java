package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;

public class PakistanActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CityAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pakistan);

        // 1️⃣ Find RecyclerView from XML
        recyclerView = findViewById(R.id.recyclerViewCities);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 2️⃣ Create list of cities
        List<String> cityList = Arrays.asList("Karachi", "Lahore","Multan","Rawalpindi", "Sindh");

        // 3️⃣ Initialize Adapter and set it to RecyclerView
        adapter = new CityAdapter(this, cityList, cityName -> {
            Toast.makeText(this, "Clicked: " + cityName, Toast.LENGTH_SHORT).show();

            // Open new activity and pass city name
            Intent intent = new Intent(this, CityTempleActivity.class);
            intent.putExtra("selectedCity", cityName);
            startActivity(intent);
        });

        recyclerView.setAdapter(adapter);
    }
}
