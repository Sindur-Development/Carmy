package com.sindurdevelopment.carmy;

import com.google.gson.internal.LinkedTreeMap;

import java.net.MalformedURLException;
import java.net.URL;

public class Temperature extends VehicleFunction {

    private URL url;

    public Temperature(String vin) throws MalformedURLException {
        url= new URL("https://api.volvocars.com/connected-vehicle/v1/vehicles/"+vin+"/environment");
    }

    public String getTemperature(){
        LinkedTreeMap response = VehicleFunction.httpRequest(url);
        LinkedTreeMap responseData = (LinkedTreeMap) response.get("data");
        LinkedTreeMap responseexternalTemp = (LinkedTreeMap) responseData.get("externalTemp");
        return (String) responseexternalTemp.get("value");

    }


}
