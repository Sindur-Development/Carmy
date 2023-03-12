package com.sindurdevelopment.carmy;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sindurdevelopment.carmy.enginediagnostic.EngineDiagnostic;
import com.sindurdevelopment.carmy.fuellevel.FuelLevel;
import com.sindurdevelopment.carmy.temperature.Temperature;
import com.sindurdevelopment.carmy.vehiclelist.VehicleList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class VehicleManager {

    private static HttpURLConnection conn;

    private static final String httpBaseAdress = "https://api.volvocars.com/connected-vehicle/v1/vehicles/";
    private final static String vccApiKey = "607a267caccf4cdda65179f588772043";
    private static String accessToken = "eyJhbGciOiJSUzI1NiIsImtpZCI6IkpXVFNJR05FRENFUlQiLCJwaS5hdG0iOiI5cjdpIn0.eyJzY29wZSI6WyJjb252ZTpicmFrZV9zdGF0dXMiLCJjb252ZTpmdWVsX3N0YXR1cyIsImNvbnZlOmRvb3JzX3N0YXR1cyIsIm9wZW5pZCIsInByb2ZpbGUiLCJjb252ZTpkaWFnbm9zdGljc193b3Jrc2hvcCIsImNvbnZlOnRyaXBfc3RhdGlzdGljcyIsImNvbnZlOmVudmlyb25tZW50IiwiY29udmU6b2RvbWV0ZXJfc3RhdHVzIiwiY29udmU6ZW5naW5lX3N0YXR1cyIsImNvbnZlOmxvY2tfc3RhdHVzIiwiY29udmU6dmVoaWNsZV9yZWxhdGlvbiIsImNvbnZlOndpbmRvd3Nfc3RhdHVzIiwiY29udmU6dHlyZV9zdGF0dXMiLCJjb252ZTpjb25uZWN0aXZpdHlfc3RhdHVzIiwiY29udmU6ZGlhZ25vc3RpY3NfZW5naW5lX3N0YXR1cyIsImNvbnZlOndhcm5pbmdzIl0sImNsaWVudF9pZCI6ImRldmVsb3BlcnZjYXJzZG90Y29tIiwiZ3JudGlkIjoiZEVRMGkzTkJSSDVwN25KdnJ4Vnk2emdWdUswUlREbDgiLCJpc3MiOiJodHRwczovL3ZvbHZvaWQuZXUudm9sdm9jYXJzLmNvbSIsImF1ZCI6ImRldmVsb3BlcnZjYXJzZG90Y29tIiwiZmlyc3ROYW1lIjoiRGV2ZWxvcGVyIiwibGFzdE5hbWUiOiJWb2x2byBDYXJzIiwic3ViIjoiZTNmNTNiZGItYmY1MC00ZTBhLWJlOTctZGI5MzZjMTBhM2I0Iiwic2NvcGVzIjpbImNvbnZlOmJyYWtlX3N0YXR1cyIsImNvbnZlOmZ1ZWxfc3RhdHVzIiwiY29udmU6ZG9vcnNfc3RhdHVzIiwib3BlbmlkIiwicHJvZmlsZSIsImNvbnZlOmRpYWdub3N0aWNzX3dvcmtzaG9wIiwiY29udmU6dHJpcF9zdGF0aXN0aWNzIiwiY29udmU6ZW52aXJvbm1lbnQiLCJjb252ZTpvZG9tZXRlcl9zdGF0dXMiLCJjb252ZTplbmdpbmVfc3RhdHVzIiwiY29udmU6bG9ja19zdGF0dXMiLCJjb252ZTp2ZWhpY2xlX3JlbGF0aW9uIiwiY29udmU6d2luZG93c19zdGF0dXMiLCJjb252ZTp0eXJlX3N0YXR1cyIsImNvbnZlOmNvbm5lY3Rpdml0eV9zdGF0dXMiLCJjb252ZTpkaWFnbm9zdGljc19lbmdpbmVfc3RhdHVzIiwiY29udmU6d2FybmluZ3MiXSwiZW1haWwiOiJkZXZlbG9wZXJ2b2x2b2NhcnNjb21AZ21haWwuY29tIiwiZXhwIjoxNjc4NjM1NjY5fQ.hPfsCzX0SUg3BN2Se-bfVH_pe0CiiLEAhCNY42HqBpnOO5nDqiDtBFEzbu2E7AxC-l85ziYxzObf4jUmW9c7XdpyTtruYQKze5mWM49TonlT4si0-K61SWlMhReuUd-zhAZJINHDMdHYHphsFjw6v0qH4a9WOFiDTdDg1JrzrnU0NWQudISdJuxeJPXDMzIF786bQbR0wR2OVgmTwuwL_f_W5wY9aZe7Z5urwrFf5byXLz4rl-42JGdAzI4-z7vx8KVOtwpxlqYXzDLtNMgmm1fJswmsBzMn2_OtsRpXFU1q5hSHQ_kMTrHCuL-wJhoTk08l5chL7z0sYG24vm9y4w";
    private Vehicle currentVehicle;

    private static ObjectMapper objectMapper;

    public VehicleManager() throws IOException {
        objectMapper = new ObjectMapper();
        //TODO skapa lösning för flera VIN's
        currentVehicle = new Vehicle(vehicleList().getData().get(0).getVin());
    }

    public void updateVehicle() throws IOException {
        getOdometer();
        getFuelLevel();
        getTemperature();
        engineDiagnostic();
    }

    private String getOdometer() throws IOException {
        Temperature temperature = objectMapper.readValue(
                httpRequest(new URL(httpBaseAdress+
                        currentVehicle.getVIN()+"/odometer")), Temperature.class);
        return temperature.getData().getExternalTemp().getValue();
    }

    public String getTemperature() throws IOException {
        Temperature temperature = objectMapper.readValue(
                httpRequest(new URL(httpBaseAdress+
                        currentVehicle.getVIN()+"/environment")), Temperature.class);
        return temperature.getData().getExternalTemp().getValue();
    }

    public void getFuelLevel() throws IOException {
        FuelLevel fuelLevel = objectMapper.readValue(
                httpRequest(new URL(httpBaseAdress+
                        currentVehicle.getVIN()+"/fuel")), FuelLevel.class);

    }

    public void engineDiagnostic() throws IOException {
        EngineDiagnostic engineDiagnostic = objectMapper.readValue(
                httpRequest(new URL(httpBaseAdress +
                        currentVehicle.getVIN() + "/engine")), EngineDiagnostic.class);
    }

    public VehicleList vehicleList() throws IOException {
        return objectMapper.readValue(
                httpRequest(new URL(httpBaseAdress)),
                VehicleList.class);
    }

    public static String httpRequest(URL url){
        String line = null; //ta bort senare
        String multipleLine="";

        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("vcc-api-key", vccApiKey);
            conn.setRequestProperty("authorization", "Bearer " + accessToken);
            conn.setRequestProperty("content-type","application/json");
        } catch(Exception e) {
            System.out.println("Fel37: " + e);
        }

        try {
            final BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getResponseCode() == 200 ? conn.getInputStream() : conn.getErrorStream()));

            while ((line = reader.readLine()) != null) {
                multipleLine += line;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Fel54: " + e);
        } finally {
            conn.disconnect();
        }

        System.out.println(multipleLine);

        return multipleLine;
    }
}
