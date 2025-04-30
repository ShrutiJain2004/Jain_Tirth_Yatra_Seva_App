package com.example.application;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.application.R;

import java.util.Locale;

public class SettingsFragment extends Fragment {

    private Switch switchNotifications;
    private Switch switchDarkMode;
    private SharedPreferences sharedPreferences;
    private TextView tvLanguageSelected;
    private Button btnChangeLanguage;
    private RatingBar ratingBar;
    private EditText feedbackEditText;
    private Button submitFeedback;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        // Initialize views
        switchDarkMode = view.findViewById(R.id.switch_dark_mode);
        switchNotifications = view.findViewById(R.id.switch_notifications);
        tvLanguageSelected = view.findViewById(R.id.tv_language_selected);
        btnChangeLanguage = view.findViewById(R.id.btn_change_language);
        ratingBar = view.findViewById(R.id.ratingBar);
        feedbackEditText = view.findViewById(R.id.feedbackEditText);
        submitFeedback = view.findViewById(R.id.submitFeedback);
        TextView tvPrivacy = view.findViewById(R.id.tv_privacy);
        TextView tvTerms = view.findViewById(R.id.tv_terms);

        tvPrivacy.setOnClickListener(v -> {
            FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new PrivacyFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        });

        tvTerms.setOnClickListener(v -> {
            FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new TermsFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        });

        submitFeedback.setOnClickListener(v -> {
            float rating = ratingBar.getRating();
            String feedback = feedbackEditText.getText().toString().trim();

            if (rating == 0) {
                Toast.makeText(getContext(), "Please provide a rating", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!feedback.isEmpty()) {
                // Show confirmation dialog
                new AlertDialog.Builder(getContext())
                        .setTitle("Thank You!")
                        .setMessage("Your feedback has been submitted successfully.")
                        .setPositiveButton("OK", null)
                        .show();

                // Clear fields
                feedbackEditText.setText("");
                ratingBar.setRating(0);
            } else {
                Toast.makeText(getContext(), "Please enter feedback", Toast.LENGTH_SHORT).show();
            }
        });

        sharedPreferences = requireActivity().getSharedPreferences("UserPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        boolean isDarkMode = sharedPreferences.getBoolean("isDarkMode", false);
        switchDarkMode.setChecked(isDarkMode);
        switchDarkMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            editor.putBoolean("isDarkMode", isChecked).apply();
            setDarkMode(isChecked);
        });

        boolean isNotificationEnabled = sharedPreferences.getBoolean("notifications_enabled", false);
        switchNotifications.setChecked(isNotificationEnabled);
        switchNotifications.setOnCheckedChangeListener((buttonView, isChecked) -> {
            editor.putBoolean("notifications_enabled", isChecked).apply();
            if (isChecked) {
                showTestNotification();
            } else {
                Toast.makeText(getContext(), "Notifications turned off", Toast.LENGTH_SHORT).show();
            }
        });

        String selectedLanguage = sharedPreferences.getString("language", "English");
        tvLanguageSelected.setText("Language: " + selectedLanguage);
        btnChangeLanguage.setOnClickListener(v -> showLanguageDialog());

        return view;
    }

    private void setDarkMode(boolean isDarkMode) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isDarkMode", isDarkMode);
        editor.apply();

        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    private void showTestNotification() {
        Context context = requireContext();
        String channelId = "default_channel_id";

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    "Default Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle("Notifications Enabled")
                .setContentText("You will now receive updates.")
                .setAutoCancel(true);

        notificationManager.notify(1, builder.build());
    }

    @SuppressLint("SetTextI18n")
    private void showLanguageDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Select Language");

        String[] languages = {"English", "Hindi", "Gujarati"};
        builder.setItems(languages, (dialog, which) -> {
            String selectedLanguage = languages[which];
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("language", selectedLanguage);
            editor.apply();
            tvLanguageSelected.setText("Language: " + selectedLanguage);
            Toast.makeText(getContext(), "Selected Language: " + selectedLanguage, Toast.LENGTH_SHORT).show();
        });

        builder.setCancelable(true);
        builder.show();
    }
}
