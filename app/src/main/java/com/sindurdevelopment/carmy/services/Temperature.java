package com.sindurdevelopment.carmy.services;

import java.io.IOException;
import java.net.MalformedURLException;

public class Temperature extends EndPoint {


    public Temperature() throws MalformedURLException {
    }

    public com.sindurdevelopment.carmy.responsemodels.temperature.Temperature getTemperature() throws IOException, InterruptedException {
        return objectMapper.readValue(
                httpRequest.createRequest(VIN + "/environment"), com.sindurdevelopment.carmy.responsemodels.temperature.Temperature.class);
    }

}
