package com.example.application;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class CityTempleActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TempleAdapter templeAdapter;
    private List<Temple> templeList;
    private List<Temple> filteredTempleList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_temple);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get selected city name passed from CityAdapter
        String selectedCity = getIntent().getStringExtra("selectedCity");

        // Create full temple list
        templeList = new ArrayList<>();

        templeList.add(new Temple("Jain Mandir Lahore", "Lahore", R.drawable.lahore_temple1,"https://maps.google.com/?q=Jain+Mandir+Lahore",
                "Address : Jain Mandir Chowk, Anarkali Bazaar, Lahore, Punjab 54000, Pakistan." ," History :" +
                " The Lahore Jain Temple , built in the early 1900s near Anarkali Bazaar,was a sacred place for the Jain community." +
                "Dedicated to Lord Mahavira, it showcased beautiful Shwetambar Jain architecture. After the 1947 Partition, it was abandoned and later demolished in 1992," +
                "but it remains a historic symbol of Jain heritage in Pakistan","Contact : "
        ));

        templeList.add(new Temple("Jain Mandir Rawalpindi", "Rawalpindi", R.drawable.rawalpindi_temple1,"https://maps.google.com/?q=Jain+Mandir+Rawalpindi",
                "Address :J323+6RR, Wahd Gare, Md Hussain Rd, Rawalpindi, 46000, Pakistan", "History :" +
                "The Jain Mandir in Rawalpindi, located near College Road, was a major temple before 1947." +
                " It served a large Jain community in the Bhabra Bazaar area. After Partition, it was abandoned and later repurposed for housing, " +
                "but the original structure still stands, reflecting Rawalpindi’s Jain heritage.","Contact : +92 323 470359468 , +92 330 05169527, +92 347 6342510"));


        templeList.add(new Temple("Shri Vishwanath Jain Shwetambar Mandir (Jain Swamber Temple)", "Multan", R.drawable.multan_temple1,"https://maps.google.com/?q=" +
                "Shri+Vishwanath+Jain+Shwetambar+Mandir+Multan","Address : Near Chowk Bazaar, close to Masjid Phool Hattan, inside Bohar Gate, Inner Walled City, Multan",
                "History : Believed to be constructed around 1850, this temple is associated with the Suembra sect of Jainism.The main entrance features intricately carved" +
                        " wooden doors, with an inscription identifying it as \"Shri Vishwanath Jain Shwetambar Mandir.","Contact : "));

        templeList.add(new Temple("Swaminarayan Jain Temple", "Karachi", R.drawable. karachi_temple1, "https://maps.google.com/?q=Swaminarayan+Jain+Temple+Karachi",
                "Address : Muhammad Ali Jinnah Road, Karachi, Pakistan", "History :" +
                " The Swaminarayan Jain Temple in Multan was a unique blend of Jain and Swaminarayan architecture, built by the" +
                "Jain community before 1947. It served as a peaceful place of worship and spiritual learning. After Partition, the temple was left abandoned, yet it remains a " +
                "silent symbol of Multan’s diverse religious history. ","Contact : +92 71 9310719"));

        templeList.add(new Temple("Jain Temple Sindh", "Sindh", R.drawable.sindh_temple1,"https://maps.google.com/?q=Jain+Temple+Sindh",
                "Address : Virawah, Nagarparkar, Tharparkar District, Sindh, Pakistan", "History :" +
                " Sindh, especially Nagarparkar, is home to ancient Jain temples dating back to the" +
                " 12th–15th centuries. Temples like Gori Temple and Nagarparkar Bazaar Temple showcase beautiful architecture, frescoes, and domes. " +
                "These historic sites reflect the rich Jain heritage that once thrived in the region. ","Contact :(+92) 51-9252516 "));

        // Filter temples by selected city
        filteredTempleList = new ArrayList<>();
        for (Temple temple : templeList) {
            if (temple.getCity().equalsIgnoreCase(selectedCity)) {
                filteredTempleList.add(temple);
            }
        }

        // Set adapter with filtered list
        templeAdapter = new TempleAdapter(this, filteredTempleList);
        recyclerView.setAdapter(templeAdapter);
    }
}
