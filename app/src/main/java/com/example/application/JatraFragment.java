package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class JatraFragment extends Fragment {

    LinearLayout yatraPlanLayout, vehicleRentalLayout;

    public JatraFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jatra, container, false);

        yatraPlanLayout = view.findViewById(R.id.yatraPlanLayout);
        vehicleRentalLayout = view.findViewById(R.id.vehicleRentalLayout);

        yatraPlanLayout.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), YatraPlanActivity.class);
            startActivity(intent);
        });

        vehicleRentalLayout.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), VehicleRentalActivity.class);
            startActivity(intent);
        });

        return view;
    }
}
