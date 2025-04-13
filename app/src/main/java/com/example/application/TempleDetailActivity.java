package com.example.application;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TempleDetailActivity extends AppCompatActivity {

    ImageView templeImage;
    TextView templeName, templeHistory, addressTextView, contactTextView;
    LinearLayout contactLayout;
    ImageView mapIcon;
    TextView locationTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temple_detail);

        templeImage = findViewById(R.id.templeDetailImage);
        templeName = findViewById(R.id.templeName);
        templeHistory = findViewById(R.id.templeHistory);
        addressTextView = findViewById(R.id.templeAddress);
        contactTextView = findViewById(R.id.templeContact);
        contactLayout = findViewById(R.id.contactLayout);
        mapIcon = findViewById(R.id.mapIcon);
        locationTextView = findViewById(R.id.locationTextView);

        // Get intent data
        String name = getIntent().getStringExtra("temple_name");
        String history = getIntent().getStringExtra("temple_history");
        int imageResId = getIntent().getIntExtra("temple_image", -1);
        String address = getIntent().getStringExtra("temple_address");
        String contact = getIntent().getStringExtra("temple_contact");
        String mapUrl = getIntent().getStringExtra("temple_map_url");

        // Set data
        templeName.setText(name);
        templeHistory.setText(history);
        addressTextView.setText(address);
        contactTextView.setText(contact);
        if (imageResId != -1) {
            templeImage.setImageResource(imageResId);
        }

        // Handle map click
        View.OnClickListener mapClickListener = v -> {
            if (mapUrl != null && !mapUrl.isEmpty()) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mapUrl));
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        };

        mapIcon.setOnClickListener(mapClickListener);
        locationTextView.setOnClickListener(mapClickListener);

        // Handle contact click
        if (contact != null && !contact.isEmpty()) {
            contactLayout.setOnClickListener(v -> {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + contact));
                startActivity(callIntent);
            });
        }
    }
}
