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

public class DonationSuccessFragment extends Fragment {

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_donation_success, container, false);

        TextView tvThankYouMessage = view.findViewById(R.id.tvThankYouMessage);
        tvThankYouMessage.setText("Thank you for your generous support! Your support is greatly appreciated.\n\n" +
                "\n We look forward to your continued support in the future!");

        return view;
    }
    public void onDoneClick(View view) {
        requireActivity().getSupportFragmentManager().popBackStack();
    }

}
