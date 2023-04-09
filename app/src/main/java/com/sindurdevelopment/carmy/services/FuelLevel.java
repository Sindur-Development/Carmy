package com.sindurdevelopment.carmy.services;

import com.sindurdevelopment.carmy.httprequest.HttpRequest;

import java.io.IOException;
import java.net.MalformedURLException;


public class FuelLevel extends EndPoint {
    public FuelLevel() throws MalformedURLException {
    }

    public String getFuelLevel() throws IOException, InterruptedException {
        return HttpRequest.createRequest(VIN +"/fuel");

    }
}
