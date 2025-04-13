package com.example.application;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class PermissionActivity extends AppCompatActivity {

    private ActivityResultLauncher<String[]> permissionLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize permission launcher
        permissionLauncher = registerForActivityResult(
                new ActivityResultContracts.RequestMultiplePermissions(),
                result -> {
                    boolean cameraGranted = result.getOrDefault(Manifest.permission.CAMERA, false);
                    boolean locationGranted = result.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false);

                    if (cameraGranted && locationGranted) {
                        Toast.makeText(this, "Permissions Granted!", Toast.LENGTH_SHORT).show();
                        goToMainScreen();
                    } else {
                        Toast.makeText(this, "Permissions Denied!", Toast.LENGTH_SHORT).show();
                    }
                });

        checkPermissions(); // Check permissions when activity starts
    }

    private void checkPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            goToMainScreen(); // If permissions are already granted, go to MainActivity
        } else {
            showPermissionDialog(); // Else, show permission request dialog
        }
    }

    private void showPermissionDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Permissions Required")
                .setMessage("This app needs Camera and Location permissions to work properly.")
                .setPositiveButton("Allow", (dialog, which) -> requestPermissions())
                .setNegativeButton("Deny", (dialog, which) -> {
                    Toast.makeText(this, "Permissions Denied!", Toast.LENGTH_SHORT).show();
                })
                .setCancelable(false)
                .show();
    }

    private void requestPermissions() {
        permissionLauncher.launch(new String[]{Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION});
    }

    private void goToMainScreen() {
        Toast.makeText(this, "Opening Main Screen...", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(PermissionActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
