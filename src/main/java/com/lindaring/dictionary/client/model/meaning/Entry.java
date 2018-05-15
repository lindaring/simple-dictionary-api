
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
    "etymologies",
    "grammaticalFeatures",
    "homographNumber",
    "notes",
    "pronunciations",
    "senses",
    "variantForms"
})
public class Entry {

    @JsonProperty("etymologies")
    public List<String> etymologies = null;
    @JsonProperty("grammaticalFeatures")
    public List<GrammaticalFeature> grammaticalFeatures = null;
    @JsonProperty("homographNumber")
    public String homographNumber;
    @JsonProperty("notes")
    public List<Note> notes = null;
    @JsonProperty("pronunciations")
    public List<Pronunciation> pronunciations = null;
    @JsonProperty("senses")
    public List<Sense> senses = null;
    @JsonProperty("variantForms")
    public List<VariantForm_> variantForms = null;
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
