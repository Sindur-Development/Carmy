
package com.sindurdevelopment.carmy.temperature;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Data {

    @SerializedName("externalTemp")
    @Expose
    private ExternalTemp externalTemp;

    public ExternalTemp getExternalTemp() {
        return externalTemp;
    }

    public void setExternalTemp(ExternalTemp externalTemp) {
        this.externalTemp = externalTemp;
    }

}
