package com.example.application;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LanguageSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = getSharedPreferences("UserPreferences", MODE_PRIVATE);
        String selectedLanguage = prefs.getString("language", "");

        if (!selectedLanguage.isEmpty()) {
            goToPermissionActivity();
            return;
        }
        showLanguageDialog();
    }


    private void showLanguageDialog() {
        SharedPreferences prefs = getSharedPreferences("UserPreferences", MODE_PRIVATE);
        boolean isLanguageSelected = prefs.getBoolean("isLanguageSelected", false);

        if (isLanguageSelected) {
            SharedPreferences userPrefs = getSharedPreferences("UserProfile", MODE_PRIVATE);
            boolean isUserInfoSaved = userPrefs.getBoolean("isUserInfoSaved", false);

            if (isUserInfoSaved) {
                goToPermissionActivity();
            } else {
                showUserInfoDialog();
            }
            return;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Language");

        String[] languages = {"English", "Hindi", "Gujarati"};
        builder.setItems(languages, (dialog, which) -> {
            String selectedLanguage = languages[which];

            SharedPreferences.Editor editor = getSharedPreferences("UserPreferences", MODE_PRIVATE).edit();
            editor.putString("language", selectedLanguage);
            editor.putBoolean("isLanguageSelected", true); // Save selection flag
            editor.apply();

            Toast.makeText(this, "Selected Language: " + selectedLanguage, Toast.LENGTH_SHORT).show();
            showUserInfoDialog();
        });

        builder.setCancelable(false);
        builder.show();
    }

    private void showUserInfoDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.user_info_dialog, null);
        builder.setView(dialogView);
        builder.setCancelable(false);

        EditText nameInput = dialogView.findViewById(R.id.edit_name);
        EditText contactInput = dialogView.findViewById(R.id.edit_contact);
        EditText emailInput = dialogView.findViewById(R.id.edit_email);

        builder.setPositiveButton("Submit", (dialog, which) -> {
            String name = nameInput.getText().toString().trim();
            String contact = contactInput.getText().toString().trim();
            String email = emailInput.getText().toString().trim();

            if (!name.isEmpty() && !contact.isEmpty() && !email.isEmpty()) {
                SharedPreferences.Editor editor = getSharedPreferences("UserProfile", MODE_PRIVATE).edit();
                editor.putBoolean("isUserInfoSaved", true);
                editor.putString("user_name", name);
                editor.putString("user_contact", contact);
                editor.putString("user_email", email);
                editor.apply();

                Toast.makeText(this, "User info saved.", Toast.LENGTH_SHORT).show();
                goToPermissionActivity();
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                showUserInfoDialog();  // reopen the dialog
            }
        });
        builder.show();
    }

    private void goToPermissionActivity() {
        Intent intent = new Intent(this, PermissionActivity.class);
        startActivity(intent);
        finish();
    }
}