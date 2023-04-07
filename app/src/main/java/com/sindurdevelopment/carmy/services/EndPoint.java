package com.sindurdevelopment.carmy.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sindurdevelopment.carmy.httprequest.HttpRequest;

import java.net.MalformedURLException;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class EndPoint {
    public ObjectMapper objectMapper = new ObjectMapper();
    public  HttpRequest httpRequest = new HttpRequest();
    public String VIN = "";

    public EndPoint() throws MalformedURLException {
    }
}
