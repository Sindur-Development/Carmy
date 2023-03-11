package com.sindurdevelopment.carmy;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class VehicleList extends VehicleFunction implements HttpRequest {
    private List<String> vinNumbers;

    private URL url;


    public VehicleList(VehicleFunction vehicleFunction) throws MalformedURLException {
        url = new URL("https://api.volvocars.com/connected-vehicle/v1/vehicles");
        Gson gson = new Gson();
        vinNumbers = new ArrayList<>(1);
        LinkedTreeMap httpResponse = vehicleFunction.httpRequest(url);
        ArrayList<LinkedTreeMap> responseData = (ArrayList<LinkedTreeMap>) httpResponse.get("data");
        vinNumbers.add((String) responseData.get(0).get("vin"));
    }

    public List<String> getVinNumbers() {
        return vinNumbers;
    }

}

