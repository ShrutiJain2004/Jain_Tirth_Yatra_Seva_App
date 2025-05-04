package com.example.application;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class JatraPlanFragment extends Fragment {

    private EditText firstNameEditText, lastNameEditText, emailEditText, phoneNumberEditText,
            editTextComments, residenceAreaEditText, residenceCityEditText, startPlaceEditText, tirthCoverEditText;
    private Button startDateButton, startTimeButton, submitButton;
    private Spinner numberOfDaysSpinner, vehicleTypeSpinner;
    private int startYear, startMonth, startDay, startHour, startMinute;
    private DatabaseReference jatraPlanSubmissionsRef;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jatra_plan, container, false);

        // Initialize Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        jatraPlanSubmissionsRef = database.getReference("jatra_planner_submissions");

        // Initialize views
        firstNameEditText = view.findViewById(R.id.firstNameEditText);
        lastNameEditText = view.findViewById(R.id.lastNameEditText);
        emailEditText = view.findViewById(R.id.emailEditText);
        phoneNumberEditText = view.findViewById(R.id.phoneNumberEditText);
        residenceAreaEditText = view.findViewById(R.id.residenceAreaEditText);
        residenceCityEditText = view.findViewById(R.id.residenceCityEditText);
        startPlaceEditText = view.findViewById(R.id.startPlaceEditText);
        tirthCoverEditText = view.findViewById(R.id.tirthCoverEditText);
        editTextComments = view.findViewById(R.id.editTextComments);
        startDateButton = view.findViewById(R.id.startDateButton);
        startTimeButton = view.findViewById(R.id.startTimeButton);
        numberOfDaysSpinner = view.findViewById(R.id.numberOfDaysSpinner);
        vehicleTypeSpinner = view.findViewById(R.id.vehicleTypeSpinner);
        submitButton = view.findViewById(R.id.submitButton);

        // Set Listeners
        setupDateTimePickers();
        populateSpinners();
        submitButton.setOnClickListener(v -> handleSubmit());

        return view;
    }

    private void setupDateTimePickers() {
        Calendar calendar = Calendar.getInstance();
        startYear = calendar.get(Calendar.YEAR);
        startMonth = calendar.get(Calendar.MONTH);
        startDay = calendar.get(Calendar.DAY_OF_MONTH);
        startHour = calendar.get(Calendar.HOUR_OF_DAY);
        startMinute = calendar.get(Calendar.MINUTE);

        startDateButton.setOnClickListener(v -> showDatePicker());
        startTimeButton.setOnClickListener(v -> showTimePicker());
    }

    private void showDatePicker() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                (view, year, month, dayOfMonth) -> {
                    startYear = year;
                    startMonth = month;
                    startDay = dayOfMonth;
                    startDateButton.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                }, startYear, startMonth, startDay);
        datePickerDialog.show();
    }

    private void showTimePicker() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                (view, hourOfDay, minute) -> {
                    startHour = hourOfDay;
                    startMinute = minute;
                    startTimeButton.setText(hourOfDay + ":" + minute);
                }, startHour, startMinute, false);
        timePickerDialog.show();
    }

    private void populateSpinners() {
        ArrayAdapter<CharSequence> personsAdapter = ArrayAdapter.createFromResource(
                getContext(), R.array.number_of_persons_array, android.R.layout.simple_spinner_item);
        personsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        numberOfDaysSpinner.setAdapter(personsAdapter);

        ArrayAdapter<CharSequence> vehicleAdapter = ArrayAdapter.createFromResource(
                getContext(), R.array.vehicle_type_array, android.R.layout.simple_spinner_item);
        vehicleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vehicleTypeSpinner.setAdapter(vehicleAdapter);

        numberOfDaysSpinner.setSelection(0);
        vehicleTypeSpinner.setSelection(0);
    }

    private void handleSubmit() {
        String firstName = firstNameEditText.getText().toString().trim();
        String lastName = lastNameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String phoneNumber = phoneNumberEditText.getText().toString().trim();
        String residenceArea = residenceAreaEditText.getText().toString().trim();
        String residenceCity = residenceCityEditText.getText().toString().trim();
        String startDate = startDateButton.getText().toString();
        String startTime = startTimeButton.getText().toString();
        String startPlace = startPlaceEditText.getText().toString().trim();
        String numberOfDays = numberOfDaysSpinner.getSelectedItem().toString();
        String vehicleType = vehicleTypeSpinner.getSelectedItem().toString();
        String tirthCover = tirthCoverEditText.getText().toString().trim();
        String comments = editTextComments.getText().toString().trim();

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() ||
                residenceArea.isEmpty() || residenceCity.isEmpty() || startPlace.isEmpty() || tirthCover.isEmpty()) {
            Toast.makeText(getContext(), "Please fill in all required fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(getContext(), "Please enter a valid email address", Toast.LENGTH_SHORT).show();
            return;
        }

        if (phoneNumber.length() < 10) {
            Toast.makeText(getContext(), "Please enter a valid phone number", Toast.LENGTH_SHORT).show();
            return;
        }

        // Sample generated plan data with heading
        String samplePlanWithHeading = "Yatra Route:\n" +
                "Day 1: Arrive at " + startPlace + ". Local sightseeing.\n" +
                "Day 2: Visit " + tirthCover + ". Evening prayers.\n" +
                "Day 3: Travel to the next destination.\n" +
                "...\n" +
                "Day " + numberOfDays + ": Departure from the final destination.";

        JatraPlanData jatraPlanData = new JatraPlanData(
                firstName, lastName, email, phoneNumber, residenceArea, residenceCity,
                startDate, startTime, startPlace, numberOfDays, vehicleType, tirthCover,
                comments, samplePlanWithHeading
        );

        jatraPlanSubmissionsRef.push().setValue(jatraPlanData)
                .addOnSuccessListener(aVoid -> {
                    requireActivity().runOnUiThread(() -> {
                        Toast.makeText(getContext(), "Plan submitted!", Toast.LENGTH_SHORT).show();
                        clearForm();

                        GeneratedPlanFragment fragment = new GeneratedPlanFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString("generatedPlan", samplePlanWithHeading);
                        fragment.setArguments(bundle);

                        requireActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, fragment)
                                .addToBackStack(null)
                                .commit();
                    });
                })
                .addOnFailureListener(e -> requireActivity().runOnUiThread(() ->
                        Toast.makeText(getContext(), "Firebase error: " + e.getMessage(), Toast.LENGTH_SHORT).show()));
    }

    private void clearForm() {
        firstNameEditText.setText("");
        lastNameEditText.setText("");
        emailEditText.setText("");
        phoneNumberEditText.setText("");
        residenceAreaEditText.setText("");
        residenceCityEditText.setText("");
        startDateButton.setText("Start Date");
        startTimeButton.setText("Start Time");
        startPlaceEditText.setText("");
        tirthCoverEditText.setText("");
        numberOfDaysSpinner.setSelection(0);
        vehicleTypeSpinner.setSelection(0);
        editTextComments.setText("");
    }
}