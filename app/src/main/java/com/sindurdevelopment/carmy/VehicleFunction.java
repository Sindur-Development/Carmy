package com.sindurdevelopment.carmy;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class VehicleFunction {

    private final static String vccApiKey = "607a267caccf4cdda65179f588772043";
    private static String accessToken;
    private HttpURLConnection conn;

    private VehicleList vehicleList;

    public VehicleFunction(){}

    public VehicleFunction(String accessToken) throws MalformedURLException {
        this.accessToken = accessToken;
        vehicleList = new VehicleList(this);
    }

    public VehicleList vehicleList() {
        return vehicleList;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public Map httpRequest(URL url){
        Gson gson = new Gson();
        Map jsonResponse = null;
        JSONObject obj = null;

        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("vcc-api-key", vccApiKey);
            conn.setRequestProperty("authorization", "Bearer " + accessToken);
        } catch(Exception e) {
            System.out.println("Fel37: " + e);
        }

        try {
            final BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getResponseCode() == 200 ? conn.getInputStream() : conn.getErrorStream()));
            String line = null; //ta bort senare
            String multipleLine="";
            while ((line = reader.readLine()) != null) {
                multipleLine += line;
            }
            obj = new JSONObject(multipleLine);
            jsonResponse = gson.fromJson(multipleLine,Map.class);
            jsonResponse.forEach((key,value)-> System.out.println(key + ":" + value));
            reader.close();
        } catch (Exception e) {
            System.out.println("Fel54: " + e);
        } finally {
            conn.disconnect();
        }

        return jsonResponse;
    }
}
