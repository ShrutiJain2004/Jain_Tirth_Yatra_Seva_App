package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class TirthankarListActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tirthankar_list);

         imageView = findViewById(R.id.imageTirthankars);
        TextView textView = findViewById(R.id.textTirthankarsInfo);

        StringBuilder info = new StringBuilder();

        info.append("1. Rishabhanatha - Bull\n");
        info.append("2. Ajitanatha - Elephant\n");
        info.append("3. Sambhavanatha - Horse\n");
        info.append("4. Abhinandananatha - Monkey\n");
        info.append("5. Sumatinatha - Heron (Kurkul)\n");
        info.append("6. Padmaprabha - Red Lotus\n");
        info.append("7. Suparshvanatha - Swastik\n");
        info.append("8. Chandraprabha - Moon\n");
        info.append("9. Suvidhinatha - Crocodile\n");
        info.append("10. Shitalanatha - Shrivatsa\n");
        info.append("11. Shreyansanatha - Rhinoceros\n");
        info.append("12. Vasupujya - Buffalo\n");
        info.append("13. Vimalanatha - Boar\n");
        info.append("14. Anantanatha - Falcon (Hawk)\n");
        info.append("15. Dharmanatha - Thunderbolt (Vajra)\n");
        info.append("16. Shantinatha - Deer\n");
        info.append("17. Kunthunatha - Goat\n");
        info.append("18. Aranatha - Nandavarta\n");
        info.append("19. Mallinatha - Water Pot (Kalash)\n");
        info.append("20. Munisuvratanatha - Tortoise\n");
        info.append("21. Naminatha - Blue Lotus\n");
        info.append("22. Neminatha - Conch (Shankha)\n");
        info.append("23. Parshvanatha - Serpent\n");
        info.append("24. Mahavira - Lion");

        textView.setText(info.toString());
    }

}
