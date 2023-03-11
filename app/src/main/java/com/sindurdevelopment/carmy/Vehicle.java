package com.sindurdevelopment.carmy;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vehicle {

    private String name;
    private String VIN;

    @JsonProperty("engineRunning")
    private String engineRunning;

    @JsonProperty("oilPressure")
    private String oilPressure;

    @JsonProperty("oilLevel")
    private String oilLevel;

    @JsonProperty("engineCoolantLevel")
    private String engineCoolantLevel;

    @JsonProperty("engineCoolantTemp")
    private int engineCoolantTemp;

    public Vehicle(String VIN) {
        this.VIN = VIN;
        name="";
    }

    public Vehicle(String engineRunning, String oilPressure, String oilLevel, String engineCoolantLevel, int engineCoolantTemp) {
        this.engineRunning = engineRunning;
        this.oilPressure = oilPressure;
        this.oilLevel = oilLevel;
        this.engineCoolantLevel = engineCoolantLevel;
        this.engineCoolantTemp = engineCoolantTemp;
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

    private String getEngineRunning() {
        return engineRunning;
    }

    private void setEngineRunning(String engineRunning) {
        this.engineRunning = engineRunning;
    }

    private String getOilPressure() {
        return oilPressure;
    }

    private void setOilPressure(String oilPressure) {
        this.oilPressure = oilPressure;
    }

    private String getOilLevel() {
        return oilLevel;
    }

    private void setOilLevel(String oilLevel) {
        this.oilLevel = oilLevel;
    }

    private String getEngineCoolantLevel() {
        return engineCoolantLevel;
    }

    private void setEngineCoolantLevel(String engineCoolantLevel) {
        this.engineCoolantLevel = engineCoolantLevel;
    }

    private int getEngineCoolantTemp() {
        return engineCoolantTemp;
    }

    private void setEngineCoolantTemp(int engineCoolantTemp) {
        this.engineCoolantTemp = engineCoolantTemp;
    }
}
