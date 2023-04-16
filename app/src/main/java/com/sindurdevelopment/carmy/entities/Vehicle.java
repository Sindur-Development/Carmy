package com.sindurdevelopment.carmy.entities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class Vehicle {

    private String name;
    private String VIN;

    private String lastCommandId;
    private JSONObject doors;
    private JSONObject windows;
    private JSONObject odometer;
    private JSONObject fuellevel;
    private JSONObject vehicleDetails;

    public void saveImage(String imageUrl, String destinationFile) throws IOException, InterruptedException {
        if (imageUrl == "") return;
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    URL url = new URL(imageUrl);
                    Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                } catch (Exception e) {
                    System.out.println("Error 44: " + e);
                }
            }
        });
        thread.start();
        thread.join();
    }


    public Vehicle(String VIN) {
        this.VIN = VIN;
        name = "";
    }

    public Vehicle(String name, String VIN) {
        this.name = name;
        this.VIN = VIN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public JSONObject getDoors() {
        return doors;
    }

    public void setDoors(JSONObject doors) {
        this.doors = doors;
    }

    public JSONObject getWindows() {
        return windows;
    }

    public void setWindows(JSONObject windows) {
        this.windows = windows;
    }

    public JSONObject getOdometer() {
        return odometer;
    }

    public void setOdometer(JSONObject odometer) {
        this.odometer = odometer;
    }

    public JSONObject getFuellevel() {
        return fuellevel;
    }

    public void setFuellevel(JSONObject fuellevel) {
        this.fuellevel = fuellevel;
    }

    public String getLastCommandId() {
        return lastCommandId;
    }

    public void setLastCommandId(String lastCommandId) {
        this.lastCommandId = lastCommandId;
    }

    public JSONObject getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(JSONObject vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }
}
