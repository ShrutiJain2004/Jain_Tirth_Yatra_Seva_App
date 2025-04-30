package com.example.application;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CalendarFragment extends Fragment {

    private EditText selectedDateEditText;
    private WebView calendarWebView;

    @SuppressLint("SetJavaScriptEnabled")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);

        TextView headingTextView = view.findViewById(R.id.calendarHeadingTextView);

        // Google Calendar WebView
        calendarWebView = view.findViewById(R.id.calendarWebView);
        calendarWebView.getSettings().setJavaScriptEnabled(true);
        calendarWebView.setWebViewClient(new WebViewClient());
        calendarWebView.loadUrl("https://calendar.google.com/calendar/embed?src=1c70b0b16ab1738b7bf520c442aeb051da01ef53790dfd3acba128f76de56477%40group.calendar.google.com&ctz=Asia%2FKolkata");

        return view;
    }
}
