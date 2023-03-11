
package com.sindurdevelopment.carmy.jsonconversion;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "engineRunning",
    "oilPressure",
    "engineCoolantLevel",
    "oilLevel",
    "engineCoolantTemp"
})
@Generated("jsonschema2pojo")
public class Data {

    @JsonProperty("engineRunning")
    private EngineRunning engineRunning;
    @JsonProperty("oilPressure")
    private OilPressure oilPressure;
    @JsonProperty("engineCoolantLevel")
    private EngineCoolantLevel engineCoolantLevel;
    @JsonProperty("oilLevel")
    private OilLevel oilLevel;
    @JsonProperty("engineCoolantTemp")
    private EngineCoolantTemp engineCoolantTemp;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("engineRunning")
    public EngineRunning getEngineRunning() {
        return engineRunning;
    }

    @JsonProperty("engineRunning")
    public void setEngineRunning(EngineRunning engineRunning) {
        this.engineRunning = engineRunning;
    }

    @JsonProperty("oilPressure")
    public OilPressure getOilPressure() {
        return oilPressure;
    }

    @JsonProperty("oilPressure")
    public void setOilPressure(OilPressure oilPressure) {
        this.oilPressure = oilPressure;
    }

    @JsonProperty("engineCoolantLevel")
    public EngineCoolantLevel getEngineCoolantLevel() {
        return engineCoolantLevel;
    }

    @JsonProperty("engineCoolantLevel")
    public void setEngineCoolantLevel(EngineCoolantLevel engineCoolantLevel) {
        this.engineCoolantLevel = engineCoolantLevel;
    }

    @JsonProperty("oilLevel")
    public OilLevel getOilLevel() {
        return oilLevel;
    }

    @JsonProperty("oilLevel")
    public void setOilLevel(OilLevel oilLevel) {
        this.oilLevel = oilLevel;
    }

    @JsonProperty("engineCoolantTemp")
    public EngineCoolantTemp getEngineCoolantTemp() {
        return engineCoolantTemp;
    }

    @JsonProperty("engineCoolantTemp")
    public void setEngineCoolantTemp(EngineCoolantTemp engineCoolantTemp) {
        this.engineCoolantTemp = engineCoolantTemp;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
