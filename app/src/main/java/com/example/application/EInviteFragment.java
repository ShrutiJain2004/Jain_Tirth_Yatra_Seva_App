package com.example.application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class EInviteFragment extends Fragment {

    Spinner spinnerOccasion;
    EditText etHeading, etBody;
    TextView tvECardPreview;
    Button btnGenerateCard;

    String[] occasions = {"Select Occasion", "Paryushan", "Mahavir Jayanti", "Samvatsari", "Jain Milan", "Other"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_einvite, container, false);

        spinnerOccasion = view.findViewById(R.id.spinnerOccasion);
        etHeading = view.findViewById(R.id.etHeading);
        etBody = view.findViewById(R.id.etBody);
        tvECardPreview = view.findViewById(R.id.tvECardPreview);
        btnGenerateCard = view.findViewById(R.id.btnGenerateCard);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, occasions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOccasion.setAdapter(adapter);

        btnGenerateCard.setOnClickListener(v -> {
            String occasion = spinnerOccasion.getSelectedItem().toString();
            String heading = etHeading.getText().toString().trim();
            String body = etBody.getText().toString().trim();

            if (occasion.equals("Select Occasion") || heading.isEmpty() || body.isEmpty()) {
                tvECardPreview.setText("Please complete all fields.");
            } else {
                // Simulated AI-based output
                String eCard = "🎉 *" + heading + "* 🎉\n\n" +
                        body + "\n\n" +
                        "_Occasion: " + occasion + "_";
                tvECardPreview.setText(eCard);
            }
        });

        return view;
    }
}

