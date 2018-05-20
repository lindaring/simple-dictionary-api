
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
    "domains",
    "grammaticalFeatures",
    "language",
    "notes",
    "regions",
    "registers",
    "text"
})
public class Translation_ {

    @JsonProperty("domains")
    private List<String> domains = null;
    @JsonProperty("grammaticalFeatures")
    private List<GrammaticalFeature__> grammaticalFeatures = null;
    @JsonProperty("language")
    private String language;
    @JsonProperty("notes")
    private List<Note____> notes = null;
    @JsonProperty("regions")
    private List<String> regions = null;
    @JsonProperty("registers")
    private List<String> registers = null;
    @JsonProperty("text")
    private String text;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("domains")
    public List<String> getDomains() {
        return domains;
    }

    @JsonProperty("domains")
    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    @JsonProperty("grammaticalFeatures")
    public List<GrammaticalFeature__> getGrammaticalFeatures() {
        return grammaticalFeatures;
    }

    @JsonProperty("grammaticalFeatures")
    public void setGrammaticalFeatures(List<GrammaticalFeature__> grammaticalFeatures) {
        this.grammaticalFeatures = grammaticalFeatures;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("notes")
    public List<Note____> getNotes() {
        return notes;
    }

    @JsonProperty("notes")
    public void setNotes(List<Note____> notes) {
        this.notes = notes;
    }

    @JsonProperty("regions")
    public List<String> getRegions() {
        return regions;
    }

    @JsonProperty("regions")
    public void setRegions(List<String> regions) {
        this.regions = regions;
    }

    @JsonProperty("registers")
    public List<String> getRegisters() {
        return registers;
    }

    @JsonProperty("registers")
    public void setRegisters(List<String> registers) {
        this.registers = registers;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
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
