package com.example.application;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class DonationFormFragment extends Fragment {

    private static final String TAG = "DonationFormFragment";
    EditText etName, etEmail, etPhone, etAmount;
    Button btnSubmit;
    RadioGroup rgDonationType, rgPaymentMethod;
    private DatabaseReference mDatabase;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_donation_form, container, false);

        // Initialize Firebase
        mDatabase = FirebaseDatabase.getInstance().getReference().child("donations");

        // Initialize views
        etName = view.findViewById(R.id.etName);
        etEmail = view.findViewById(R.id.etEmail);
        etPhone = view.findViewById(R.id.etPhone);
        etAmount = view.findViewById(R.id.etAmount);
        btnSubmit = view.findViewById(R.id.btnSubmitDonation);
        rgDonationType = view.findViewById(R.id.rgDonationType);
        rgPaymentMethod = view.findViewById(R.id.rgPaymentMethod);

        btnSubmit.setOnClickListener(v -> {
            Log.d(TAG, "Submit button clicked");

            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();
            String amountStr = etAmount.getText().toString().trim();

            int selectedDonationTypeId = rgDonationType.getCheckedRadioButtonId();
            int selectedPaymentMethodId = rgPaymentMethod.getCheckedRadioButtonId();

            Log.d(TAG, "Form inputs — Name: " + name + ", Email: " + email + ", Phone: " + phone + ", Amount: " + amountStr);
            Log.d(TAG, "Selected IDs — DonationType: " + selectedDonationTypeId + ", PaymentMethod: " + selectedPaymentMethodId);

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || amountStr.isEmpty()
                    || selectedDonationTypeId == -1 || selectedPaymentMethodId == -1) {
                Toast.makeText(getContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            double amount;
            try {
                amount = Double.parseDouble(amountStr);
            } catch (NumberFormatException e) {
                Toast.makeText(getContext(), "Invalid amount format", Toast.LENGTH_SHORT).show();
                etAmount.setError("Invalid amount");
                etAmount.requestFocus();
                return;
            }

            // ✅ Use getView() instead of stale 'view'
            RadioButton selectedDonationType = getView().findViewById(selectedDonationTypeId);
            RadioButton selectedPaymentMethod = getView().findViewById(selectedPaymentMethodId);

            if (selectedDonationType == null || selectedPaymentMethod == null) {
                Toast.makeText(getContext(), "Please select options again", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "Selected radio buttons not found");
                return;
            }

            String donationType = selectedDonationType.getText().toString();
            String paymentMethod = selectedPaymentMethod.getText().toString();

            Log.d(TAG, "Donation Type: " + donationType + ", Payment Method: " + paymentMethod);

            // Firebase branch under donation type
            DatabaseReference branchRef = mDatabase.child(donationType);

            branchRef.get().addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    DatabaseReference donationRef = branchRef.push();
                    String donationId = donationRef.getKey();

                    if (donationId != null) {
                        Map<String, Object> donationData = new HashMap<>();
                        donationData.put("name", name);
                        donationData.put("email", email);
                        donationData.put("phone", phone);
                        donationData.put("amount", amount);
                        donationData.put("donationType", donationType);
                        donationData.put("paymentMethod", paymentMethod);

                        donationRef.setValue(donationData)
                                .addOnSuccessListener(aVoid -> {
                                    Log.d(TAG, "Donation data saved under " + donationType);
                                    Toast.makeText(getContext(), "Donation successful!", Toast.LENGTH_SHORT).show();

                                    // Launch payment app
                                    switch (paymentMethod) {
                                        case "Google Pay":
                                            openUPI("com.google.android.apps.nbu.paisa.user", amountStr, name);
                                            break;
                                        case "PhonePe":
                                            openUPI("com.phonepe.app", amountStr, name);
                                            break;
                                        case "Paytm":
                                            openUPI("net.one97.paytm", amountStr, name);
                                            break;
                                        case "Credit/Debit Card":
                                            Toast.makeText(getContext(), "Card payment coming soon!", Toast.LENGTH_SHORT).show();
                                            break;
                                    }

                                    showThankYouFragment();
                                    clearForm();
                                })
                                .addOnFailureListener(e -> {
                                    Log.e(TAG, "Error saving donation data: ", e);
                                    Toast.makeText(getContext(), "Failed to process donation", Toast.LENGTH_SHORT).show();
                                });
                    }
                } else {
                    Log.e(TAG, "Error checking/creating branch: ", task.getException());
                    Toast.makeText(getContext(), "Error while checking donation branch", Toast.LENGTH_SHORT).show();
                }
            });
        });

        return view;
    }

    private void showThankYouFragment() {
        DonationSuccessFragment donationSuccessFragment = new DonationSuccessFragment();
        FragmentTransaction transaction = requireFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, donationSuccessFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void openUPI(String packageName, String amount, String name) {
        String upiId = "yourupiid@bank"; // Replace with your actual UPI ID
        Uri uri = Uri.parse("upi://pay?pa=" + upiId + "&pn=" + name + "&am=" + amount + "&cu=INR");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage(packageName);

        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getContext(), "Payment app not found", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearForm() {
        etName.setText("");
        etEmail.setText("");
        etPhone.setText("");
        etAmount.setText("");
        rgDonationType.clearCheck();
        rgPaymentMethod.clearCheck();
    }
}
