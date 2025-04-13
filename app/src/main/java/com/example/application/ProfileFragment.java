package com.example.application;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.ViewGroup;
import android.os.Bundle;

public class ProfileFragment extends Fragment {

    @SuppressLint("SetTextI18n")
    @Nullable
       public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        TextView tvName = view.findViewById(R.id.tv_user_name);
        TextView tvEmail = view.findViewById(R.id.tv_user_email);
        TextView tvPhone = view.findViewById(R.id.tv_user_phone);
        Button editProfileButton = view.findViewById(R.id.btn_edit_profile);
        Button logoutButton = view.findViewById(R.id.btn_logout);

        // Get user data from SharedPreferences
        SharedPreferences prefs = getActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        String name = prefs.getString("user_name", "User Name");
        String email = prefs.getString("user_email", "user@example.com");
        String phone = prefs.getString("user_phone", "+91 9876543210");

        // Set user info in text views
        tvName.setText(name);
        tvEmail.setText("Email: " + email);
        tvPhone.setText("Phone: " + phone);

        // Edit Profile button (you can use this to allow edits later)
        editProfileButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), EditProfileActivity.class);
            startActivity(intent);
        });

        // Logout button
        logoutButton.setOnClickListener(v -> {
            // Optional: Clear user data
            prefs.edit().clear().apply();

            Intent intent = new Intent(getActivity(), LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });

        return view;
    }
}
