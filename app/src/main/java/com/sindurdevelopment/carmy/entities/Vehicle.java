package com.sindurdevelopment.carmy.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sindurdevelopment.carmy.responsemodels.enginediagnostic.EngineDiagnostic;
import com.sindurdevelopment.carmy.responsemodels.fuellevel.FuelLevel;
import com.sindurdevelopment.carmy.responsemodels.temperature.Temperature;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor
public class Vehicle {

    private String name;
    private String VIN;
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




}
