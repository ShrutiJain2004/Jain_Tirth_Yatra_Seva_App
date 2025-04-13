package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class KarmaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karma);

        TextView textView = findViewById(R.id.karmaTextView);

        String karmaExplanation = "In Jainism, karma is a subtle matter that binds to the soul due to actions.\n\n" +
                "1. Gyanavarniya Karma (Knowledge-Obscuring) - Obscures the soul's ability to know.\n" +
                "2. Darshanavarniya Karma (Perception-Obscuring) - Obscures the soul's ability to perceive.\n" +
                "3. Mohaniya Karma (Deluding) - Clouds right belief and conduct.\n" +
                "4. Antaraya Karma (Obstructing) - Prevents doing good deeds or achieving goals.\n" +
                "5. Nam Karma (Body-determining) - Determines physical form and features.\n" +
                "6. Gotra Karma (Status-determining) - Determines birth in high or low family.\n" +
                "7. Vedaniya Karma (Feeling-Producing) - Produces feelings of pleasure or pain.\n" +
                "8. Ayushya Karma (Lifespan-Determining) - Determines the lifespan of next birth.\n\n" +
                "Liberation (Moksha) is attained when all karmas are shed.";

        textView.setText(karmaExplanation);

    }
}