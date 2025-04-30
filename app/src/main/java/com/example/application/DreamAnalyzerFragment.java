package com.example.application;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

public class DreamAnalyzerFragment extends Fragment {

    EditText etDreamInput;
    Button btnAnalyze;
    TextView tvAnalysisResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dream_analyzer, container, false);

        etDreamInput = view.findViewById(R.id.etDreamInput);
        btnAnalyze = view.findViewById(R.id.btnAnalyze);
        tvAnalysisResult = view.findViewById(R.id.tvAnalysisResult);

        btnAnalyze.setOnClickListener(v -> {
            String dreamText = etDreamInput.getText().toString().trim();

            if (TextUtils.isEmpty(dreamText)) {
                Toast.makeText(getContext(), "Please enter your dream", Toast.LENGTH_SHORT).show();
                return;
            }

            // For now, simulate AI response
            String fakeAIResponse = analyzeDreamWithAI(dreamText);
            tvAnalysisResult.setText(fakeAIResponse);
        });

        return view;
    }

    // Simulated AI logic
    private String analyzeDreamWithAI(String input) {
        return "Your dream suggests that you may be experiencing hidden desires, emotions, or fears. " +
                "It could also symbolize your inner thoughts trying to surface. Trust your intuition!";
    }
}
