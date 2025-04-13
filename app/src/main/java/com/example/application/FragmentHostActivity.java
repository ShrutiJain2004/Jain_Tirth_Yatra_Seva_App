package com.example.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
public class FragmentHostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_host);

        // Get the fragment class from the intent
        String fragmentName = getIntent().getStringExtra("FRAGMENT_NAME");

        // Load the selected fragment dynamically
        Fragment fragment = null;
        try {
            Class<?> fragmentClass = Class.forName(fragmentName);
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}
