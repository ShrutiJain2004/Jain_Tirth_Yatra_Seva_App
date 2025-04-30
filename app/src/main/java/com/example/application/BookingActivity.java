package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class BookingActivity extends AppCompatActivity {

    private static final String TAG = "BookingActivity";
    private TextView tvDharamshalaNameBooking;
    private EditText etCheckInDate, etCheckOutDate, etNumberOfGuests, etGuestName, etPhoneNumber, etEmailAddress, etSpecialRequests, etCardNumber, etExpiryDate, etCVV;
    private Spinner spinnerRoomType;
    private Button btnConfirmBooking;
    private Calendar calendar;
    private SimpleDateFormat dateFormatter;
    private String dharamshalaName;
    private RadioGroup rgPaymentOptions;
    private RadioButton rbPaytm, rbGooglePay, rbPhonePe, rbCard;
    private LinearLayout layoutCardDetails;
    private DatabaseReference mDatabase;

    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        // Initialize Firebase Realtime Database
        mDatabase = FirebaseDatabase.getInstance().getReference();

        // Initialize Views
        tvDharamshalaNameBooking = findViewById(R.id.tvDharamshalaNameBooking);
        etCheckInDate = findViewById(R.id.etCheckInDate);
        etCheckOutDate = findViewById(R.id.etCheckOutDate);
        etNumberOfGuests = findViewById(R.id.etNumberOfGuests);
        etGuestName = findViewById(R.id.etGuestName);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etEmailAddress = findViewById(R.id.etEmailAddress);
        etSpecialRequests = findViewById(R.id.etSpecialRequests);
        spinnerRoomType = findViewById(R.id.spinnerRoomType);
        btnConfirmBooking = findViewById(R.id.btnConfirmBooking);
        rgPaymentOptions = findViewById(R.id.rgPaymentOptions);
        rbPaytm = findViewById(R.id.rbPaytm);
        rbGooglePay = findViewById(R.id.rbGooglePay);
        rbPhonePe = findViewById(R.id.rbPhonePe);
        rbCard = findViewById(R.id.rbCard);
        layoutCardDetails = findViewById(R.id.layoutCardDetails);
        etCardNumber = findViewById(R.id.etCardNumber);
        etExpiryDate = findViewById(R.id.etExpiryDate);
        etCVV = findViewById(R.id.etCVV);

        // Get Dharamshala Name from Intent
        dharamshalaName = getIntent().getStringExtra("dharamshala_name");
        if (dharamshalaName != null) {
            tvDharamshalaNameBooking.setText(dharamshalaName);
        } else {
            tvDharamshalaNameBooking.setText("Dharamshala Name Not Found");
        }

        // Set up Date Picker
        calendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

        etCheckInDate.setOnClickListener(v -> showDatePickerDialog(etCheckInDate));
        etCheckOutDate.setOnClickListener(v -> showDatePickerDialog(etCheckOutDate));

        // Payment option selection listener
        rgPaymentOptions.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rbCard) {
                layoutCardDetails.setVisibility(View.VISIBLE);
            } else {
                layoutCardDetails.setVisibility(View.GONE);
            }
        });

        // Set OnClickListener for the save button
        btnConfirmBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmBooking();
            }
        });
    }

    private void showDatePickerDialog(final EditText editText) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view, year, monthOfYear, dayOfMonth) -> {
                    Calendar newDate = Calendar.getInstance();
                    newDate.set(year, monthOfYear, dayOfMonth);
                    editText.setText(dateFormatter.format(newDate.getTime()));
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    private void confirmBooking() {
        String checkInDate = etCheckInDate.getText().toString().trim();
        String checkOutDate = etCheckOutDate.getText().toString().trim();
        String numberOfGuests = etNumberOfGuests.getText().toString().trim();
        String guestName = etGuestName.getText().toString().trim();
        String phoneNumber = etPhoneNumber.getText().toString().trim();
        String emailAddress = etEmailAddress.getText().toString().trim();
        String specialRequests = etSpecialRequests.getText().toString().trim();
        String roomType = spinnerRoomType.getSelectedItem().toString();
        int selectedPaymentId = rgPaymentOptions.getCheckedRadioButtonId();
        String paymentMethod = "";
        String cardNumber = "";
        String expiryDate = "";
        String cvv = "";

        if (checkInDate.isEmpty() || checkOutDate.isEmpty() || numberOfGuests.isEmpty() || guestName.isEmpty() || phoneNumber.isEmpty() || emailAddress.isEmpty()) {
            Toast.makeText(this, "Please fill in all the details", Toast.LENGTH_SHORT).show();
            return;
        }

        int guests;
        try {
            guests = Integer.parseInt(numberOfGuests);
            if (guests <= 0) {
                Toast.makeText(this, "Number of guests must be at least 1", Toast.LENGTH_SHORT).show();
                return;
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid number of guests", Toast.LENGTH_SHORT).show();
            return;
        }

        if (selectedPaymentId == R.id.rbPaytm) {
            paymentMethod = "Paytm";
            payViaUpi("YOUR_UPI_ID", "AMOUNT", "DHARAMSHALA_BOOKING");
        } else if (selectedPaymentId == R.id.rbGooglePay) {
            paymentMethod = "Google Pay";
            payViaUpi("YOUR_UPI_ID", "AMOUNT", "DHARAMSHALA_BOOKING");
        } else if (selectedPaymentId == R.id.rbPhonePe) {
            paymentMethod = "PhonePe";
            payViaUpi("YOUR_UPI_ID", "AMOUNT", "DHARAMSHALA_BOOKING");
        } else if (selectedPaymentId == R.id.rbCard) {
            paymentMethod = "Credit/Debit Card";
            cardNumber = etCardNumber.getText().toString().trim();
            expiryDate = etExpiryDate.getText().toString().trim();
            cvv = etCVV.getText().toString().trim();
            // In a real application, you would handle card payment securely.
            Toast.makeText(this, "Processing card details (for demonstration only)...", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please select a payment method", Toast.LENGTH_SHORT).show();
            return;
        }

        // Generate a unique ID for the booking
        String bookingId = mDatabase.child("bookings").push().getKey();

        if (bookingId != null) {
            // Create a map to store the booking details
            Map<String, Object> bookingData = new HashMap<>();
            bookingData.put("dharamshalaName", dharamshalaName);
            bookingData.put("checkInDate", checkInDate);
            bookingData.put("checkOutDate", checkOutDate);
            bookingData.put("numberOfGuests", guests);
            bookingData.put("guestName", guestName);
            bookingData.put("phoneNumber", phoneNumber);
            bookingData.put("emailAddress", emailAddress);
            bookingData.put("specialRequests", specialRequests);
            bookingData.put("roomType", roomType);
            bookingData.put("paymentMethod", paymentMethod);
            if (paymentMethod.equals("Credit/Debit Card")) {
                bookingData.put("cardNumber", cardNumber); // Consider security implications in real app
                bookingData.put("expiryDate", expiryDate); // Consider security implications in real app
                bookingData.put("cvv", cvv);             // Do NOT store CVV in a real application
            }

            // Store the booking data under the "bookings" node with the generated bookingId
            mDatabase.child("bookings").child(bookingId).setValue(bookingData)
                    .addOnSuccessListener(aVoid -> {
                        Log.d(TAG, "Booking data saved successfully for booking ID: " + bookingId);
                        Toast.makeText(BookingActivity.this, "Booking Confirmed!", Toast.LENGTH_LONG).show();
                        startThankYouFragment(dharamshalaName, checkInDate, checkOutDate, numberOfGuests, roomType, specialRequests);
                        clearForm();
                    })
                    .addOnFailureListener(e -> {
                        Log.e(TAG, "Error saving booking data: ", e);
                        Toast.makeText(BookingActivity.this, "Failed to confirm booking", Toast.LENGTH_SHORT).show();
                    });
        } else {
            Log.e(TAG, "Could not generate a unique booking ID.");
            Toast.makeText(BookingActivity.this, "Error confirming booking", Toast.LENGTH_SHORT).show();
        }
    }

    private void startThankYouFragment(String dharamshalaName, String checkInDate, String checkOutDate, String numberOfGuests, String roomType, String specialRequests) {
        ThankYouFragment thankYouFragment = new ThankYouFragment();
        Bundle args = new Bundle();
        String bookingDetails = "Dharamshala: " + dharamshalaName + "\n" +
                "Check-in: " + checkInDate + "\n" +
                "Check-out: " + checkOutDate + "\n" +
                "Guests: " + numberOfGuests + "\n" +
                "Room Type: " + roomType + "\n" +
                "Special Requests: " + specialRequests;
        args.putString("booking_info", bookingDetails);
        thankYouFragment.setArguments(args);

        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, thankYouFragment)
                .addToBackStack(null)
                .commit();
    }

    private void payViaUpi(String upiId, String amount, String note) {
        Uri uri = Uri.parse("upi://pay").buildUpon()
                .appendQueryParameter("pa", upiId)
                .appendQueryParameter("pn", "Recipient Name (Optional)")
                .appendQueryParameter("mc", "")
                .appendQueryParameter("tr", "TransactionId-" + System.currentTimeMillis())
                .appendQueryParameter("am", amount)
                .appendQueryParameter("cu", "INR")
                .appendQueryParameter("tn", note)
                .build();

        Intent paymentIntent = new Intent(Intent.ACTION_VIEW);
        paymentIntent.setData(uri);
        paymentIntent.setPackage("net.one97.paytm"); // Replace with the correct package for other UPI apps

        try {
            startActivity(paymentIntent);
        } catch (Exception e) {
            Toast.makeText(this, "UPI app not found.", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearForm() {
        etCheckInDate.setText("");
        etCheckOutDate.setText("");
        etNumberOfGuests.setText("");
        etGuestName.setText("");
        etPhoneNumber.setText("");
        etEmailAddress.setText("");
        etSpecialRequests.setText("");
        spinnerRoomType.setSelection(0);
        rgPaymentOptions.clearCheck();
        layoutCardDetails.setVisibility(View.GONE);
        etCardNumber.setText("");
        etExpiryDate.setText("");
        etCVV.setText("");
    }
}