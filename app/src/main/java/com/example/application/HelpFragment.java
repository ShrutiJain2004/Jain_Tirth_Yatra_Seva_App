package com.example.application;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.application.R;

public class HelpFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_help, container, false);

        Button contactSupportButton = view.findViewById(R.id.btn_contact_support);

        // Open Email App for Support
        contactSupportButton.setOnClickListener(v -> {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:support@example.com"));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Support Request");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Hello, I need help with...");
            startActivity(emailIntent);
        });

        return view;
    }
}
