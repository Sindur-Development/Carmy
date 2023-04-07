package com.sindurdevelopment.carmy.services;

import com.sindurdevelopment.carmy.httprequest.HttpRequest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Temperature extends EndPoint {


    public Temperature() throws MalformedURLException {
    }

    public com.sindurdevelopment.carmy.responsemodels.temperature.Temperature getTemperature() throws IOException, InterruptedException {
        return objectMapper.readValue(
                httpRequest.createRequest(VIN + "/environment"), com.sindurdevelopment.carmy.responsemodels.temperature.Temperature.class);
    }

}
