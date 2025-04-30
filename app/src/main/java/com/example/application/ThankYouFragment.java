package com.example.application;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ThankYouFragment extends Fragment {

    private TextView tvBookingDetails;
    private Button btnGoToBookingActivity;

    public ThankYouFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_thank_you, container, false);

        tvBookingDetails = view.findViewById(R.id.tvBookingDetails);
        btnGoToBookingActivity = view.findViewById(R.id.btnGoHome); // Using the same ID from the layout

        // Get booking details from arguments
        if (getArguments() != null) {
            String bookingInfo = getArguments().getString("booking_info");
            tvBookingDetails.setText(bookingInfo);
        }

        btnGoToBookingActivity.setOnClickListener(v -> {
            // Navigate back to the BookingActivity
            if (getActivity() != null) {
                getActivity().onBackPressed();
            }
        });

        return view;
    }
}