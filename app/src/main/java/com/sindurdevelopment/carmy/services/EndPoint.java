package com.sindurdevelopment.carmy.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sindurdevelopment.carmy.httprequest.HttpRequest;
import java.net.MalformedURLException;

public class EndPoint {
    public ObjectMapper objectMapper = new ObjectMapper();
    public  HttpRequest httpRequest = new HttpRequest();
    public static String VIN = "";

    public EndPoint() throws MalformedURLException {
    }
}
