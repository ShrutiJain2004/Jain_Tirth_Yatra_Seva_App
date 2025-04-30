package com.example.application;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class GeneratedPlanFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_generated_plan, container, false);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView generatedPlanTextView = view.findViewById(R.id.generatedPlanTextView);
        String plan = getArguments() != null ? getArguments().getString("generatedPlan") : "No plan available";
        generatedPlanTextView.setText(plan);

        return view;
    }
}
