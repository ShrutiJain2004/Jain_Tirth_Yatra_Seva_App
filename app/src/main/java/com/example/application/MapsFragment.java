package com.example.application;

import android.annotation.SuppressLint;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MapsFragment extends Fragment implements OnMapReadyCallback {

    private EditText addressEditText;
    private Spinner radiusSpinner;
    private GoogleMap mMap;

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_maps, container, false);

        // Heading and Subheading
        TextView headingTextView = view.findViewById(R.id.mapHeadingTextView);
        TextView subheadingTextView = view.findViewById(R.id.mapSubheadingTextView);
        headingTextView.setText("Map");
        subheadingTextView.setText("Find Tirth's In Jatra Route");

        // EditText Initialization
        addressEditText = view.findViewById(R.id.addressEditText);

        Button searchButton = view.findViewById(R.id.searchButton);
        searchButton.setOnClickListener(v -> {
            String location = addressEditText.getText().toString();
            if (!location.isEmpty()) {
                Geocoder geocoder = new Geocoder(getContext(), Locale.getDefault());
                try {
                    List<Address> addresses = geocoder.getFromLocationName(location, 1);
                    if (addresses != null && !addresses.isEmpty()) {
                        Address address = addresses.get(0);
                        LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                        mMap.addMarker(new MarkerOptions().position(latLng).title(location));
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10f));
                    } else {
                        Toast.makeText(getContext(), "Location not found", Toast.LENGTH_SHORT).show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(getContext(), "Error finding location", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getContext(), "Please enter a location", Toast.LENGTH_SHORT).show();
            }
        });


        // Spinner Initialization
        radiusSpinner = view.findViewById(R.id.radiusSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getContext(),
                R.array.radius_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        radiusSpinner.setAdapter(adapter);

        radiusSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    Toast.makeText(getContext(), "Selected: " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Load the map
        SupportMapFragment mapFragment = new SupportMapFragment();
        getChildFragmentManager().beginTransaction()
                .replace(R.id.mapContainer, mapFragment)
                .commit();

        mapFragment.getMapAsync(this);

        return view;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        // Add multiple tirth locations
        List<LatLng> tirthLocations = Arrays.asList(
                new LatLng(21.5195, 71.8236), // Palitana
                new LatLng(24.2487, 86.2831), // Shikharji
                new LatLng(21.5155, 70.5118), // Girnarji
                new LatLng(25.0213, 85.5385),  // Pavapuri
                new LatLng(23.3545, 74.6399),  //Sankeshwar
                new LatLng(23.2579, 75.0078), // Antriksh Parshwanath
                new LatLng(25.6457, 73.6057), // Keshariya Ji
                new LatLng(26.9843, 72.3815) // Nakoda Ji

        );

        List<String> tirthNames = Arrays.asList(
                "Palitana",
                "Shikharji",
                "Girnarji",
                "Pavapuri",
                "Sankeshwar",
                "Antriksh Parshwanath",
                "Keshariya Ji",
                "Nakoda Ji"

        );

        // Add markers for each tirth
        for (int i = 0; i < tirthLocations.size(); i++) {
            mMap.addMarker(new MarkerOptions()
                    .position(tirthLocations.get(i))
                    .title(tirthNames.get(i)));
        }

        // Move camera to center India
        LatLng centerIndia = new LatLng(23.5937, 80.9629);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centerIndia, 5.5f));
    }
}
