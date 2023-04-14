package com.sindurdevelopment.carmy.services.status;

import com.sindurdevelopment.carmy.httprequest.HttpRequest;
import com.sindurdevelopment.carmy.services.EndPoint;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;


public class VehicleDetails extends EndPoint {
    public VehicleDetails() throws MalformedURLException {
    }

    public static JSONObject getVehicleDetails() throws IOException, JSONException, InterruptedException {
        JSONObject json = new JSONObject(HttpRequest.createGetRequest(VIN,"vehicle"));
        return json;
    }

}
