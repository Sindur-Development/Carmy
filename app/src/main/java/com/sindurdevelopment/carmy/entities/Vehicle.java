package com.sindurdevelopment.carmy.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sindurdevelopment.carmy.responsemodels.enginediagnostic.EngineDiagnostic;
import com.sindurdevelopment.carmy.responsemodels.fuellevel.FuelLevel;
import com.sindurdevelopment.carmy.responsemodels.temperature.Temperature;


public class Vehicle {

    private String name;
    private String VIN;

    private EngineDiagnostic engineDiagnostic;

    private FuelLevel fuelLevel;

    private Temperature temperature;

    public Vehicle(String VIN) {
        this.VIN = VIN;
        name="";
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

    public EngineDiagnostic getEngineDiagnostic() {
        return engineDiagnostic;
    }

    public void setEngineDiagnostic(EngineDiagnostic engineDiagnostic) {
        this.engineDiagnostic = engineDiagnostic;
    }

    public FuelLevel getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(FuelLevel fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }
}
