package com.sindurdevelopment.carmy;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.sindurdevelopment.carmy.jsonconversion.Response;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class VehicleManager {

    private static HttpURLConnection conn;
    private final static String vccApiKey = "607a267caccf4cdda65179f588772043";
    private static String accessToken = "eyJhbGciOiJSUzI1NiIsImtpZCI6IkpXVFNJR05FRENFUlQiLCJwaS5hdG0iOiI5cjdpIn0.eyJzY29wZSI6WyJjb252ZTpicmFrZV9zdGF0dXMiLCJjb252ZTpmdWVsX3N0YXR1cyIsImNvbnZlOmRvb3JzX3N0YXR1cyIsIm9wZW5pZCIsInByb2ZpbGUiLCJjb252ZTpkaWFnbm9zdGljc193b3Jrc2hvcCIsImNvbnZlOnRyaXBfc3RhdGlzdGljcyIsImNvbnZlOmVudmlyb25tZW50IiwiY29udmU6b2RvbWV0ZXJfc3RhdHVzIiwiY29udmU6ZW5naW5lX3N0YXR1cyIsImNvbnZlOmxvY2tfc3RhdHVzIiwiY29udmU6dmVoaWNsZV9yZWxhdGlvbiIsImNvbnZlOndpbmRvd3Nfc3RhdHVzIiwiY29udmU6dHlyZV9zdGF0dXMiLCJjb252ZTpjb25uZWN0aXZpdHlfc3RhdHVzIiwiY29udmU6ZGlhZ25vc3RpY3NfZW5naW5lX3N0YXR1cyIsImNvbnZlOndhcm5pbmdzIl0sImNsaWVudF9pZCI6ImRldmVsb3BlcnZjYXJzZG90Y29tIiwiZ3JudGlkIjoiZEVRMGkzTkJSSDVwN25KdnJ4Vnk2emdWdUswUlREbDgiLCJpc3MiOiJodHRwczovL3ZvbHZvaWQuZXUudm9sdm9jYXJzLmNvbSIsImF1ZCI6ImRldmVsb3BlcnZjYXJzZG90Y29tIiwiZmlyc3ROYW1lIjoiRGV2ZWxvcGVyIiwibGFzdE5hbWUiOiJWb2x2byBDYXJzIiwic3ViIjoiZTNmNTNiZGItYmY1MC00ZTBhLWJlOTctZGI5MzZjMTBhM2I0Iiwic2NvcGVzIjpbImNvbnZlOmJyYWtlX3N0YXR1cyIsImNvbnZlOmZ1ZWxfc3RhdHVzIiwiY29udmU6ZG9vcnNfc3RhdHVzIiwib3BlbmlkIiwicHJvZmlsZSIsImNvbnZlOmRpYWdub3N0aWNzX3dvcmtzaG9wIiwiY29udmU6dHJpcF9zdGF0aXN0aWNzIiwiY29udmU6ZW52aXJvbm1lbnQiLCJjb252ZTpvZG9tZXRlcl9zdGF0dXMiLCJjb252ZTplbmdpbmVfc3RhdHVzIiwiY29udmU6bG9ja19zdGF0dXMiLCJjb252ZTp2ZWhpY2xlX3JlbGF0aW9uIiwiY29udmU6d2luZG93c19zdGF0dXMiLCJjb252ZTp0eXJlX3N0YXR1cyIsImNvbnZlOmNvbm5lY3Rpdml0eV9zdGF0dXMiLCJjb252ZTpkaWFnbm9zdGljc19lbmdpbmVfc3RhdHVzIiwiY29udmU6d2FybmluZ3MiXSwiZW1haWwiOiJkZXZlbG9wZXJ2b2x2b2NhcnNjb21AZ21haWwuY29tIiwiZXhwIjoxNjc4NTYyNTY0fQ.KudwDOyBI6cNyOPCVFqb6eGfykXp336PpdksmaFDovoQYoWsO1U2cjmEOfLGmQ4YFptwjzaA1-3oKWHmgsvkK11dB7Mu6ySMt6D4CVNv8xEG6oUOb6acX1VpTr4pFLGWJ2iGnWCO-QgK6M6_Ssf7njvx3H66dJlIcR4BMGYlPufO6sdn_lMdL4lGvXzMR_zZU7Y5KUDwMP8fuvkGXZnb00DDPAqznrL102H26fUyeHCVrQ0UEEAOBcAENt6aK4OVy8SNuMvrB1mWhiC-jimo5va76Vf85zYPu-U-EOrtBxBGy95LIg4Aira9gkmFmOEHVOiSXtjeeuXyrlldro75ZQ";
    private Vehicle currentVehicle;

    public VehicleManager() throws MalformedURLException {
        currentVehicle = new Vehicle(new VehicleList().getVinNumbers().get(0));
    }

    public String getTemperature() throws MalformedURLException {
        LinkedTreeMap response =
                httpRequest(new URL("https://api.volvocars.com/connected-vehicle/v1/vehicles/"+currentVehicle.getVIN()+"/environment"));
        LinkedTreeMap responseData = (LinkedTreeMap) response.get("data");
        LinkedTreeMap responseexternalTemp = (LinkedTreeMap) responseData.get("externalTemp");
        return (String) responseexternalTemp.get("value");
    }

    public String getVehicleInformation() throws MalformedURLException {
        LinkedTreeMap response =
                httpRequest(new URL("https://api.volvocars.com/connected-vehicle/v1/vehicles/"+currentVehicle.getVIN()+"/engine"));
        LinkedTreeMap responseData = (LinkedTreeMap) response.get("data");
        LinkedTreeMap responseexternalTemp = (LinkedTreeMap) responseData.get("externalTemp");
        return "test";
    }

    public static LinkedTreeMap httpRequest(URL url){
        Gson gson = new Gson();
        LinkedTreeMap jsonResponse = null;
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
            jsonResponse = gson.fromJson(multipleLine,LinkedTreeMap.class);
            jsonResponse.forEach((key,value)-> System.out.println(key + ":" + value));

            ObjectMapper om = new ObjectMapper();
            Response response = om.readValue(multipleLine,Response.class);
            System.out.println("test");
            reader.close();
        } catch (Exception e) {
            System.out.println("Fel54: " + e);
        } finally {
            conn.disconnect();
        }

        return jsonResponse;
    }
}
