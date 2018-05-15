
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
    "crossReferenceMarkers",
    "crossReferences",
    "definitions",
    "domains",
    "examples",
    "id",
    "notes",
    "pronunciations",
    "regions",
    "registers",
    "short_definitions",
    "subsenses",
    "thesaurusLinks",
    "translations",
    "variantForms"
})
public class Sense {

    @JsonProperty("crossReferenceMarkers")
    public List<String> crossReferenceMarkers = null;
    @JsonProperty("crossReferences")
    public List<CrossReference> crossReferences = null;
    @JsonProperty("definitions")
    public List<String> definitions = null;
    @JsonProperty("domains")
    public List<String> domains = null;
    @JsonProperty("examples")
    public List<Example> examples = null;
    @JsonProperty("id")
    public String id;
    @JsonProperty("notes")
    public List<Note___> notes = null;
    @JsonProperty("pronunciations")
    public List<Pronunciation_> pronunciations = null;
    @JsonProperty("regions")
    public List<String> regions = null;
    @JsonProperty("registers")
    public List<String> registers = null;
    @JsonProperty("short_definitions")
    public List<String> shortDefinitions = null;
    @JsonProperty("subsenses")
    public List<Subsense> subsenses = null;
    @JsonProperty("thesaurusLinks")
    public List<ThesaurusLink> thesaurusLinks = null;
    @JsonProperty("translations")
    public List<Translation_> translations = null;
    @JsonProperty("variantForms")
    public List<VariantForm> variantForms = null;
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
