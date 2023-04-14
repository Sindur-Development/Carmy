package com.sindurdevelopment.carmy.services.status;

import com.sindurdevelopment.carmy.httprequest.HttpRequest;
import com.sindurdevelopment.carmy.services.EndPoint;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;

public class Temperature extends EndPoint {

    public Temperature() throws MalformedURLException {
    }

    public static String getTemperature() throws IOException, InterruptedException, JSONException {
        JSONObject json = new JSONObject(HttpRequest.createGetRequest(VIN + "/environment"));
        return json.getJSONObject("data").getJSONObject("externalTemp").getString("value")+"°";
    }

}
