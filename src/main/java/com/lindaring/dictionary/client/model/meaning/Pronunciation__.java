
package com.lindaring.dictionary.client.model.meaning;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "audioFile",
    "dialects",
    "phoneticNotation",
    "phoneticSpelling",
    "regions"
})
public class Pronunciation__ {

    @JsonProperty("audioFile")
    public String audioFile;
    @JsonProperty("dialects")
    public List<String> dialects = null;
    @JsonProperty("phoneticNotation")
    public String phoneticNotation;
    @JsonProperty("phoneticSpelling")
    public String phoneticSpelling;
    @JsonProperty("regions")
    public List<String> regions = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
