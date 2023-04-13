package com.sindurdevelopment.carmy.services.status;

import com.sindurdevelopment.carmy.httprequest.HttpRequest;
import com.sindurdevelopment.carmy.services.EndPoint;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;


public class Doors extends EndPoint {
    public Doors() throws MalformedURLException {
    }

    public static String getDoorStatus() throws IOException, JSONException, InterruptedException {
        JSONObject json = new JSONObject(HttpRequest.createRequest(VIN + "/doors"));
        return json.getJSONObject("data").toString();
    }

}
