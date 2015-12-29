package com.nuclearthinking.game.obj.jsonpojo;

/**
 * Date: 26.12.2015
 * Time: 20:34
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "agilityRate",
        "strengthRate",
        "intelligenceRate",
        "staminaRate"
})
public class MageConfig {

    @JsonProperty("agilityRate")
    private Double agilityRate;
    @JsonProperty("strengthRate")
    private Double strengthRate;
    @JsonProperty("intelligenceRate")
    private Double intelligenceRate;
    @JsonProperty("staminaRate")
    private Double staminaRate;

    @JsonProperty("agilityRate")
    public Double getAgilityRate() {
        return agilityRate;
    }

    @JsonProperty("strengthRate")
    public Double getStrengthRate() {
        return strengthRate;
    }

    @JsonProperty("intelligenceRate")
    public Double getIntelligenceRate() {
        return intelligenceRate;
    }

    @JsonProperty("staminaRate")
    public Double getStaminaRate() {
        return staminaRate;
    }

}