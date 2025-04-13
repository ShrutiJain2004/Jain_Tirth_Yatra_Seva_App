package com.example.application;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TirthankarStoryActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tirthankar_story);

        TextView textView = findViewById(R.id.tirthankarStoryTextView);
        textView.setText(
               "\n\n" +
                        "The 24 Tirthankars are spiritual teachers who attained liberation and helped others do the same. " +
                        "They were born in different ages and kingdoms, and each one taught the path of right knowledge, right faith, and right conduct.\n\n" +
                        "The first Tirthankar, Rishabhanatha, is considered the founder of Jainism in the current time cycle. " +
                        "The last Tirthankar, Mahavira, lived around 2600 years ago and revitalized the teachings of Jainism.\n\n" +
                        "Each Tirthankar has a unique symbol and color, and their life stories serve as spiritual inspiration for Jain followers around the world."
        );
    }
}
