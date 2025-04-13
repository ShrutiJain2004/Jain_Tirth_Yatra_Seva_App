package com.example.application;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LanguageSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check if language is already selected
        SharedPreferences prefs = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        String selectedLanguage = prefs.getString("language", "");

        if (!selectedLanguage.isEmpty()) {
            // Language already selected, move to permission screen
            goToPermissionActivity();
            return;  // Exit this activity
        }

        // Show language selection dialog
        showLanguageDialog();
    }

    private void showLanguageDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Language");

        // List of languages
        String[] languages = {"English", "Hindi", "Gujarati"};
        builder.setItems(languages, (dialog, which) -> {
            String selectedLanguage = languages[which];

            // Save selected language in SharedPreferences
            SharedPreferences.Editor editor = getSharedPreferences("AppPrefs", MODE_PRIVATE).edit();
            editor.putString("language", selectedLanguage);
            editor.apply();

            // Show toast message
            Toast.makeText(this, "Selected Language: " + selectedLanguage, Toast.LENGTH_SHORT).show();

            // Move to PermissionActivity
            goToPermissionActivity();
        });

        // Prevent closing the dialog by clicking outside
        builder.setCancelable(false);
        builder.show();
    }

    private void goToPermissionActivity() {
        Intent intent = new Intent(this, PermissionActivity.class);
        startActivity(intent);
        finish();
    }
}
