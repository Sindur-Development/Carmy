package com.sindurdevelopment.carmy;

import com.google.gson.Gson;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class VehicleList extends VehicleFunction implements HttpRequest {
    private List<String> vinNumbers;

    private URL url = new URL("https://api.volvocars.com/connected-vehicle/v1/vehicles");


    public VehicleList(VehicleFunction vehicleFunction) throws MalformedURLException {
        Gson gson = new Gson();
        vinNumbers = new ArrayList<>(1);
        Map vin = gson.fromJson(vehicleFunction.httpRequest(url).get("data").toString(), Map.class);
        vinNumbers.add(vin.get("vin").toString());

    }

    public List<String> getVinNumbers() {
        return vinNumbers;
    }

}

