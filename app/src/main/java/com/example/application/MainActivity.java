package com.example.application;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.application.R;
import android.widget.ImageView;
import android.widget.Toast;
import android.view.View;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private Spinner countrySpinner;
    private EditText searchBar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences preferences = getSharedPreferences("UserPreferences", MODE_PRIVATE);
        boolean isDarkMode = preferences.getBoolean("isDarkMode", false);
        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the ImageView for Palitana
        ImageView palitanaImage = findViewById(R.id.img_palitana);

        // Set a click listener to open TirthDetailsActivity
        palitanaImage.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PalitanaActivity.class);
            startActivity(intent);
        });

        ImageView shikharjiImage = findViewById(R.id.img_shikharji);
        shikharjiImage.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ShikharjiActivity.class);
            startActivity(intent);
        });

        ImageView girnarjiImage = findViewById(R.id.img_girnarji);
        girnarjiImage.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, GirnarjiActivity.class);
            startActivity(intent);
        });

        ImageView pavapuriImage = findViewById(R.id.img_pavapuri);
        pavapuriImage.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PavapuriActivity.class);
            startActivity(intent);
        });

        //Find and set click listeners for Bhajan and Stavan
        ImageView stavanLyricsImage = findViewById(R.id.img_stavan_lyrics);
        stavanLyricsImage.setOnClickListener(v -> {
            // Handle Stavan Lyrics click (e.g., open a new activity)
            Intent intent = new Intent(MainActivity.this, StavanLyricsActivity.class);
            startActivity(intent);
        });

        ImageView aartiImage = findViewById(R.id.img_aarti);
        aartiImage.setOnClickListener(v -> {
            // Handle Aarti click
            Intent intent = new Intent(MainActivity.this, AartiActivity.class);
            startActivity(intent);
        });

        ImageView audioStavanImage = findViewById(R.id.img_audio_stavan);
        audioStavanImage.setOnClickListener(v -> {
            // Handle Audio Stavan click
            Intent intent = new Intent(MainActivity.this, AudioStavanActivity.class);
            startActivity(intent);
        });

        ImageView videoStavanImage = findViewById(R.id.img_video_stavan);
        videoStavanImage.setOnClickListener(v -> {
            // Handle Video Stavan click
            Intent intent = new Intent(MainActivity.this, VideoStavanActivity.class);
            startActivity(intent);
        });


        // Find and set click listeners for Mantras
        ImageView navkarImage = findViewById(R.id.img_navkar);
        navkarImage.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Navkar1.class);
            startActivity(intent);
        });

        ImageView bhaktambarImage = findViewById(R.id.img_bhaktambar);
        bhaktambarImage.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, BhaktambarActivity.class);
            startActivity(intent);
        });

        ImageView manglikImage = findViewById(R.id.img_manglik);
        manglikImage.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ManglikActivity.class);
            startActivity(intent);
        });

        ImageView namuthunamImage = findViewById(R.id.img_namuthunam);
        namuthunamImage.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Namuthunam.class);
            startActivity(intent);
        });

        ImageView uvasagaramImage = findViewById(R.id.img_uvasagaram);
        uvasagaramImage.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, UvasagaramActivity.class);
            startActivity(intent);
        });


        LinearLayout panchTirthiContainer = findViewById(R.id.panch_tirthi_container);
        int[] stateImages = {R.drawable.gujarat, R.drawable.rajasthan, R.drawable.maharashtra, R.drawable.madhya_pradesh, R.drawable.uttar_pradesh};
        String[] stateNames = {"Gujarat", "Rajasthan", "Maharashtra", "Madhya Pradesh", "Uttar Pradesh"};

        for (int i = 0; i < stateNames.length; i++) {
            LinearLayout stateLayout = new LinearLayout(this);
            stateLayout.setOrientation(LinearLayout.VERTICAL);
            stateLayout.setGravity(Gravity.CENTER);
            stateLayout.setPadding(8, 8, 8, 8);

            ImageView stateImage = new ImageView(this);
            stateImage.setLayoutParams(new ViewGroup.LayoutParams(800, 400));
            stateImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
            stateImage.setImageResource(stateImages[i]);
            stateImage.setBackgroundResource(R.drawable.image_border); // Optional border

            TextView stateText = new TextView(this);
            stateText.setText(stateNames[i]);
            stateText.setGravity(Gravity.CENTER);
            stateText.setTextSize(16);
            stateText.setTypeface(null, Typeface.BOLD);

            stateLayout.addView(stateImage);
            stateLayout.addView(stateText);
            panchTirthiContainer.addView(stateLayout);

            // Click event to open new window
            final String selectedState = stateNames[i];
            stateImage.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, PanchTirthiDetailsActivity.class);
                intent.putExtra("STATE_NAME", selectedState);
                startActivity(intent);
            });
        }


        // Initialize Search Bar
        EditText searchBar = findViewById(R.id.search_bar);

        searchBar.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                    (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN)) {
                String query = searchBar.getText().toString().trim().toLowerCase();
                handleSearch(query);
                return true;
            }
            return false;
        });


        // Initialize Country Dropdown
        countrySpinner = findViewById(R.id.country_spinner);
        String[] countries = {"Countries", "India", "Thailand", "Pakistan"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, countries);
        countrySpinner.setAdapter(adapter);

        // Handle Country Selection
        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1:
                        startActivity(new Intent(MainActivity.this, IndiaActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, ThailandActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, PakistanActivity.class));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        // Set Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Jain Tirth Yatra");

        // Example button click listeners
        findViewById(R.id.btn_stutis_stavans).setOnClickListener(v -> openWindow(StutisStavansActivity.class));
        findViewById(R.id.btn_learning_jainism).setOnClickListener(v -> openWindow(LearningJainismActivity.class));
        findViewById(R.id.btn_pachkhan).setOnClickListener(v -> openWindow(PachkhanActivity.class));


        // Initialize Drawer Layout and Toggle Button
        drawerLayout = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Activate Marquee Effect
        TextView marqueeText = findViewById(R.id.marqueeText);
        marqueeText.setSelected(true);

        // Handle Navigation Drawer Clicks
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.nav_calendar) {
                openFragmentInNewWindow(CalendarFragment.class);
            } else if (itemId == R.id.nav_donation) {
                openFragmentInNewWindow(DonationFragment.class);
            } else if (itemId == R.id.nav_einvite) {
                openFragmentInNewWindow(EInviteFragment.class);
            } else if (itemId == R.id.nav_dream_analyzer) {
                openFragmentInNewWindow(DreamAnalyzerFragment.class);
            } else if (itemId == R.id.nav_about_us) {
                openFragmentInNewWindow(AboutUsFragment.class);
            } else if (itemId == R.id.nav_contact) {
                openFragmentInNewWindow(ContactFragment.class);
            } else if (itemId == R.id.nav_profile) {
                openFragmentInNewWindow(ProfileFragment.class);
            } else if (itemId == R.id.nav_help) {
                openFragmentInNewWindow(HelpFragment.class);
            } else if (itemId == R.id.nav_share) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Check out this app!");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey! Check out this amazing Jain Tirth Yatra app: https://play.google.com/store/apps/details?id=com.example.yourapp");

                startActivity(Intent.createChooser(shareIntent, "Share via"));
                return true;
            } else if (itemId == R.id.nav_settings) {
                openFragmentInNewWindow(SettingsFragment.class);
            } else if (itemId == R.id.nav_logout) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                return true;
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });

        // Handle Bottom Navigation Clicks
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.nav_home) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                return true;
            } else if (itemId == R.id.nav_maps) {
                openFragmentInNewWindow(MapsFragment.class);
            } else if (itemId == R.id.nav_ocr) {
                openFragmentInNewWindow(OCRFragment.class);
            } else if (itemId == R.id.nav_jreels) {
                openFragmentInNewWindow(JReelsFragment.class);
            } else if (itemId == R.id.nav_jatra) {
                openFragmentInNewWindow(JatraFragment.class);
            }
            return true;
        });
    }

    // Function to Load Fragments
    private void openFragmentInNewWindow(Class<?> fragmentClass) {
        Intent intent = new Intent(MainActivity.this, FragmentHostActivity.class);
        intent.putExtra("FRAGMENT_NAME", fragmentClass.getName());
        startActivity(intent);
    }


    // Function to Open a New Activity
    private void openWindow(Class<?> activityClass) {
        Intent intent = new Intent(MainActivity.this, activityClass);
        startActivity(intent);
    }

    private void handleSearch(String query) {
        Log.d("Search", "Query: " + query); // Log search query for debugging

        HashMap<String, Class<?>> searchMap = new HashMap<>();

        // 🔍 Bhavyatra Tirths
        searchMap.put("palitana", TirthDetailsActivity.class);
        searchMap.put("shikharji", TirthDetailsActivity.class);
        searchMap.put("girnarji", TirthDetailsActivity.class);
        searchMap.put("pavapuri", TirthDetailsActivity.class);

        // 🔍 Power of Mantras
        searchMap.put("navkar mantra", NavkarMantraActivity.class);
        searchMap.put("bhaktambar", BhaktambarActivity.class);
        searchMap.put("manglik", ManglikActivity.class);
        searchMap.put("namuthunam", Namuthunam.class);
        searchMap.put("uvasagaram", UvasagaramActivity.class);

        // 🔍 Panch Tirthi States
        searchMap.put("gujarat", PanchTirthiDetailsActivity.class);
        searchMap.put("rajasthan", PanchTirthiDetailsActivity.class);
        searchMap.put("maharashtra", PanchTirthiDetailsActivity.class);
        searchMap.put("madhya pradesh", PanchTirthiDetailsActivity.class);
        searchMap.put("uttar pradesh", PanchTirthiDetailsActivity.class);

        // 🔍 Some extra tirths
        searchMap.put("sonagiri", TirthDetailsActivity.class);
        searchMap.put("kundalpur", TirthDetailsActivity.class);
        searchMap.put("hastinapur", TirthDetailsActivity.class);
        searchMap.put("deogarh", TirthDetailsActivity.class);

        // You can add more items...

        for (String key : searchMap.keySet()) {
            if (key.toLowerCase().contains(query.toLowerCase())) {
                Log.d("Search", "Found match: " + key); // Log if match found

                try {
                    Intent intent = new Intent(MainActivity.this, searchMap.get(key));
                    intent.putExtra("SEARCH_QUERY", key);
                    startActivity(intent);
                    return;
                } catch (Exception e) {
                    Log.e("Search", "Error starting activity: ", e); // Log any errors
                }
            }
        }

        Toast.makeText(this, "No results found", Toast.LENGTH_SHORT).show();
    }

}