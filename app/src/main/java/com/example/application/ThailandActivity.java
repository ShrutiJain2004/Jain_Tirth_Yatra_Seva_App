package com.example.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;

public class ThailandActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TempleAdapter adapter;
    EditText searchEditText;
    Button searchButton;
    List<Temple> templeList;
    List<Temple> filteredList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thailand);

        recyclerView = findViewById(R.id.thailandTempleRecycler);
        searchEditText = findViewById(R.id.searchInput);
        searchButton = findViewById(R.id.searchButton);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // Show one below another

        templeList = new ArrayList<>();

        templeList.add(new Temple("Shree Sambhavnath Jain Derasar, Bangkok", "", R.drawable.sambhavnath,"https://maps.google.com/?q=Shree+Sambhavnath+Jain" +
                "+Derasar+Bangkok","Address : 191/24, Soi Putha Osoth, Suriwong Road, Bangrak, Bangkok, Thailand." ," History : This temple serves as a" +
                " significant place of worship for the Jain community in Bangkok, offering regular religious services and cultural events. "
               ,"Contact :+66 2 631 5176 , +66 81 932 2731 "
        ));
        templeList.add(new Temple("Shri 1008 Mahavir Digamber Jain Mandir, Bangkok", "", R.drawable.mahavir,"https://maps.google.com/?q=Shree+1008+Mahavir+Digamber" +
                "+Jain+Mandir+Bangkok","Address :  143/2-3 Phuttha Osot Alley, Suriya Wong, Bang Rak, Bangkok, Thailand" ," History : Established to cater to the" +
                " spiritual needs of the Digamber Jain community in Bangkok, this temple hosts various religious ceremonies and festivals."
                ,"Contact : +66 2 233 7894 , +66 80 557 7696 "
        ));

        templeList.add(new Temple("Sankeshwar Parshwanath Jain Jinalay, Bangkok","", R.drawable.sankeshwar,"https://maps.google.com/?q=Sankeshwar+Parshwanath+Jain" +
                "+Jinalay+Bangkok", "Address : 423/31, Lumpini Place, Water Cliff - 1, Tower C, 14th Floor, Chongnoonchi Yannawa, Bangkok, Thailand","history : Sankeshwar" +
                " Parshwanath Jain Jinalay in Bangkok is a significant place of worship for the Jain community in Thailand. This temple serves as a spiritual hub for devotees, offering a serene" +
                "environment for worship and meditation. " ," Contact : +66 - 891395070  or +66 - 814865626. "
        ));
        filteredList = new ArrayList<>(templeList);
        adapter = new TempleAdapter(this, filteredList);
        recyclerView.setAdapter(adapter);

        // Search Button Click
        searchButton.setOnClickListener(v -> {
            String query = searchEditText.getText().toString().toLowerCase().trim();
            filteredList.clear();
            if (TextUtils.isEmpty(query)) {
                filteredList.addAll(templeList);
            } else {
                for (Temple temple : templeList) {
                    if (temple.getName().toLowerCase().contains(query)) {
                        filteredList.add(temple);
                    }
                }
            }
            adapter.notifyDataSetChanged();
        });
    }
}
