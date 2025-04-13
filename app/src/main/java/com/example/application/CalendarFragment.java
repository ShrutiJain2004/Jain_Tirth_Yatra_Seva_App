package com.example.application;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.application.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CalendarFragment extends Fragment {

    private TextView selectedDateText;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) CalendarView calendarView = view.findViewById(R.id.calendarView);
        selectedDateText = view.findViewById(R.id.selectedDateText);

        // Set default selected date
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        selectedDateText.setText("Selected Date: " + sdf.format(new Date()));

        // Handle date selection
        calendarView.setOnDateChangeListener((view1, year, month, dayOfMonth) -> {
            String selectedDate = dayOfMonth + "-" + (month + 1) + "-" + year;
            selectedDateText.setText("Selected Date: " + selectedDate);
        });

        return view;
    }
}
