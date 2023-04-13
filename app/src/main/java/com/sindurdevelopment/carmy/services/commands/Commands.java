package com.sindurdevelopment.carmy.services.commands;
import com.sindurdevelopment.carmy.httprequest.HttpRequest;
import com.sindurdevelopment.carmy.services.EndPoint;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;


public class Commands extends EndPoint {
    public Commands() throws MalformedURLException {
    }

    public static String getCommands() throws IOException, JSONException, InterruptedException {
//        JSONObject json = new JSONObject(HttpRequest.createRequest(VIN + "/commands"));
        return ""; //json.getJSONObject("data").getJSONObject("odometer").getString("unit").equals("kilometers")?"km":"mi";
    }

}
