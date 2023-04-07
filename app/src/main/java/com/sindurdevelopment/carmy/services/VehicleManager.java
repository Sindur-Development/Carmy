package com.sindurdevelopment.carmy.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sindurdevelopment.carmy.entities.Vehicle;
import com.sindurdevelopment.carmy.httprequest.HttpRequest;
import com.sindurdevelopment.carmy.responsemodels.vehiclelist.VehicleList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@NoArgsConstructor
public class VehicleManager {

    private Vehicle currentVehicle;
    private VehicleList vehicleList;

    private EngineDiagnostic engineDiagnostic;

    private com.sindurdevelopment.carmy.responsemodels.enginediagnostic.EngineDiagnostic engineDiagnosticResponse;

    private FuelLevel fuelLevel;

    private com.sindurdevelopment.carmy.responsemodels.fuellevel.FuelLevel fuelLevelResponse;

    // private Odometer odometer; fixa todo

    // private OdometerRepsonse todo

    private Statistic statistic;

    private EndPoint endPoint;
    private Temperature temperature;

    private com.sindurdevelopment.carmy.responsemodels.temperature.Temperature temperatureResponse;
    private ObjectMapper objectMapper;
    private HttpRequest httpRequest;

    public void startVehicleManager() throws IOException, InterruptedException {
        objectMapper = new ObjectMapper();
        //TODO skapa lösning för flera VIN's
        getAccountVehicleList();
        this.currentVehicle = (new Vehicle(vehicleList.getData().get(0).getVin()));
        endPoint.VIN = currentVehicle.getVIN();
    }


    public void updateVehicle() throws IOException, InterruptedException {
        //get odometer todo
        fuelLevelResponse = fuelLevel.getFuelLevel();
        temperatureResponse = temperature.getTemperature();
        engineDiagnosticResponse = engineDiagnostic.updateEngineDiagnostic();
    }



    public void getAccountVehicleList() throws IOException, InterruptedException {
        this.vehicleList = (objectMapper.readValue(
                httpRequest.createRequest(new URL("")),
                VehicleList.class));

    }





}
