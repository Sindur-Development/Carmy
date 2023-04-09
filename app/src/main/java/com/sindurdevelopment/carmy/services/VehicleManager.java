package com.sindurdevelopment.carmy.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sindurdevelopment.carmy.entities.Vehicle;
import com.sindurdevelopment.carmy.httprequest.HttpRequest;

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
    }


    public static void updateVehicle() throws IOException, InterruptedException {
        //get odometer todo

    }


    public static void setVehicleVIN() throws IOException, InterruptedException, JSONException {
        json = new JSONObject(HttpRequest.createRequest(""));
        //fixa konto med flera bilar todo
        EndPoint.VIN = json.getJSONArray("data").getJSONObject(0).getString("vin");
    }

}
