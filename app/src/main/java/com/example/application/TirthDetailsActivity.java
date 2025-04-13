package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TirthDetailsActivity extends AppCompatActivity {
    String videoUrl = "";
    String locationUrl = "";
    String distanceText = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tirth_details);
        // Retrieve the search query passed via the Intent
        String searchQuery = getIntent().getStringExtra("SEARCH_QUERY");

        String contactNumber = "";
        if (searchQuery != null) {
            // Display the query in a TextView (or any other UI element)
            TextView tirthNameTextView = findViewById(R.id.tirth_name_text_view);  // Ensure this ID exists in your XML
            tirthNameTextView.setText(searchQuery);
        } else {
            TextView heading = findViewById(R.id.tvTirthName);
            WebView youtubePlayer = findViewById(R.id.youtubePlayer);
            TextView locationText = findViewById(R.id.tvLocationText);
            ImageView locationIcon = findViewById(R.id.ivLocationIcon);
            TextView tvDistance = findViewById(R.id.tvDistance);
            TextView tvCallText = findViewById(R.id.tvCallText);
            ImageView ivCallIcon = findViewById(R.id.ivCallIcon);

            String tirthName = getIntent().getStringExtra("tirth_name");
            Log.d("TirthDetails", "Tirth Name: " + tirthName);
            heading.setText(tirthName);

            // Assign values based on tirthName
            switch (tirthName) {
                case "Shankeshwar":
                    videoUrl = "https://www.youtube.com/embed/Uk9sLxolugQ";
                    locationUrl = "https://www.google.com/maps?q=Shankheshwar+Jain+Tirth";
                    contactNumber = "02733-273342 / 02733-273514";
                    break;
                case "Girnar Ji":
                    videoUrl = "https://www.youtube.com/embed/L_ZZkrdGiVQ";
                    locationUrl = "https://www.google.com/maps?q=Girnar+Jain+Tirth";
                    contactNumber = "0285-2621519 / 0285-2627108";
                    break;
                case "Mahudi":
                    videoUrl = "https://www.youtube.com/embed/Cd7zfxqosMo";
                    locationUrl = "https://www.google.com/maps?q=Mahudi+Jain+Tirth";
                    distanceText = "Distance: 65 km from Shankheshwar";
                    contactNumber = "+91-8732991353";
                    break;
                case "Mehsana":
                    videoUrl = "https://www.youtube.com/embed/aCp1TB_Fg5g";
                    locationUrl = "https://www.google.com/maps?q=Mehsana+Jain+Tirth";
                    distanceText = "Distance: 52 km from Shankheshwar";
                    contactNumber = "02762-251674 / 02762-252044";
                    break;
                case "Taleti":
                    videoUrl = "https://www.youtube.com/embed/uWhZiz8nXG0";
                    locationUrl = "https://www.google.com/maps?q=Taleti+Girnar";
                    distanceText = "Distance: 4.5 km from Girnar Ji";
                    contactNumber = "0285-2620059";
                    break;
                case "Songadh Jain Temple":
                    videoUrl = "https://www.youtube.com/embed/kSEEQEcJfFY";
                    locationUrl = "https://www.google.com/maps?q=Songadh+Jain+Tirth";
                    distanceText = "Distance: 24 km from Girnar Ji";
                    contactNumber = "+91-2846-244334 / +91-2846-244358";
                    break;
                case "Nakoda Parshwanath":
                    videoUrl = "https://www.youtube.com/embed/tIRbJ6utcJ0";
                    locationUrl = "https://www.google.com/maps?q=Nakoda+Parshwanath+Jain+Temple";
                    distanceText = "Located in Barmer District, Rajasthan";
                    contactNumber = "1234567890"; // Replace with real number
                    break;

                case "Jirawala":
                    videoUrl = "https://www.youtube.com/embed/fnue-FIgjBo";
                    locationUrl = "https://www.google.com/maps?q=Jirawala+Jain+Temple";
                    distanceText = "Nearby Tirths: Nakoda (78 km), Abu Road (42 km)";
                    contactNumber = "094132 30818";
                    break;

                case "Khajuri":
                    videoUrl = "https://www.youtube.com/embed/KIpHY_7KZ8w";
                    locationUrl = "https://www.google.com/maps?q=Khajuri+Jain+Tirth";
                    distanceText = "Nearby Tirths: Nakoda (40 km)";
                    contactNumber = "098290 12345"; // Placeholder
                    break;

                case "Ranakpur":
                    videoUrl = "https://www.youtube.com/embed/o8Gx2B-O06Y";
                    locationUrl = "https://www.google.com/maps?q=Ranakpur+Jain+Temple";
                    distanceText = "Located in Pali District, Rajasthan";
                    contactNumber = "+91-8696453616";
                    break;

                case "Kumbhalgarh":
                    videoUrl = "https://www.youtube.com/embed/h7xl-AdAJBo";
                    locationUrl = "https://www.google.com/maps?q=Kumbhalgarh+Jain+Temple";
                    distanceText = "Nearby Tirths: Ranakpur (15 km)";
                    contactNumber = "+91-94140-95850";
                    break;

                case "Shree Keshariya Ji Jain Temple":
                    videoUrl = "https://www.youtube.com/embed/N8KKMxnqsck";
                    locationUrl = "https://www.google.com/maps?q=Shree+Keshariya+Ji+Jain+Temple";
                    distanceText = "Located in Rishabhdev, Udaipur District, Rajasthan";
                    contactNumber = "02959-252251 / +91-9829014024";
                    break;

                case "Mangi Tungi":
                    videoUrl = "https://www.youtube.com/embed/M21HhFlD7zM";
                    locationUrl = "https://www.google.com/maps?q=Mangi+Tungi";
                    distanceText = "Located in Nashik District, Maharashtra";
                    contactNumber = "02556 262339";
                    break;

                case "Toranmal":
                    videoUrl = "https://www.youtube.com/embed/A0KMRPX5Jso";
                    locationUrl = "https://www.google.com/maps?q=Toranmal+Jain+Tirth";
                    distanceText = "Mangi Tungi (102 km)";
                    contactNumber = "02569-223366";
                    break;

                case "Kunthalgiri":
                    videoUrl = "https://www.youtube.com/embed/0hjE-5XfWUg";
                    locationUrl = "https://www.google.com/maps?q=Kunthalgiri+Jain+Temple";
                    distanceText = "Located near Beed, Maharashtra";
                    contactNumber = "096732 71111";
                    break;

                case "Rishabhdev":
                    videoUrl = "https://www.youtube.com/embed/2moyX0dACyc";
                    locationUrl = "https://www.google.com/maps?q=Rishabhdev+Jain+Tirth";
                    distanceText = "Nearby Tirths: Kunthalgiri (150 km), Udaipur (60 km)";
                    contactNumber = "+91-0294-2441420";
                    break;

                case "Gajpanth":
                    videoUrl = "https://www.youtube.com/embed/i9ZoZp7YhqQ";
                    locationUrl = "https://www.google.com/maps?q=Gajpanth+Jain+Tirth";
                    distanceText = "Nearby Tirths: Kunthalgiri (60 km)";
                    contactNumber = "+91-2557-220124";
                    break;

                case "Sonagiri Jain Temples":
                    videoUrl = "https://www.youtube.com/embed/yGhxKG2oPk8";
                    locationUrl = "https://www.google.com/maps?q=Sonagiri+Jain+Temples";
                    distanceText = "Nearby Tirths: Gwalior (68 km), Datia (15 km)";
                    contactNumber = "+91-1234-567890"; // Placeholder
                    break;

                case "Kundalpur Jain Temple":
                    videoUrl = "https://www.youtube.com/embed/2moyX0dACyc";
                    locationUrl = "https://www.google.com/maps?q=Kundalpur+Jain+Temple+Madhya+Pradesh";
                    distanceText = "Nearby Tirths: Pateriaji (35 km), Bandakpur (50 km)";
                    contactNumber = "+91-9876-543210";
                    break;

                case "Hastinapur":
                    videoUrl = "https://www.youtube.com/embed/zTttO-bDnpM";
                    locationUrl = "https://www.google.com/maps?q=Hastinapur+Jain+Temple";
                    distanceText = "Nearby Tirths: Meerut (37 km), Kankali Tila (20 km)";
                    contactNumber = "+91-9456-789012"; // Placeholder
                    break;

                case "Deogarh":
                    videoUrl = "https://www.youtube.com/embed/4pXCmMY_89E";
                    locationUrl = "https://www.google.com/maps?q=Deogarh+Jain+Temples+Lalitpur";
                    distanceText = "Nearby Tirths: Chanderi (80 km), Tikamgarh (100 km)";
                    contactNumber = "+91-8765-432109";
                    break;

                case "Pawagiri":
                    videoUrl = "https://www.youtube.com/embed/RiQcPupl5Uo";
                    locationUrl = "https://www.google.com/maps?q=Pawagiri+Jain+Temple";
                    distanceText = "Nearby Tirths: Kundalpur (75 km)";
                    contactNumber = "+91-1234-567891";
                    break;

                case "Bawangaja":
                    videoUrl = "https://www.youtube.com/embed/CpuqorBCbxc";
                    locationUrl = "https://www.google.com/maps?q=Bawangaja+Jain+Temple";
                    distanceText = "Nearby Tirths: Pavagiri (40 km), Barwani (25 km)";
                    contactNumber = "+91-9987-654321";
                    break;

                case "Datia Jain Temples":
                    videoUrl = "https://www.youtube.com/embed/haz0_xPlgbQ";
                    locationUrl = "https://www.google.com/maps?q=Datia+Jain+Temples";
                    distanceText = "Nearby Tirths: Sonagiri (45 km), Jhansi (60 km)";
                    contactNumber = "+91-9001-223344";
                    break;

                case "Chanderi Jain Temple":
                    videoUrl = "https://www.youtube.com/embed/YAhSGiJAyYk";
                    locationUrl = "https://www.google.com/maps?q=Chanderi+Jain+Temple";
                    distanceText = "Nearby Tirths: Deogarh (80 km)";
                    contactNumber = "+91-8888-777766";
                    break;

                case "Parashnath Digambar Jain Temple":
                    videoUrl = "https://www.youtube.com/embed/zjrLRJcYruA";
                    locationUrl = "https://www.google.com/maps?q=Parashnath+Digambar+Jain+Temple+Hastinapur";
                    distanceText = "Nearby Tirths: Hastinapur (8 km) , Located in Jharkhand";
                    contactNumber = "+91-9876-543210";
                    break;

                case "Jambudweep Jain Temple":
                    videoUrl = "https://www.youtube.com/embed/0LTS3upcbJ8";
                    locationUrl = "https://www.google.com/maps?q=Jambudweep+Jain+Temple";
                    distanceText = "Nearby Tirths: Parashnath Temple (6 km)";
                    contactNumber = "+91-8123-456789";
                    break;

                case "Lalitpur Jain Temples":
                    videoUrl = "https://www.youtube.com/embed/9KtlSUcEIbg";
                    locationUrl = "https://www.google.com/maps?q=Lalitpur+Jain+Temples";
                    distanceText = "Nearby Tirths: Deogarh (30 km)";
                    contactNumber = "+91-7878-989898";
                    break;

                case "Parichha Jain Temple":
                    videoUrl = "https://www.youtube.com/embed/zjrLRJcYruA";
                    locationUrl = "https://www.google.com/maps?q=Parichha+Jain+Temple";
                    distanceText = "Nearby Tirths: Jhansi (20 km), Sonagiri (90 km)";
                    contactNumber = "+91-7070-606060";
                    break;
            }

            // Now load YouTube video
            String html = "<iframe width=\"100%\" height=\"200\" src=\"" + videoUrl + "\" frameborder=\"0\" allowfullscreen></iframe>";
            youtubePlayer.getSettings().setJavaScriptEnabled(true);
            youtubePlayer.setWebChromeClient(new WebChromeClient());
            youtubePlayer.loadData(html, "text/html", "utf-8"); //Corrected Line.


            if (!distanceText.isEmpty()) {
                tvDistance.setVisibility(View.VISIBLE);
                tvDistance.setText(distanceText);
            } else {
                tvDistance.setVisibility(View.GONE);
            }

            // Handle location click
            String finalLocationUrl = locationUrl;
            View.OnClickListener locationClickListener = v -> {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(finalLocationUrl));
                intent.setPackage("com.google.android.apps.maps");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(finalLocationUrl)));
                }
            };

            locationText.setOnClickListener(locationClickListener);
            locationIcon.setOnClickListener(locationClickListener);

            TextView dharamshalaText = findViewById(R.id.tvDharamshalaText);
            ImageView dharamshalaIcon = findViewById(R.id.ivDharamshalaIcon);

            View.OnClickListener dharamshalaClickListener = v -> {
                Intent intent = new Intent(TirthDetailsActivity.this, DharamshalaActivity.class);
                intent.putExtra("tirth_name", tirthName);
                startActivity(intent);
            };

            dharamshalaText.setOnClickListener(dharamshalaClickListener);
            dharamshalaIcon.setOnClickListener(dharamshalaClickListener);


            LinearLayout nearbyContainer = findViewById(R.id.nearbyTirthContainer);

            // Sample nearby tirths based on main tirth
            List<NearbyTirth> nearbyTirthList = new ArrayList<>();

            if (tirthName.equals("Shankeshwar")) {
                nearbyTirthList.add(new NearbyTirth("Mahudi", R.drawable.mahudi));
                nearbyTirthList.add(new NearbyTirth("Mehsana", R.drawable.mehsana));
            } else if (tirthName.equals("Girnar Ji")) {
                nearbyTirthList.add(new NearbyTirth("Taleti", R.drawable.taleti));
                nearbyTirthList.add(new NearbyTirth("Songadh Jain Temple", R.drawable.songadh));
            } else if (tirthName.equals("Nakoda Parshwanath")) {
                nearbyTirthList.add(new NearbyTirth("Khajuri", R.drawable.khajuri));
                nearbyTirthList.add(new NearbyTirth("Jirawala", R.drawable.jirawala));
            } else if (tirthName.equals("Ranakpur")) {
                nearbyTirthList.add(new NearbyTirth("Kumbhalgarh", R.drawable.kumbhalgarh));
                nearbyTirthList.add(new NearbyTirth("Shree Keshariya Ji Jain Temple", R.drawable.kesariya));
            } else if (tirthName.equals("Mangi Tungi")) {
                nearbyTirthList.add(new NearbyTirth("Shankeshwar", R.drawable.sankeshwar));
                nearbyTirthList.add(new NearbyTirth("Toranmal", R.drawable.toranmal));
            } else if (tirthName.equals("Kunthalgiri")) {
                nearbyTirthList.add(new NearbyTirth("Gajpanth", R.drawable.gajpanth));
                nearbyTirthList.add(new NearbyTirth("Rishabhdev", R.drawable.rishabhdev));
            } else if (tirthName.equals("Kundalpur Jain Temple")) {
                nearbyTirthList.add(new NearbyTirth("Pawagiri", R.drawable.pawagiri));
                nearbyTirthList.add(new NearbyTirth("Bawangaja", R.drawable.bawangaja));
            } else if (tirthName.equals("Sonagiri Jain Temples")) {
                nearbyTirthList.add(new NearbyTirth("Datia Jain Temples", R.drawable.datia));
                nearbyTirthList.add(new NearbyTirth("Chanderi Jain Temple", R.drawable.chanderi));
            } else if (tirthName.equals("Hastinapur")) {
                nearbyTirthList.add(new NearbyTirth("Parashnath Digambar Jain Temple", R.drawable.parashnath));
                nearbyTirthList.add(new NearbyTirth("Jambudweep Jain Temple", R.drawable.jambudweep));
            } else if (tirthName.equals("Deogarh")) {
                nearbyTirthList.add(new NearbyTirth("Lalitpur Jain Temples", R.drawable.lalitpur));
                nearbyTirthList.add(new NearbyTirth("Parichha Jain Temple", R.drawable.parichha));
            }


