package com.sindurdevelopment.carmy.services.status;
import com.sindurdevelopment.carmy.httprequest.HttpRequest;
import com.sindurdevelopment.carmy.services.EndPoint;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;


public class Odometer extends EndPoint {
    public Odometer() throws MalformedURLException {
    }

    public static String getOdometer() throws IOException, JSONException, InterruptedException {
        JSONObject json = new JSONObject(HttpRequest.createGetRequest(VIN + "/odometer"));
        return getOdometerValue(json)+" " +getOdometerUnit(json);
    }

    private static String getOdometerValue(JSONObject json) throws JSONException {
       return json.getJSONObject("data").getJSONObject("odometer").getString("value");
    }

    private static String getOdometerUnit(JSONObject json) throws JSONException {
        return json.getJSONObject("data").getJSONObject("odometer").getString("unit").equals("kilometers")?"km":"mi";
    }
}
