package com.gzeinnumer.cuurentlocationonehit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.gzeinnumer.cuurentlocationonehit.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initOneHit();
//        initInterval();
    }

    private GetCurrentLocationInterval currentLocationInterval;
    private void initInterval() {
        currentLocationInterval = new GetCurrentLocationInterval(MainActivity.this, this::updateLocationUIInterval);
        binding.btnStartUpdates.setOnClickListener(view -> {
            currentLocationInterval.startLocationUpdates();
        });
    }

    private void updateLocationUIInterval() {
        if (currentLocationInterval.getmCurrentLocation() != null) {
            binding.txtLocationResult.setText("Lat: " + currentLocationInterval.getmCurrentLocation().getLatitude() + ", " + "Lng: " + currentLocationInterval.getmCurrentLocation().getLongitude() + "\n"+ currentLocationInterval.getmLastUpdateTime());

            // giving a blink animation on TextView
            binding.txtLocationResult.setAlpha(0);
            binding.txtLocationResult.animate().alpha(1).setDuration(300);
        }
    }

    private GetCurrentLocationOneHit currentLocationOneHit;
    private void initOneHit() {
        currentLocationOneHit = new GetCurrentLocationOneHit(MainActivity.this, this::updateLocationUIOneHit);
        binding.btnStartUpdates.setOnClickListener(view -> {
            currentLocationOneHit.startLocationUpdates();
        });
    }

    private void updateLocationUIOneHit() {
        if (currentLocationOneHit.getmCurrentLocation() != null) {
            binding.txtLocationResult.setText("Lat: " + currentLocationOneHit.getmCurrentLocation().getLatitude() + ", " + "Lng: " + currentLocationOneHit.getmCurrentLocation().getLongitude());

            // giving a blink animation on TextView
            binding.txtLocationResult.setAlpha(0);
            binding.txtLocationResult.animate().alpha(1).setDuration(300);
        }
    }
}