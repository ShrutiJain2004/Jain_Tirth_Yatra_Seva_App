package com.example.application;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class DonationFragment extends Fragment {

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_donation, container, false);

        // Initialize the views
        TextView tvHeading = view.findViewById(R.id.tv_donation_heading);
        TextView tvDescription = view.findViewById(R.id.tv_donation_description);
        Button btnDonate = view.findViewById(R.id.btn_donate);

        // Set the heading and description
        tvHeading.setText("Donation");

        tvDescription.setText("Gupt Daan means anonymous donation — a selfless act of giving, where the donor does not seek recognition, "
                + "praise, or reward. In Jainism, this is considered one of the purest and most meritorious forms of donation, as it is done "
                + "purely out of compassion and duty, without any attachment to ego or name.\n\n"
                + "Spiritual Significance:\n"
                + "Gupt Daan is a true reflection of Aparigraha (non-possessiveness) and Ahimsa (non-violence).\n"
                + "It cultivates humility, compassion, and detachment, which are essential virtues for spiritual growth.\n"
                + "According to Jain scriptures, giving without expectations generates Punya (good karma) and helps in progressing on the path of liberation (Moksha).\n\n"
                + "What will your donation support?\n"
                + "- Educating underprivileged children and helping them build a better future.\n"
                + "- Providing basic necessities such as food, shelter, and clothing to needy families.\n"
                + "- Supporting Jain religious activities such as:\n"
                + "    • Organizing Poojas, Pravachans, and community gatherings.\n"
                + "    • Maintaining Jain temples and tirths.\n"
                + "    • Publishing spiritual literature and learning materials.\n\n"
                + "How is this donation different?\n"
                + "This donation is completely voluntary and will remain anonymous, in the true spirit of Gupt Daan. We do not collect names or publicize donor details. "
                + "It’s an act of faith, compassion, and inner growth.");

        // Set up the button click listener
        btnDonate.setOnClickListener(v -> {
            FragmentTransaction transaction = requireFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new DonationFormFragment()); // Make sure R.id.fragment_container exists in activity layout
            transaction.addToBackStack(null);
            transaction.commit();
        });
        return view;
    }
}
