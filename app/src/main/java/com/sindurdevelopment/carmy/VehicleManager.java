package com.sindurdevelopment.carmy;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sindurdevelopment.carmy.responsemodels.enginediagnostic.EngineDiagnostic;
import com.sindurdevelopment.carmy.responsemodels.fuellevel.FuelLevel;
import com.sindurdevelopment.carmy.responsemodels.temperature.Temperature;
import com.sindurdevelopment.carmy.responsemodels.vehiclelist.VehicleList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class VehicleManager {

    private static HttpURLConnection conn;
    private static final String httpBaseAdress = "https://api.volvocars.com/connected-vehicle/v1/vehicles/";
    private final static String vccApiKey = "607a267caccf4cdda65179f588772043";
    private static String accessToken = "eyJhbGciOiJSUzI1NiIsImtpZCI6IkpXVFNJR05FRENFUlQiLCJwaS5hdG0iOiI5cjdpIn0.eyJzY29wZSI6WyJjb252ZTpicmFrZV9zdGF0dXMiLCJjb252ZTpmdWVsX3N0YXR1cyIsImNvbnZlOmRvb3JzX3N0YXR1cyIsIm9wZW5pZCIsInByb2ZpbGUiLCJjb252ZTpkaWFnbm9zdGljc193b3Jrc2hvcCIsImNvbnZlOnRyaXBfc3RhdGlzdGljcyIsImNvbnZlOmVudmlyb25tZW50IiwiY29udmU6b2RvbWV0ZXJfc3RhdHVzIiwiY29udmU6ZW5naW5lX3N0YXR1cyIsImNvbnZlOmxvY2tfc3RhdHVzIiwiY29udmU6dmVoaWNsZV9yZWxhdGlvbiIsImNvbnZlOndpbmRvd3Nfc3RhdHVzIiwiY29udmU6dHlyZV9zdGF0dXMiLCJjb252ZTpjb25uZWN0aXZpdHlfc3RhdHVzIiwiY29udmU6ZGlhZ25vc3RpY3NfZW5naW5lX3N0YXR1cyIsImNvbnZlOndhcm5pbmdzIl0sImNsaWVudF9pZCI6ImRldmVsb3BlcnZjYXJzZG90Y29tIiwiZ3JudGlkIjoiZEVRMGkzTkJSSDVwN25KdnJ4Vnk2emdWdUswUlREbDgiLCJpc3MiOiJodHRwczovL3ZvbHZvaWQuZXUudm9sdm9jYXJzLmNvbSIsImF1ZCI6ImRldmVsb3BlcnZjYXJzZG90Y29tIiwiZmlyc3ROYW1lIjoiRGV2ZWxvcGVyIiwibGFzdE5hbWUiOiJWb2x2byBDYXJzIiwic3ViIjoiZTNmNTNiZGItYmY1MC00ZTBhLWJlOTctZGI5MzZjMTBhM2I0Iiwic2NvcGVzIjpbImNvbnZlOmJyYWtlX3N0YXR1cyIsImNvbnZlOmZ1ZWxfc3RhdHVzIiwiY29udmU6ZG9vcnNfc3RhdHVzIiwib3BlbmlkIiwicHJvZmlsZSIsImNvbnZlOmRpYWdub3N0aWNzX3dvcmtzaG9wIiwiY29udmU6dHJpcF9zdGF0aXN0aWNzIiwiY29udmU6ZW52aXJvbm1lbnQiLCJjb252ZTpvZG9tZXRlcl9zdGF0dXMiLCJjb252ZTplbmdpbmVfc3RhdHVzIiwiY29udmU6bG9ja19zdGF0dXMiLCJjb252ZTp2ZWhpY2xlX3JlbGF0aW9uIiwiY29udmU6d2luZG93c19zdGF0dXMiLCJjb252ZTp0eXJlX3N0YXR1cyIsImNvbnZlOmNvbm5lY3Rpdml0eV9zdGF0dXMiLCJjb252ZTpkaWFnbm9zdGljc19lbmdpbmVfc3RhdHVzIiwiY29udmU6d2FybmluZ3MiXSwiZW1haWwiOiJkZXZlbG9wZXJ2b2x2b2NhcnNjb21AZ21haWwuY29tIiwiZXhwIjoxNjc4ODE1NzA0fQ.m-r_QSia7eCfKZWJnRZJu0WnkR4tctiFVZV7c7ZhCX9NyPBmht5Ik5nfcPscgOVnFSefZFlNG2OzJC52vbEzqKCQbWGVls_YiRNVW9QVHU5bzyQe4t-_z81luppWwwNX4KpXTEOGYneur2xXALUNo_WgF3yg-3CCBWExY7_78-qiX1JMtRdYBMYylXwgSpl7jdS8eRBD-WQ8bvBiiyQe8vhLZhMaKEre95-zqR6t-f-7snXLGckl7B7caKpMZStTdfG1OEHv6HSOUM2fOrKhb3fGVO5RAX9GiLLE3K3-j9YT_HQE9b0WSo4sWmMvK2ZlklE0JuyTF6-ycX4neXTTow";
    private static Vehicle currentVehicle;

    private static VehicleList vehicleList;
    private static ObjectMapper objectMapper;

    public static void startVehicleManager() throws IOException {
        objectMapper = new ObjectMapper();
        //TODO skapa lösning för flera VIN's
        getAccountVehicleList();
//        setCurrentVehicle(new Vehicle(vehicleList.getData().get(0).getVin()));
    }

    public static String httpRequest(URL url) {
        final String[] line = {null}; //ta bort senare
        final String[] multipleLine = {""};
        Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            try
            {
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("vcc-api-key", vccApiKey);
                conn.setRequestProperty("authorization", "Bearer " + accessToken);
                //            conn.setRequestProperty("content-type","application/json");


            } catch(Exception e)
            {
                System.out.println("Fel37: " + e);
            }
            try
            {
                final BufferedReader reader = new BufferedReader(
                        new InputStreamReader(conn.getResponseCode() == 200 ? conn.getInputStream() : conn.getErrorStream()));
                conn.disconnect();
                while ((line[0] = reader.readLine()) != null) {
                    multipleLine[0] += line[0];
                }
                reader.close();
            } catch(Exception e)
            {
                System.out.println("Fel54: " + e);
            }

            System.out.println("Working: " + multipleLine[0]);

        }});
        thread.start();

        return multipleLine[0];

    }

    public static void updateVehicle() throws IOException {
        getOdometer();
        getFuelLevel();
        getTemperature();
        updateEngineDiagnostic();
    }

    public static void getOdometer() throws IOException {
        Temperature temperature = objectMapper.readValue(
                httpRequest(new URL(httpBaseAdress +
                        currentVehicle.getVIN() + "/odometer")), Temperature.class);
    }

    public static void getTemperature() throws IOException {
        Temperature temperature = objectMapper.readValue(
                httpRequest(new URL(httpBaseAdress +
                        currentVehicle.getVIN() + "/environment")), Temperature.class);
    }

    public static void getStatistics() throws IOException {
        Temperature temperature = objectMapper.readValue(
                httpRequest(new URL(httpBaseAdress +
                        currentVehicle.getVIN() + "/statistics")), Temperature.class);
    }

    public static void getFuelLevel() throws IOException {
        FuelLevel fuelLevel = objectMapper.readValue(
                httpRequest(new URL(httpBaseAdress +
                        currentVehicle.getVIN() + "/fuel")), FuelLevel.class);

    }

    public static void updateEngineDiagnostic() throws IOException {
        currentVehicle.setEngineDiagnostic(objectMapper.readValue(
                httpRequest(new URL(httpBaseAdress +
                        currentVehicle.getVIN() + "/engine")), EngineDiagnostic.class));
    }

    public static void getAccountVehicleList() throws IOException {
        setVehicleList(objectMapper.readValue(
                httpRequest(new URL(httpBaseAdress)),
                VehicleList.class));
    }

    public static Vehicle getCurrentVehicle() {
        return currentVehicle;
    }

    public static void setCurrentVehicle(Vehicle currentVehicle) {
        VehicleManager.currentVehicle = currentVehicle;
    }

    public static VehicleList getVehicleList() {
        return vehicleList;
    }

    public static void setVehicleList(VehicleList vehicleList) {
        VehicleManager.vehicleList = vehicleList;
    }
}
