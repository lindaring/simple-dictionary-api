
package com.lindaring.dictionary.client.model.translation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "examples",
    "id",
    "translations"
})
public class Sense {

    @JsonProperty("examples")
    private List<Example> examples = null;
    @JsonProperty("id")
    private String id;
    @JsonProperty("translations")
    private List<Translation__> translations = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("examples")
    public List<Example> getExamples() {
        return examples;
    }

    @JsonProperty("examples")
    public void setExamples(List<Example> examples) {
        this.examples = examples;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("translations")
    public List<Translation__> getTranslations() {
        return translations;
    }

    @JsonProperty("translations")
    public void setTranslations(List<Translation__> translations) {
        this.translations = translations;
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
