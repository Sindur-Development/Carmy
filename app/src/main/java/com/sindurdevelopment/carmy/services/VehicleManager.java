package com.sindurdevelopment.carmy.services;

import com.sindurdevelopment.carmy.entities.Vehicle;
import com.sindurdevelopment.carmy.httprequest.HttpRequest;
import com.sindurdevelopment.carmy.services.status.Doors;
import com.sindurdevelopment.carmy.services.status.VehicleDetails;
import com.sindurdevelopment.carmy.services.status.Windows;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.net.MalformedURLException;


public class VehicleManager {

    public static Vehicle currentVehicle;
    public static JSONObject json;

    // private Odometer odometer; fixa todo

    // private OdometerRepsonse todo

    public VehicleManager() throws MalformedURLException {
    }


    public static void startVehicleManager() throws IOException, InterruptedException, JSONException {
        //TODO skapa lösning för flera VIN's
        setVehicleVIN();
        updateVehicle();

    }


    public static void updateVehicle() throws IOException, InterruptedException, JSONException {

        //get odometer todo
        currentVehicle.setDoors(Doors.getDoorStatus());
        currentVehicle.setWindows(Windows.getWindowStatus());
        currentVehicle.setVehicleDetails(VehicleDetails.getVehicleDetails());
        currentVehicle.saveImage(currentVehicle.getVehicleDetails()
                .getJSONObject("data")
                .getJSONObject("images")
                .getString("exteriorDefaultUrl"),"../res/drawable/car_background.jpg");
    }


    public static void setVehicleVIN() throws IOException, InterruptedException, JSONException {
        json = new JSONObject(HttpRequest.createGetRequest("","vehiclelist"));
        //fixa konto med flera bilar todo
        currentVehicle = new Vehicle(json.getJSONArray("data").getJSONObject(0).getString("vin"));
        EndPoint.VIN = currentVehicle.getVIN();
    }

}
