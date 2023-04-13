package com.sindurdevelopment.carmy.services.commands;

import com.sindurdevelopment.carmy.httprequest.HttpRequest;
import com.sindurdevelopment.carmy.services.EndPoint;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;

public class StartClimate extends EndPoint {

    public StartClimate() throws MalformedURLException {
    }

    public static String startClimate() throws IOException, InterruptedException, JSONException {
        JSONObject json = new JSONObject(HttpRequest.createRequest(VIN + "/commands/climatization-start","Post"));
        return json.getJSONObject("async").getString("status");
    }

}
