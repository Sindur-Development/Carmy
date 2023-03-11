
package com.sindurdevelopment.carmy.fuellevel;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Data {

    @SerializedName("fuelAmount")
    @Expose
    private FuelAmount fuelAmount;

    public FuelAmount getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(FuelAmount fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

}
