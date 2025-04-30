package com.example.application;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditProfileActivity extends AppCompatActivity {

    EditText editName, editEmail, editContact;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        editName = findViewById(R.id.edit_name);
        editEmail = findViewById(R.id.edit_email);
        editContact = findViewById(R.id.edit_contact);
        btnSave = findViewById(R.id.btn_save);

        // Load existing values from SharedPreferences
        SharedPreferences prefs = getSharedPreferences("UserProfile", MODE_PRIVATE);
        editName.setText(prefs.getString("name", ""));
        editEmail.setText(prefs.getString("email", ""));
        editContact.setText(prefs.getString("contact", ""));

        // Save button
        btnSave.setOnClickListener(v -> {
            String name = editName.getText().toString().trim();
            String email = editEmail.getText().toString().trim();
            String contact = editContact.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty() || contact.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // Save to SharedPreferences
            SharedPreferences.Editor editor = getSharedPreferences("UserProfile", MODE_PRIVATE).edit();
            editor.putString("name", name);
            editor.putString("email", email);
            editor.putString("contact", contact);
            editor.apply();

            Toast.makeText(this, "Profile updated successfully", Toast.LENGTH_SHORT).show();
            finish(); // Go back to ProfileFragment
        });
    }
}