package com.example.application;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class PanchTirthiDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panch_tirthi_details);

        String stateName = getIntent().getStringExtra("STATE_NAME");

        TextView tvState = findViewById(R.id.tvStateName);
        TextView tvSubHeading = findViewById(R.id.tvSubHeading);
        LinearLayout tirthContainer = findViewById(R.id.tirthContainer);

        tvState.setText(stateName);
        tvSubHeading.setText("Panch Tirthi");

        if (stateName.equals("Gujarat")) {
            addTirth("Shankeshwar", R.drawable.sankeshwar, tirthContainer);
            addTirth("Girnar Ji", R.drawable.girnarji, tirthContainer);
        } else if (stateName.equals("Rajasthan")) {
            addTirth("Nakoda Parshwanath", R.drawable.nakoda, tirthContainer);
            addTirth("Ranakpur", R.drawable.rankpur, tirthContainer);
        } else if (stateName.equals("Maharashtra")) {
            addTirth("Mangi Tungi", R.drawable.mangitungi, tirthContainer);
            addTirth("Kunthalgiri", R.drawable.kunthalgiri, tirthContainer);
        } else if (stateName.equals("Madhya Pradesh")) {
            addTirth("Sonagiri Jain Temples", R.drawable.sonagiri, tirthContainer);
            addTirth("Kundalpur Jain Temple", R.drawable.kundalpur, tirthContainer);
        } else if (stateName.equals("Uttar Pradesh")) {
            addTirth("Hastinapur", R.drawable.hastinapur, tirthContainer);
            addTirth("Deogarh", R.drawable.deogarh, tirthContainer);
        }


    }


    private void addTirth(String tirthName, int imageResId, LinearLayout container) {

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(16, 16, 16, 16);

        ImageView image = new ImageView(this);
        image.setLayoutParams(new ViewGroup.LayoutParams(400, 400));
        image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        image.setImageResource(imageResId);
        image.setBackgroundResource(R.drawable.image_border);

        TextView text = new TextView(this);
        text.setText(tirthName);
        text.setTextSize(18);
        text.setTypeface(null, Typeface.BOLD);
        text.setGravity(Gravity.CENTER);

        layout.addView(image);
        layout.addView(text);
        container.addView(layout);

        View.OnClickListener listener = v -> {
            Intent intent = new Intent(PanchTirthiDetailsActivity.this, TirthDetailsActivity.class);
            intent.putExtra("tirth_name", tirthName);
            startActivity(intent);
        };

        image.setOnClickListener(listener);
        text.setOnClickListener(listener);

    }



}