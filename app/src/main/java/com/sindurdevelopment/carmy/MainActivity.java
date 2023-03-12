package com.sindurdevelopment.carmy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
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

        try {
            vehicleManager = new VehicleManager();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            vehicleManager.updateVehicle();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        TextView tempData = findViewById(R.id.tempData);
//        Button vehicleInformationBTN = (Button) findViewById(R.id.vehicleInformation);
//        vehicleInformationBTN.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                try {
//                    vehicleManager = new VehicleManager();
//                    tempData.setText(vehicleManager.getTemperature());
//                } catch (Exception e) {
//                    System.out.println("Fel30 (skapa vehicleList): " + e);
//                }
//            }
//        });


    }
}