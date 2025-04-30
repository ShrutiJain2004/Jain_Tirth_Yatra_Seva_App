package com.example.application;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class VehicleRentalFragment extends Fragment {

    private EditText editTextFirstName, editTextLastName, editTextPhone, editTextStartDate,
            editTextLocation, editTextComments;
    private Spinner spinnerDays, spinnerVehicle;
    private Button buttonSubmit;
    private DatabaseReference rentalSubmissionsRef;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vehicle_rental, container, false);

        // Initialize Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        rentalSubmissionsRef = database.getReference("rental_vehicle_submissions");

        editTextFirstName = view.findViewById(R.id.editTextFirstName);
        editTextLastName = view.findViewById(R.id.editTextLastName);
        editTextPhone = view.findViewById(R.id.editTextPhone);
        editTextStartDate = view.findViewById(R.id.editTextStartDate);
        editTextLocation = view.findViewById(R.id.editTextLocation);
        editTextComments = view.findViewById(R.id.editTextComments);
        spinnerDays = view.findViewById(R.id.spinnerDays);
        spinnerVehicle = view.findViewById(R.id.spinnerVehicle);
        buttonSubmit = view.findViewById(R.id.buttonSubmit);

        setupSpinners();

        editTextStartDate.setOnClickListener(v -> showDatePicker());

        buttonSubmit.setOnClickListener(v -> submitForm());

        return view;
    }

    private void setupSpinners() {
        // Number of persons (label first)
        String[] days = {"No. of Persons", "1", "2", "3", "4", "5", "6", "7+"};
        ArrayAdapter<String> daysAdapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_spinner_item, days);
        daysAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDays.setAdapter(daysAdapter);

        // Vehicle types (label first)
        String[] vehicles = {"Vehicle", "Swift Desire", "Ertiga", "Innova", "Tempo Traveller", "Bus"};
        ArrayAdapter<String> vehicleAdapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_spinner_item, vehicles);
        vehicleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerVehicle.setAdapter(vehicleAdapter);

        // Set initial selection to the placeholder
        spinnerDays.setSelection(0);
        spinnerVehicle.setSelection(0);
    }


    private void showDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                (view, year1, month1, dayOfMonth) -> {
                    String date = dayOfMonth + "/" + (month1 + 1) + "/" + year1;
                    editTextStartDate.setText(date);
                }, year, month, day);
        datePickerDialog.show();
    }

    private void submitForm() {
        String firstName = editTextFirstName.getText().toString().trim();
        String lastName = editTextLastName.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();
        String startDate = editTextStartDate.getText().toString().trim();
        String days = spinnerDays.getSelectedItem().toString();
        String vehicle = spinnerVehicle.getSelectedItem().toString();
        String location = editTextLocation.getText().toString().trim();
        String comments = editTextComments.getText().toString().trim();

        // Perform validation
        if (firstName.isEmpty() || lastName.isEmpty() || phone.isEmpty() || startDate.isEmpty() ||
                days.equals("No. of Persons") || vehicle.equals("Vehicle") || location.isEmpty()) {
            Toast.makeText(getContext(), "Please fill in all required fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create RentalRequestData object
        RentalRequestData rentalRequestData = new RentalRequestData(firstName, lastName, phone, startDate, days, vehicle, location, comments);

        // Push data to Firebase Realtime Database
        rentalSubmissionsRef.push().setValue(rentalRequestData)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(getContext(), "Rental request submitted successfully!", Toast.LENGTH_SHORT).show();
                    clearForm();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(getContext(), "Failed to submit rental request: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
        showThankYouFragment();
    }

    private void showThankYouFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.fragment_container, new DonationSuccessFragment()); // Replace with your fragment container ID
            transaction.addToBackStack(null); // Optional: Add to back stack for navigation
            transaction.commit();
        }
    }

    private void clearForm() {
        editTextFirstName.setText("");
        editTextLastName.setText("");
        editTextPhone.setText("");
        editTextStartDate.setText("");
        editTextLocation.setText("");
        editTextComments.setText("");
        spinnerDays.setSelection(0);
        spinnerVehicle.setSelection(0);
    }

    // Data class to hold Rental Request information
    public static class RentalRequestData {
        public String firstName;
        public String lastName;
        public String phone;
        public String startDate;
        public String days;
        public String vehicle;
        public String location;
        public String comments;

        public RentalRequestData() {
            // Default constructor required for Firebase
        }

        public RentalRequestData(String firstName, String lastName, String phone, String startDate, String days, String vehicle, String location, String comments) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phone = phone;
            this.startDate = startDate;
            this.days = days;
            this.vehicle = vehicle;
            this.location = location;
            this.comments = comments;
        }
    }
}
