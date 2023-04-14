package com.sindurdevelopment.carmy.services.status;

import com.sindurdevelopment.carmy.httprequest.HttpRequest;
import com.sindurdevelopment.carmy.services.EndPoint;

import java.io.IOException;
import java.net.MalformedURLException;

public class EngineDiagnostic extends EndPoint {
    public EngineDiagnostic() throws MalformedURLException {
    }

    public String updateEngineDiagnostic() throws IOException, InterruptedException {
        return HttpRequest.createGetRequest(VIN + "/engine");
    }
}
