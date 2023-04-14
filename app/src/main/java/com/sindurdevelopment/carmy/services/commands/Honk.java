package com.sindurdevelopment.carmy.services.commands;

import com.sindurdevelopment.carmy.httprequest.HttpRequest;
import com.sindurdevelopment.carmy.services.EndPoint;

import org.json.JSONException;

import java.io.IOException;
import java.net.MalformedURLException;

public class Honk extends EndPoint {

    public Honk() throws MalformedURLException {
    }

    public static String honk() throws IOException, InterruptedException, JSONException {
//        JSONObject json = new JSONObject(
        HttpRequest.createHttpPost(VIN + "/commands/honk","");
        return "";//json.getJSONObject("async").getString("status");
    }

}
