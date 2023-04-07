package com.sindurdevelopment.carmy.services;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sindurdevelopment.carmy.entities.Vehicle;
import com.sindurdevelopment.carmy.httprequest.HttpRequest;
import com.sindurdevelopment.carmy.responsemodels.vehiclelist.VehicleList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class VehicleManager implements Parcelable {

    private Vehicle currentVehicle;
    private VehicleList vehicleList = new VehicleList();

    private EngineDiagnostic engineDiagnostic = new EngineDiagnostic();

    private com.sindurdevelopment.carmy.responsemodels.enginediagnostic.EngineDiagnostic engineDiagnosticResponse;

    private FuelLevel fuelLevel = new FuelLevel();

    private com.sindurdevelopment.carmy.responsemodels.fuellevel.FuelLevel fuelLevelResponse = new com.sindurdevelopment.carmy.responsemodels.fuellevel.FuelLevel();

    // private Odometer odometer; fixa todo

    // private OdometerRepsonse todo

    private Statistic statistic = new Statistic();

    private Temperature temperature = new Temperature();

    private com.sindurdevelopment.carmy.responsemodels.temperature.Temperature temperatureResponse = new com.sindurdevelopment.carmy.responsemodels.temperature.Temperature();
    private ObjectMapper objectMapper = new ObjectMapper();;
    private HttpRequest httpRequest = new HttpRequest();

    public VehicleManager() throws MalformedURLException {
    }

    protected VehicleManager(Parcel in) throws MalformedURLException {
    }

    public static final Creator<VehicleManager> CREATOR = new Creator<VehicleManager>() {
        @Override
        public VehicleManager createFromParcel(Parcel in) {
            try {
                return new VehicleManager(in);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public VehicleManager[] newArray(int size) {
            return new VehicleManager[size];
        }
    };

    public void startVehicleManager() throws IOException, InterruptedException {
        //TODO skapa lösning för flera VIN's
        getAccountVehicleList();
        this.currentVehicle = (new Vehicle(vehicleList.getData().get(0).getVin()));
        EndPoint.VIN = currentVehicle.getVIN();
        updateVehicle();
    }


    public void updateVehicle() throws IOException, InterruptedException {
        //get odometer todo
        fuelLevelResponse = fuelLevel.getFuelLevel();
        temperatureResponse = temperature.getTemperature();
        engineDiagnosticResponse = engineDiagnostic.updateEngineDiagnostic();
    }



    public void getAccountVehicleList() throws IOException, InterruptedException {
        vehicleList = (objectMapper.readValue(
                httpRequest.createRequest(""),
                VehicleList.class));

    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
    }

    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }

    public void setCurrentVehicle(Vehicle currentVehicle) {
        this.currentVehicle = currentVehicle;
    }

    public VehicleList getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(VehicleList vehicleList) {
        this.vehicleList = vehicleList;
    }

    public EngineDiagnostic getEngineDiagnostic() {
        return engineDiagnostic;
    }

    public void setEngineDiagnostic(EngineDiagnostic engineDiagnostic) {
        this.engineDiagnostic = engineDiagnostic;
    }

    public com.sindurdevelopment.carmy.responsemodels.enginediagnostic.EngineDiagnostic getEngineDiagnosticResponse() {
        return engineDiagnosticResponse;
    }

    public void setEngineDiagnosticResponse(com.sindurdevelopment.carmy.responsemodels.enginediagnostic.EngineDiagnostic engineDiagnosticResponse) {
        this.engineDiagnosticResponse = engineDiagnosticResponse;
    }

    public FuelLevel getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(FuelLevel fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public com.sindurdevelopment.carmy.responsemodels.fuellevel.FuelLevel getFuelLevelResponse() {
        return fuelLevelResponse;
    }

    public void setFuelLevelResponse(com.sindurdevelopment.carmy.responsemodels.fuellevel.FuelLevel fuelLevelResponse) {
        this.fuelLevelResponse = fuelLevelResponse;
    }

    public Statistic getStatistic() {
        return statistic;
    }

    public void setStatistic(Statistic statistic) {
        this.statistic = statistic;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public com.sindurdevelopment.carmy.responsemodels.temperature.Temperature getTemperatureResponse() {
        return temperatureResponse;
    }

    public void setTemperatureResponse(com.sindurdevelopment.carmy.responsemodels.temperature.Temperature temperatureResponse) {
        this.temperatureResponse = temperatureResponse;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public HttpRequest getHttpRequest() {
        return httpRequest;
    }

    public void setHttpRequest(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
    }
}
