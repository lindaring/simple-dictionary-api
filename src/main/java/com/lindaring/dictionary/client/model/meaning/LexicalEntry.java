
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
    "derivativeOf",
    "derivatives",
    "entries",
    "grammaticalFeatures",
    "language",
    "lexicalCategory",
    "notes",
    "pronunciations",
    "text",
    "variantForms"
})
public class LexicalEntry {

    @JsonProperty("derivativeOf")
    public List<DerivativeOf> derivativeOf = null;
    @JsonProperty("derivatives")
    public List<Derivative> derivatives = null;
    @JsonProperty("entries")
    public List<Entry> entries = null;
    @JsonProperty("grammaticalFeatures")
    public List<GrammaticalFeature___> grammaticalFeatures = null;
    @JsonProperty("language")
    public String language;
    @JsonProperty("lexicalCategory")
    public String lexicalCategory;
    @JsonProperty("notes")
    public List<Note_____> notes = null;
    @JsonProperty("pronunciations")
    public List<Pronunciation__> pronunciations = null;
    @JsonProperty("text")
    public String text;
    @JsonProperty("variantForms")
    public List<VariantForm__> variantForms = null;
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
