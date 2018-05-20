
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
    private List<String> definitions = null;
    @JsonProperty("domains")
    private List<String> domains = null;
    @JsonProperty("notes")
    private List<Note_> notes = null;
    @JsonProperty("regions")
    private List<String> regions = null;
    @JsonProperty("registers")
    private List<String> registers = null;
    @JsonProperty("senseIds")
    private List<String> senseIds = null;
    @JsonProperty("text")
    private String text;
    @JsonProperty("translations")
    private List<Translation> translations = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("definitions")
    public List<String> getDefinitions() {
        return definitions;
    }

    @JsonProperty("definitions")
    public void setDefinitions(List<String> definitions) {
        this.definitions = definitions;
    }

    @JsonProperty("domains")
    public List<String> getDomains() {
        return domains;
    }

    @JsonProperty("domains")
    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    @JsonProperty("notes")
    public List<Note_> getNotes() {
        return notes;
    }

    @JsonProperty("notes")
    public void setNotes(List<Note_> notes) {
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

    @JsonProperty("senseIds")
    public List<String> getSenseIds() {
        return senseIds;
    }

    @JsonProperty("senseIds")
    public void setSenseIds(List<String> senseIds) {
        this.senseIds = senseIds;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("translations")
    public List<Translation> getTranslations() {
        return translations;
    }

    @JsonProperty("translations")
    public void setTranslations(List<Translation> translations) {
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
