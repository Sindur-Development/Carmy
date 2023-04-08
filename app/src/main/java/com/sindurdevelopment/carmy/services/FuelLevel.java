package com.sindurdevelopment.carmy.services;

import java.io.IOException;
import java.net.MalformedURLException;


public class FuelLevel extends EndPoint {
    public FuelLevel() throws MalformedURLException {
    }

    public com.sindurdevelopment.carmy.responsemodels.fuellevel.FuelLevel getFuelLevel() throws IOException, InterruptedException {
        return objectMapper.readValue(
                httpRequest.createRequest(VIN +"/fuel"), com.sindurdevelopment.carmy.responsemodels.fuellevel.FuelLevel.class);

    }
}
