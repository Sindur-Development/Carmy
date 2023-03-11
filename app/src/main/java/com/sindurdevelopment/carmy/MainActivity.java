package com.sindurdevelopment.carmy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;

import java.net.MalformedURLException;

public class MainActivity extends AppCompatActivity {
    private VehicleManager vehicleManager;

    public MainActivity() throws MalformedURLException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        Button vehicleList = (Button) findViewById(R.id.vehicleList);
        vehicleList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    vehicleManager = new VehicleManager();;
                } catch (Exception e) {
                    System.out.println("Fel30 (skapa vehicleList): " + e);
                }
            }
        });

        Button tempButton = (Button) findViewById(R.id.temp);
        tempButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    System.out.println(vehicleManager.getTemperature());
                } catch (Exception e) {
                    System.out.println("Fel30 (skapa vehicleList): " + e);
                }
            }
        });

        Button accessibiltyButton = (Button) findViewById(R.id.accessibility);
        accessibiltyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    System.out.println(vehicleManager.getVehicleInformation());
                } catch (Exception e) {
                    System.out.println("Fel56 (Vehicle information): " + e);
                }
            }
        });
    }
}