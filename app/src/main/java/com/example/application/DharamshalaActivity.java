package com.example.application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.Map;

public class DharamshalaActivity extends AppCompatActivity implements OnMapReadyCallback {

    private TextView tvDharamshalaName;
    private ImageView imgDharamshala;
    private String tirthName;
    private GoogleMap mMap;

    // Store location data for each Tirth
    private static final Map<String, LatLng> tirthLocations = new HashMap<>();

    static {
        tirthLocations.put("Shankeshwar", new LatLng(23.6187, 71.6578)); // Example coordinates
        tirthLocations.put("Girnar Ji", new LatLng(21.5333, 70.4667));   // Example coordinates
        tirthLocations.put("Mahudi", new LatLng(23.6833, 72.6833));    // Example coordinates
        tirthLocations.put("Mehsana", new LatLng(23.5974, 72.3696));   // Example coordinates
        tirthLocations.put("Taleti", new LatLng(21.55, 70.45));        // Example coordinates
        tirthLocations.put("Songadh Jain Temple", new LatLng(21.7077, 73.5747)); // Example coordinates
        tirthLocations.put("Nakoda Parshwanath", new LatLng(25.6333, 71.3500)); // Example coordinates
        tirthLocations.put("Ranakpur", new LatLng(25.1267, 73.4467));   // Example coordinates
        tirthLocations.put("Khajuri", new LatLng(25.6000, 76.3333));   // Example coordinates
        tirthLocations.put("Jirawala", new LatLng(24.7833, 72.0667));   // Example coordinates
        tirthLocations.put("Kumbhalgarh", new LatLng(25.1500, 73.5833)); // Example coordinates
        tirthLocations.put("Shree Keshariya Ji Jain Temple", new LatLng(23.6194, 73.6944)); // Example coordinates
        tirthLocations.put("Mangi Tungi", new LatLng(20.5667, 74.2000)); // Example coordinates
        tirthLocations.put("Kunthalgiri", new LatLng(18.9333, 75.1000)); // Example coordinates
        tirthLocations.put("Toranmal", new LatLng(21.6667, 74.5667));   // Example coordinates
        tirthLocations.put("Rishabhdev", new LatLng(23.6833, 73.5833)); // Example coordinates
        tirthLocations.put("Gajpanth", new LatLng(20.5333, 75.0167));   // Example coordinates
        tirthLocations.put("Chanderi Jain Temple", new LatLng(24.7167, 78.1333)); // Example coordinates
        tirthLocations.put("Datia Jain Temples", new LatLng(25.6667, 78.4667)); // Example coordinates
        tirthLocations.put("Sonagiri Jain Temples", new LatLng(25.6500, 78.2167)); // Example coordinates
        tirthLocations.put("Kundalpur Jain Temple", new LatLng(25.5667, 79.3500)); // Example coordinates
        tirthLocations.put("Pawagiri", new LatLng(20.4333, 75.2000));   // Example coordinates
        tirthLocations.put("Bawangaja", new LatLng(21.8167, 75.1500));  // Example coordinates
        tirthLocations.put("Hastinapur", new LatLng(29.1000, 78.0167));  // Example coordinates
        tirthLocations.put("Deogarh", new LatLng(24.5333, 78.2333));   // Example coordinates
        tirthLocations.put("Jambudweep Jain Temple", new LatLng(29.8667, 77.7333)); // Example coordinates
        tirthLocations.put("Parashnath Digambar Jain Temple", new LatLng(23.9500, 86.3000)); // Example coordinates
        tirthLocations.put("Lalitpur Jain Temples", new LatLng(24.6833, 78.4167)); // Example coordinates
        tirthLocations.put("Parichha Jain Temple", new LatLng(25.4667, 78.6167)); // Example coordinates
        tirthLocations.put("Shree Sambhavnath Jain Derasar, Bangkok", new LatLng(13.7563, 100.5018)); // Bangkok, Thailand
        tirthLocations.put("Shri 1008 Mahavir Digamber Jain Mandir, Bangkok", new LatLng(13.7563, 100.5018)); // Bangkok, Thailand
        tirthLocations.put("Sankeshwar Parshwanath Jain Jinalay, Bangkok", new LatLng(13.7563, 100.5018)); // Bangkok, Thailand
        tirthLocations.put("Jain Mandir Lahore,Pakistan", new LatLng(31.5820, 74.3294)); // Lahore, Pakistan
        tirthLocations.put("Jain Mandir Rawalpindi,Pakistan", new LatLng(33.6261, 73.0714)); // Rawalpindi, Pakistan
        tirthLocations.put("Shri Vishwanath Jain Shwetambar Mandir (Jain Swamber Temple),Multan,Pakistan", new LatLng(30.1975, 71.4758)); // Multan, Pakistan (approximate)
        tirthLocations.put("Swaminarayan Jain Temple,Karachi,Pakistan", new LatLng(24.8609, 67.0099)); // Karachi, Pakistan (approximate)
        tirthLocations.put("Jain Temple Sindh , Pakistan", new LatLng(25.7321, 68.5157)); // Sindh province center (approximate)
        tirthLocations.put("Soniji Ki Nasiyan, Ajmer", new LatLng(26.4559, 74.6397)); // Ajmer
        tirthLocations.put("Lodurva Jain Temple,Jaisalmer", new LatLng(26.5500, 70.6333)); // Lodurva (near Jaisalmer)
        tirthLocations.put("Shri Kesariyaji Rishabdev Jain Temple, Udaipur", new LatLng(24.5854, 73.6992)); // Udaipur
        tirthLocations.put("Dilwara Jain Temple, Mount Abu", new LatLng(24.5917, 72.7189)); // Mount Abu
        tirthLocations.put("Hutheesing Jain Temple, Ahemdabad", new LatLng(23.0339, 72.5803)); // Ahmedabad
        tirthLocations.put("Shree Shatrunjaya Tirth, Palitana", new LatLng(21.5208, 71.8450)); // Palitana
        tirthLocations.put("Taranga Jain Tirth (Mehsana)", new LatLng(23.7833, 72.5833)); // Taranga (near Mehsana)
        tirthLocations.put("Kumbhariya Jain Tirth", new LatLng(24.3333, 72.6167)); // Kumbhariya
        tirthLocations.put("Sammed ShikharJi", new LatLng(23.9475, 86.1289)); // Jharkhand
        tirthLocations.put("Dadabari Jain Shwetambar Mandir,Mehroli", new LatLng(28.5167, 77.1833)); // Mehrauli, Delhi
        tirthLocations.put("Antarikṣa Pārśvanātha Tīrtha, Maharashtra", new LatLng(20.6833, 75.3833)); // Washim district, Maharashtra (approximate)

    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dharamshala);

