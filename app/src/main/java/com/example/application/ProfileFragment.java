package com.example.application;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    TextView tvName, tvEmail, tvPhone;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        tvName = view.findViewById(R.id.tv_name);
        tvEmail = view.findViewById(R.id.tv_email);
        tvPhone = view.findViewById(R.id.tv_phone);

        Button editProfileButton = view.findViewById(R.id.btn_edit_profile);
        Button logoutButton = view.findViewById(R.id.btn_logout);

        // Edit Profile Button
        editProfileButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), EditProfileActivity.class);
            startActivity(intent);
        });

        // Logout Button
        logoutButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });

        return view;
    }

    // Load user data when the fragment becomes visible
    @Override
    public void onResume() {
        super.onResume();

        SharedPreferences prefs = requireActivity().getSharedPreferences("UserProfile", Context.MODE_PRIVATE);
        String name = prefs.getString("user_name", "User Name");
        String email = prefs.getString("user_email", "Email: user@example.com");
        String contact = prefs.getString("user_contact", "Phone: +91 9876543210");

        tvName.setText(name);
        tvEmail.setText("Email: " + email);
        tvPhone.setText("Phone: " + contact);
    }
}
