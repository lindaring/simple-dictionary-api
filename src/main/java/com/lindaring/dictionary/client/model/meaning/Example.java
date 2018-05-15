
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
    "definitions",
    "domains",
    "notes",
    "regions",
    "registers",
    "senseIds",
    "text",
    "translations"
})
public class Example {

    @JsonProperty("definitions")
    public List<String> definitions = null;
    @JsonProperty("domains")
    public List<String> domains = null;
    @JsonProperty("notes")
    public List<Note_> notes = null;
    @JsonProperty("regions")
    public List<String> regions = null;
    @JsonProperty("registers")
    public List<String> registers = null;
    @JsonProperty("senseIds")
    public List<String> senseIds = null;
    @JsonProperty("text")
    public String text;
    @JsonProperty("translations")
    public List<Translation> translations = null;
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
