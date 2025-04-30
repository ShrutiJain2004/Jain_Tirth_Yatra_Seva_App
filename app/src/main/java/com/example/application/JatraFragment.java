package com.example.application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


/*
AIzaSyBM5Q3SlVYKbUtyPm1EtaRD_etSRgh9lnY
*/
public class JatraFragment extends Fragment {

    private CardView jatraPlanCard, vehicleRentalCard;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jatra, container, false);

        jatraPlanCard = view.findViewById(R.id.jatraPlanCard);
        vehicleRentalCard = view.findViewById(R.id.vehicleRentalCard);

        jatraPlanCard.setOnClickListener(v -> openJatraPlanFragment());
        vehicleRentalCard.setOnClickListener(v -> openVehicleRentalFragment());

        return view;
    }

    private void openJatraPlanFragment() {
        // Replace with your Jatra Plan Fragment
        Fragment jatraPlanFragment = new JatraPlanFragment();
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, jatraPlanFragment); // Replace fragment_container with your container ID
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void openVehicleRentalFragment() {
        // Replace with your Vehicle Rental Fragment
        Fragment vehicleRentalFragment = new VehicleRentalFragment();
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, vehicleRentalFragment); // Replace fragment_container with your container ID
        transaction.addToBackStack(null);
        transaction.commit();
    }
}