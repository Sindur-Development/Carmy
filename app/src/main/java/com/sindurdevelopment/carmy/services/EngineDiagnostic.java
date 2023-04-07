package com.sindurdevelopment.carmy.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class EngineDiagnostic extends EndPoint {
    public EngineDiagnostic() throws MalformedURLException {
    }

    public com.sindurdevelopment.carmy.responsemodels.enginediagnostic.EngineDiagnostic updateEngineDiagnostic() throws IOException, InterruptedException {
        return objectMapper.readValue(
                httpRequest.createRequest(new URL(VIN + "/engine")), com.sindurdevelopment.carmy.responsemodels.enginediagnostic.EngineDiagnostic.class);
    }
}
