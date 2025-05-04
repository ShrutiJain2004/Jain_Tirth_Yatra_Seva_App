package com.example.application;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class GeneratedPlanFragment extends Fragment {

    private TextView generatedPlanTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_generated_plan, container, false);
        generatedPlanTextView = view.findViewById(R.id.generatedPlanTextView);
        return view;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            String generatedPlanText = getArguments().getString("generatedPlan");
            if (generatedPlanText != null) {
                generatedPlanTextView.setText(generatedPlanText);
            } else {
                generatedPlanTextView.setText("No plan data received.");
            }
        } else {
            generatedPlanTextView.setText("No arguments passed to display plan.");
        }
    }
}