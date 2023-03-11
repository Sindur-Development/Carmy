package com.sindurdevelopment.carmy;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class VehicleFunctions {

    private static HttpURLConnection conn = null;
    private static URL url;
    private static String responseMessage;
    private static int responsecode;

    public static String getTemprature(String vin, String vccApiKey, String accessToken) throws MalformedURLException {
        String temp="";
        url = new URL("https://api.volvocars.com/connected-vehicle/v1/vehicles/"+vin+"/environment");
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
                    new InputStreamReader(responsecode == 200 ? conn.getInputStream() : conn.getErrorStream()));
            JSONObject obj = null;
            String line = null; //ta bort senare
            String multipleLine="";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);//ta bort senare
                multipleLine += line;
            }
            obj = new JSONObject(multipleLine);
//            temp = new JSONObject(obj.getJSONArray("data").getString(0)).getString("vin"));
            reader.close();
        } catch (Exception e) {
            System.out.println("Fel54: " + e);
        } finally {
            conn.disconnect();
        }

        return "25";
    }
}