        imgDharamshala = findViewById(R.id.imgDharamshala);
        tvDharamshalaName = findViewById(R.id.tvDharamshalaName);
        TextView heading = findViewById(R.id.tvHeading);

        // Get the "tirth_name" extra from the intent
        tirthName = getIntent().getStringExtra("tirth_name");

        // Set the heading dynamically with the tirth name
        if (tirthName != null) {
            heading.setText("Dharamshala at " + tirthName);

            // Set Dharamshala name and image based on tirth name
            if (tirthName.equals("Shankeshwar")) {
                tvDharamshalaName.setText("Shankeshwar Jain Agam Mandir Dharamshala");
                imgDharamshala.setImageResource(R.drawable.shankheswar_image);
            } else if (tirthName.equals("Girnar Ji")) {
                tvDharamshalaName.setText("Girnar Jain Trust Dharamshala");
                imgDharamshala.setImageResource(R.drawable.girnar_dharamshala);
            } else if (tirthName.equals("Mahudi")) {
                tvDharamshalaName.setText("Mahudi Jain Dharamshala");
                imgDharamshala.setImageResource(R.drawable.mahudi_dharamshala);
            } else if (tirthName.equals("Mehsana")) {
                tvDharamshalaName.setText("Mehsana Jain Atithi Bhavan");
                imgDharamshala.setImageResource(R.drawable.mehsana_dharamshala);
            } else if (tirthName.equals("Taleti")) {
                tvDharamshalaName.setText("Taleti Jain Dharamshala");
                imgDharamshala.setImageResource(R.drawable.taleti_dharamshala);
            } else if (tirthName.equals("Songadh Jain Temple")) {
                tvDharamshalaName.setText("Songadh Jain Temple Dharamshala");
                imgDharamshala.setImageResource(R.drawable.songadh_dharamshala);
            } else if (tirthName.equals("Nakoda Parshwanath")) {
                tvDharamshalaName.setText("Nakoda Jain Dharamshala");
                imgDharamshala.setImageResource(R.drawable.nakoda_dharamshala);
            } else if (tirthName.equals("Ranakpur")) {
                tvDharamshalaName.setText("Ranakpur Jain Dharamshala");
                imgDharamshala.setImageResource(R.drawable.ranakpur_dharamshala);
            } else if (tirthName.equals("Khajuri")) {
                tvDharamshalaName.setText("Khajuri Jain Dharamshala");
                imgDharamshala.setImageResource(R.drawable.khajuri_dharamshala);
            } else if (tirthName.equals("Jirawala")) {
                tvDharamshalaName.setText("Jirawala Jain Dharamshala");
                imgDharamshala.setImageResource(R.drawable.jirawala_dharamshala);
            } else if (tirthName.equals("Kumbhalgarh")) {
                tvDharamshalaName.setText("Kumbhalgarh Jain Dharamshala");
                imgDharamshala.setImageResource(R.drawable.kumbhalgarh_dharamshala);
            } else if (tirthName.equals("Shree Keshariya Ji Jain Temple")) {
                tvDharamshalaName.setText("Shree Keshariya Ji Jain Temple Dharamshala");
                imgDharamshala.setImageResource(R.drawable.kesariya_dharamshala);
            } else if (tirthName.equals("Mangi Tungi")) {
                tvDharamshalaName.setText("Mangi Tungi Jain Dharamshala");
                imgDharamshala.setImageResource(R.drawable.mangitungi_dharamshala);
            } else if (tirthName.equals("Kunthalgiri")) {
                tvDharamshalaName.setText("Kunthalgiri Jain Dharamshala");
                imgDharamshala.setImageResource(R.drawable.kunthalgiri_dharamshala);
            } else if (tirthName.equals("Toranmal")) {
                tvDharamshalaName.setText("Toranmal Jain Dharamshala");
                imgDharamshala.setImageResource(R.drawable.toranmal_dharamshala);
            } else if (tirthName.equals("Rishabhdev")) {
                tvDharamshalaName.setText("Rishabhdev Jain Dharamshala");
                imgDharamshala.setImageResource(R.drawable.rishabhdev_dharamshala);
            } else if (tirthName.equals("Gajpanth")) {
                tvDharamshalaName.setText("Gajpanth Jain Dharamshala");
                imgDharamshala.setImageResource(R.drawable.gajpanth_dharamshala);
            } else if (tirthName.equals("Chanderi Jain Temple")) {
                tvDharamshalaName.setText("Chanderi Jain Temple Dharamshala");
                imgDharamshala.setImageResource(R.drawable.chanderi_dharamshala);
            } else if (tirthName.equals("Datia Jain Temples")) {
                tvDharamshalaName.setText("Datia Jain Temples Dharamshala");
                imgDharamshala.setImageResource(R.drawable.datia_dharamshala);
            }else if (tirthName.equals("Sonagiri Jain Temples")) {
                tvDharamshalaName.setText("Sonagiri Jain Temples Dharamshala");
                imgDharamshala.setImageResource(R.drawable.sonagiri_dharamshala);
            }else if (tirthName.equals("Kundalpur Jain Temple")) {
                tvDharamshalaName.setText("Kundalpur Jain Temple Dharamshala");
                imgDharamshala.setImageResource(R.drawable.kundalpur_dharamshala);
            } else if (tirthName.equals("Pawagiri")) {
                tvDharamshalaName.setText("Pawagiri Jain Dharamshala");
                imgDharamshala.setImageResource(R.drawable.pawagiri_dharamshala);
            } else if (tirthName.equals("Bawangaja")) {
                tvDharamshalaName.setText("Bawangaja Jain Dharamshala");
                imgDharamshala.setImageResource(R.drawable.bawangaja_dharamshala);
            } else if (tirthName.equals("Hastinapur")) {
                tvDharamshalaName.setText("Hastinapur Jain Dharamshala");
                imgDharamshala.setImageResource(R.drawable.hastinapur_dharamshala);
            } else if (tirthName.equals("Deogarh")) {
                tvDharamshalaName.setText("Deogarh Jain Dharamshala");
                imgDharamshala.setImageResource(R.drawable.deogarh_dharamshala);
            } else if (tirthName.equals("Jambudweep Jain Temple")) {
                tvDharamshalaName.setText("Jambudweep Jain Temple Dharamshala");
                imgDharamshala.setImageResource(R.drawable.jambudweep_dharamshala);
            } else if (tirthName.equals("Parashnath Digambar Jain Temple")) {
                tvDharamshalaName.setText("Parashnath Digambar Jain Temple Dharamshala");
                imgDharamshala.setImageResource(R.drawable.parashnath_dharamshala);
            } else if (tirthName.equals("Lalitpur Jain Temples")) {
                tvDharamshalaName.setText("Lalitpur Jain Temples Dharamshala");
                imgDharamshala.setImageResource(R.drawable.lalitpur_dharamshala);
            } else if (tirthName.equals("Parichha Jain Temple")) {
                tvDharamshalaName.setText("Parichha Jain Temple Dharamshala");
                imgDharamshala.setImageResource(R.drawable.parichha_dharamshala);
            }else if (tirthName.equals("Shree Sambhavnath Jain Derasar, Bangkok")) {
                tvDharamshalaName.setText("Bangkok Jain Temple Dharamshala");
                imgDharamshala.setImageResource(R.drawable.chanderi_dharamshala);
            } else if (tirthName.equals("Shri 1008 Mahavir Digamber Jain Mandir, Bangkok")) {
                tvDharamshalaName.setText("Bangkok Jain Temple Dharamshala");
                imgDharamshala.setImageResource(R.drawable.parichha_dharamshala);
            } else if (tirthName.equals("Sankeshwar Parshwanath Jain Jinalay, Bangkok")) {
                tvDharamshalaName.setText("Bangkok Jain Temple Dharamshala");
                imgDharamshala.setImageResource(R.drawable.lalitpur_dharamshala);
            } else if (tirthName.equals("Jain Mandir Lahore")) {
                tvDharamshalaName.setText("Lahore Jain Temple Dharamshala");
                imgDharamshala.setImageResource(R.drawable.parashnath_dharamshala);
            } else if (tirthName.equals("Jain Mandir Rawalpindi")) {
                tvDharamshalaName.setText("Rawalpindi Jain Temple Dharamshala");
                imgDharamshala.setImageResource(R.drawable.kundalpur_dharamshala);
            }else if (tirthName.equals("Shri Vishwanath Jain Shwetambar Mandir (Jain Swamber Temple)")) {
                tvDharamshalaName.setText("Multan Jain Temple Dharamshala");
                imgDharamshala.setImageResource(R.drawable.mangitungi_dharamshala);
            } else if (tirthName.equals("Swaminarayan Jain Temple")) {
                tvDharamshalaName.setText("Karachi Jain Temple Dharamshala");
                imgDharamshala.setImageResource(R.drawable.lalitpur_dharamshala);
            } else if (tirthName.equals("Jain Temple Sindh")) {
                tvDharamshalaName.setText("Sindh Jain Temple Dharamshala");
                imgDharamshala.setImageResource(R.drawable.parashnath_dharamshala);
            }else if (tirthName.equals("Soniji Ki Nasiyan, Ajmer")) {
                tvDharamshalaName.setText("Digamber Jain Atishay Kshetra Soniji Ki Nasiyan");
                imgDharamshala.setImageResource(R.drawable.gajpanth_dharamshala);
            } else if (tirthName.equals("Lodurva Jain Temple,Jaisalmer")) {
                tvDharamshalaName.setText("Jain Dharamshala Jaisalmer");
                imgDharamshala.setImageResource(R.drawable.mangitungi_dharamshala);
            } else if (tirthName.equals("Shri Kesariyaji Rishabdev Jain Temple, Udaipur")) {
                tvDharamshalaName.setText("Gaj Mandir Kesariaji");
                imgDharamshala.setImageResource(R.drawable.kesariya_dharamshala);
            } else if (tirthName.equals("Dilwara Jain Temple , Mount Abu")) {
                tvDharamshalaName.setText("Adinath Digambar Jain Mandir and Jain Dharmshala Mount Abu");
                imgDharamshala.setImageResource(R.drawable.parashnath_dharamshala);
            } else if (tirthName.equals("Hutheesing Jain Temple")) {
                tvDharamshalaName.setText("Marchipole Jain Dharmshala");
                imgDharamshala.setImageResource(R.drawable.lalitpur_dharamshala);
            } else if (tirthName.equals("Shree Shatrunjaya Tirth, Palitana")) {
                tvDharamshalaName.setText("Mewad Bhavan ( Palitana )");
                imgDharamshala.setImageResource(R.drawable.taleti_dharamshala);
            }else if (tirthName.equals("Taranga Jain Tirth (Mehsana)")) {
                tvDharamshalaName.setText("Taranga Jain Tirth Dharamshala");
                imgDharamshala.setImageResource(R.drawable.kundalpur_dharamshala);
            } else if (tirthName.equals("Kumbhariya Jain Tirth")) {
                tvDharamshalaName.setText("Kumbhariya Jain Tirth Dharamshala");
                imgDharamshala.setImageResource(R.drawable.kundalpur_dharamshala);
            } else if (tirthName.equals("Sammed ShikharJi")) {
                tvDharamshalaName.setText("Shikharji Dharamshala (Rajendra Dham)");
                imgDharamshala.setImageResource(R.drawable.taleti_dharamshala);
            } else if (tirthName.equals("Dadabari Jain Shwetambar Mandir")) {
                tvDharamshalaName.setText("Jain Mandir Chhoti Dadabwadi");
                imgDharamshala.setImageResource(R.drawable.gajpanth_dharamshala);
            } else if (tirthName.equals("Antarikṣa Pārśvanātha Tīrtha")) {
                tvDharamshalaName.setText("Shree Antariksh Parshwanath Shwetambar Jain Dharamshala");
                imgDharamshala.setImageResource(R.drawable.lalitpur_dharamshala);
            } else if (tirthName.equals("Girnar Jain Tirth (Junagadh)")) {
                tvDharamshalaName.setText("Girnar Jain Trust Dharamshala");
                imgDharamshala.setImageResource(R.drawable.girnar_dharamshala);
            } else {
                tvDharamshalaName.setText("Nearby Dharamshalas"); // Default text if no match
                imgDharamshala.setImageResource(R.drawable.mehsana_dharamshala); // Default image if no match
            }


                // Initialize the map fragment
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.mapFragment);
            if (mapFragment != null) {
                mapFragment.getMapAsync(this);
            }
        }

        // Set click listeners for image and text view to open details
        View.OnClickListener openDetailListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DharamshalaActivity.this, DharamshalaDetailActivity.class);
                intent.putExtra("dharamshala_name", tvDharamshalaName.getText().toString()); // Pass the Dharamshala name
                intent.putExtra("tirth_name", tirthName); // Also pass the tirth name
                startActivity(intent);
            }
        };

        imgDharamshala.setOnClickListener(openDetailListener);
        tvDharamshalaName.setOnClickListener(openDetailListener);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        LatLng location = tirthLocations.get(tirthName);

        if (location != null) {
            // Add a marker at the Tirth location and move the camera
            mMap.addMarker(new MarkerOptions().position(location).title("Dharamshala at " + tirthName));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15)); // Adjust zoom level as needed
        } else {
            LatLng defaultLocation = new LatLng(20.00, 77.00); // Example default
            mMap.addMarker(new MarkerOptions().position(defaultLocation).title("Location Not Found"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(defaultLocation, 10));
        }
    }
}