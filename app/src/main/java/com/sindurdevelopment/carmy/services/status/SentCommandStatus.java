package com.sindurdevelopment.carmy.services.status;

import com.sindurdevelopment.carmy.httprequest.HttpRequest;
import com.sindurdevelopment.carmy.services.EndPoint;
import com.sindurdevelopment.carmy.services.VehicleManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;

public class SentCommandStatus extends EndPoint {
    public SentCommandStatus() throws MalformedURLException {
    }

    public static String getSentCommandStatus() throws IOException, InterruptedException, JSONException {
        JSONObject json = new JSONObject(HttpRequest.createGetRequest(VehicleManager.currentVehicle.getLastCommandRef().split("vehicles")[1],"requestdetailresponse"));
        return getCommand(json)+" "+getInvokeStatus(json);
    }

    private static String getInvokeStatus(JSONObject json) throws JSONException {
        return json.has("data") ? json.getJSONObject("data").getString("invokeStatus"): "No data available from server";
    }

    private static String getCommand(JSONObject json) throws JSONException {
        return json.has("data") ? json.getJSONObject("data").getString("command"): "No data available from server";
    }

}
