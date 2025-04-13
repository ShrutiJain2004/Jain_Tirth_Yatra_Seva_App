package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;

public class IndiaActivity extends AppCompatActivity implements StateAdapter.OnStateClickListener {

    private RecyclerView stateRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_india);

        stateRecyclerView = findViewById(R.id.stateRecyclerView);

        List<String> states = Arrays.asList(
                "Bihar", "Chhattisgarh", "Delhi", "Gujarat", "Haryana",
                "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh",
                "Maharashtra", "Punjab", "Rajasthan", "Tamil Nadu",
                "Uttar Pradesh", "West Bengal"
        );

        stateRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        StateAdapter adapter = new StateAdapter(states, this);
        stateRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onStateClick(String state) {
        Intent intent = new Intent(IndiaActivity.this, StateTempleListActivity.class);
        intent.putExtra("selectedState", state);
        startActivity(intent);
    }
}
