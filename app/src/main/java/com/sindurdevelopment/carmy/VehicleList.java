package com.sindurdevelopment.carmy;

import org.json.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class VehicleList {
    private static HttpURLConnection conn = null;
    private String accessToken;
    private final static String vccApiKey = "607a267caccf4cdda65179f588772043";
    private final static URL url;

    static {
        try {
            url = new URL("https://api.volvocars.com/connected-vehicle/v1/vehicles");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private String responseMessage;
    private int responsecode;
    private List<String> vinNumbers;
    public VehicleList(String accessToken) throws JSONException {
        this.accessToken = accessToken;
        vinNumbers = new ArrayList<>(1);
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("vcc-api-key", vccApiKey);
            conn.setRequestProperty("authorization", "Bearer " + accessToken);
            responsecode = conn.getResponseCode();
            responseMessage = conn.getResponseMessage();
        } catch(Exception e) {
            System.out.println("Fel37: " + e);
        }

        try {
            final BufferedReader reader = new BufferedReader(
                    new InputStreamReader(getResponsecode() == 200 ? conn.getInputStream() : conn.getErrorStream()));
            JSONObject obj = null;
            String line = null; //ta bort senare
            String multipleLine="";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);//ta bort senare
                multipleLine += line;
            }
            obj = new JSONObject(multipleLine);
            vinNumbers.add(new JSONObject(obj.getJSONArray("data").getString(0)).getString("vin"));
            System.out.println(vinNumbers.toString());
            reader.close();
        } catch (Exception e) {
            System.out.println("Fel54: " + e);
        } finally {
            conn.disconnect();
        }

    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public int getResponsecode() {
        return responsecode;
    }

    public List<String> getVinNumbers() {
        return vinNumbers;
    }

}

