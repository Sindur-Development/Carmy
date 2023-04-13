package com.sindurdevelopment.carmy.services.commands;

import com.sindurdevelopment.carmy.httprequest.HttpRequest;
import com.sindurdevelopment.carmy.services.EndPoint;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;

public class LockDoors extends EndPoint {

    public LockDoors() throws MalformedURLException {
    }

    public static String lockDoors() throws IOException, InterruptedException, JSONException {
//        JSONObject json = new JSONObject(
        HttpRequest.createRequest(VIN + "/commands/lock","Post");
        return "";//json.getJSONObject("async").getString("status");
    }

}
