package com.sindurdevelopment.carmy.services;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sindurdevelopment.carmy.entities.Vehicle;
import com.sindurdevelopment.carmy.httprequest.HttpRequest;
import com.sindurdevelopment.carmy.responsemodels.vehiclelist.VehicleList;
import java.io.IOException;
import java.net.MalformedURLException;


public class VehicleManager  {

    public static Vehicle currentVehicle;

    public static VehicleList vehicleList;

    public static ObjectMapper objectMapper = new ObjectMapper();

    // private Odometer odometer; fixa todo

    // private OdometerRepsonse todo

    public VehicleManager() throws MalformedURLException {
    }




    public static void startVehicleManager() throws IOException, InterruptedException {
        //TODO skapa lösning för flera VIN's
        getAccountVehicleList();
        currentVehicle = (new Vehicle(vehicleList.getData().get(0).getVin()));
        EndPoint.VIN = currentVehicle.getVIN();
    }


    public static void updateVehicle() throws IOException, InterruptedException {
        //get odometer todo
        FuelLevel fuelLevel = new FuelLevel();
        com.sindurdevelopment.carmy.responsemodels.fuellevel.FuelLevel fuelLevelResponse = fuelLevel.getFuelLevel();
        Temperature temperature = new Temperature();
        com.sindurdevelopment.carmy.responsemodels.temperature.Temperature temperatureResponse = temperature.getTemperature();
        EngineDiagnostic engineDiagnostic = new EngineDiagnostic();
        com.sindurdevelopment.carmy.responsemodels.enginediagnostic.EngineDiagnostic engineDiagnosticResponse = engineDiagnostic.updateEngineDiagnostic();
    }
    

    public static void getAccountVehicleList() throws IOException, InterruptedException {
        vehicleList = (objectMapper.readValue(
                HttpRequest.createRequest(""),
                VehicleList.class));

    }

}
