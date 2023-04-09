package com.sindurdevelopment.carmy.services;

import com.sindurdevelopment.carmy.httprequest.HttpRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;

public class Temperature extends EndPoint {

    public Temperature() throws MalformedURLException {
    }

    public static String getTemperature() throws IOException, InterruptedException, JSONException {
        JSONObject json = new JSONObject(HttpRequest.createRequest(VIN + "/environment"));
        return json.getJSONObject("data").getJSONObject("externalTemp").getString("value");
    }

}
