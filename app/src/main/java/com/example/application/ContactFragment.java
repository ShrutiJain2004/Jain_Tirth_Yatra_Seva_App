package com.example.application;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.application.R;

public class ContactFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        TextView emailText = view.findViewById(R.id.email_text);
        TextView phoneText = view.findViewById(R.id.phone_text);
        TextView websiteText = view.findViewById(R.id.website_text);

        // 📧 Email click
        emailText.setOnClickListener(v -> {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:support@tirthyatra.com"));
            startActivity(Intent.createChooser(emailIntent, "Send email"));
        });

        // 📞 Phone click
        phoneText.setOnClickListener(v -> {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:+919079177109"));
            startActivity(callIntent);
        });

        // 🌐 Website click
        websiteText.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tirthyatraseva.com"));
            startActivity(browserIntent);
        });

        return view;
    }
}
