package com.sindurdevelopment.carmy.services;

import com.sindurdevelopment.carmy.httprequest.HttpRequest;

import java.io.IOException;
import java.net.MalformedURLException;

public class EngineDiagnostic extends EndPoint {
    public EngineDiagnostic() throws MalformedURLException {
    }

    public String updateEngineDiagnostic() throws IOException, InterruptedException {
        return HttpRequest.createRequest(VIN + "/engine");
    }
}
