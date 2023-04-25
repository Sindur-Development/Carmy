package com.sindurdevelopment.carmy.services.commands;

import com.sindurdevelopment.carmy.httprequest.HttpRequest;
import com.sindurdevelopment.carmy.services.EndPoint;
import com.sindurdevelopment.carmy.services.VehicleManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;

public class UnlockDoors extends EndPoint {

    public UnlockDoors() throws MalformedURLException {
    }

    public static String unlockDoors() throws IOException, InterruptedException, JSONException {
        JSONObject json = new JSONObject(HttpRequest.createHttpPost(VIN + "/commands/unlock","{\"unlockDuration\":120}"));
        VehicleManager.currentVehicle.setLastCommandRef(json.getJSONObject("async").getString("href"));
        System.out.println(json.getJSONObject("async").getString("status"));
        return json.getJSONObject("async").getString("status");
    }

}