// Add views dynamically
            for (NearbyTirth tirth : nearbyTirthList) {
                View view = getLayoutInflater().inflate(R.layout.item_nearby_tirth, null);

                ImageView image = view.findViewById(R.id.nearbyTirthImage);
                TextView name = view.findViewById(R.id.nearbyTirthName);

                image.setImageResource(tirth.getImageResId());
                name.setText(tirth.getName());

                // Click to open same TirthDetailsActivity again for now
                View.OnClickListener clickListener = v -> {
                    Intent intent = new Intent(TirthDetailsActivity.this, TirthDetailsActivity.class);
                    intent.putExtra("tirth_name", tirth.getName());
                    startActivity(intent);
                };

                image.setOnClickListener(clickListener);
                name.setOnClickListener(clickListener);

                nearbyContainer.addView(view);
            }

            // Set text to contactText TextView
            tvCallText.setText("Contact: " + contactNumber);

            // Open dialer on click
            String finalContactNumber = contactNumber;
            View.OnClickListener callClickListener = v -> {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + finalContactNumber));
                try {
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(this, "No dialer app found", Toast.LENGTH_SHORT).show();
                }
            };
            tvCallText.setOnClickListener(callClickListener);
            if (ivCallIcon != null) {
                ivCallIcon.setOnClickListener(callClickListener);
            }
      }
        Log.e("TirthDetailsActivity", "No search query found!");
    }
}
