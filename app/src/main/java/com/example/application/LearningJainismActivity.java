package com.example.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LearningJainismActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<LearningTopic> topicList;
    LearningTopicAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_jainism);

        recyclerView = findViewById(R.id.learningRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        topicList = new ArrayList<>();
        topicList.add(new LearningTopic("24 Tirthankar", R.drawable.tirthankar));
        topicList.add(new LearningTopic("Navkar Mantra", R.drawable.navkar));
        topicList.add(new LearningTopic("8 Karma's", R.drawable.karma));
        topicList.add(new LearningTopic("Chaityavandan Vidhi", R.drawable.chaityavandan));
        topicList.add(new LearningTopic("Bhaktambar", R.drawable.bhaktambar));
        topicList.add(new LearningTopic("Samayik Vidhi", R.drawable.samayik));
        topicList.add(new LearningTopic("Pratikraman Vidhi", R.drawable.pratikraman));
        topicList.add(new LearningTopic("Ashta Prakari Puja", R.drawable.puja));

        adapter = new LearningTopicAdapter(topicList, topic -> {
            Intent intent = null;

            switch (topic.getTitle()) {
                case "24 Tirthankar":
                    intent = new Intent(this, TirthankarActivity.class);
                    break;
                case "Navkar Mantra":
                    intent = new Intent(this, NavkarMantraActivity.class);
                    break;
                case "8 Karma's":
                    intent = new Intent(this, KarmaActivity.class);
                    break;
                case "Chaityavandan Vidhi":
                    intent = new Intent(this, ChaityavandanActivity.class);
                    break;
                case "Bhaktambar":
                    intent = new Intent(this, BhaktambarActivity.class);
                    break;
                case "Samayik Vidhi":
                    intent = new Intent(this, SamayikActivity.class);
                    break;
                case "Pratikraman Vidhi":
                    intent = new Intent(this, PratikramanActivity.class);
                    break;
                case "Ashta Prakari Puja":
                    intent = new Intent(this, AshtaPujaActivity.class);
                    break;
            }
            if (intent != null) {
                startActivity(intent);
            }
        });


        recyclerView.setAdapter(adapter);
    }
}
