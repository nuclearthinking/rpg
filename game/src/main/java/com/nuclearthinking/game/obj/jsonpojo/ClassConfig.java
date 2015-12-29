package com.nuclearthinking.game.obj.jsonpojo;

/**
 * Date: 26.12.2015
 * Time: 20:31
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "rogueConfig",
        "mageConfig",
        "warriorConfig"
})
public class ClassConfig {

    @JsonProperty("rogueConfig")
    private RogueConfig rogueConfig;
    @JsonProperty("mageConfig")
    private MageConfig mageConfig;
    @JsonProperty("warriorConfig")
    private WarriorConfig warriorConfig;

    @JsonProperty("rogueConfig")
    public RogueConfig getRogueConfig() {
        return rogueConfig;
    }

    @JsonProperty("mageConfig")
    public MageConfig getMageConfig() {
        return mageConfig;
    }

    @JsonProperty("warriorConfig")
    public WarriorConfig getWarriorConfig() {
        return warriorConfig;
    }
}