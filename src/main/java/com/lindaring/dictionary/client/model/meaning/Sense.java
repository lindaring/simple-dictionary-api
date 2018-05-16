
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
    private List<String> crossReferenceMarkers = null;
    @JsonProperty("crossReferences")
    private List<CrossReference> crossReferences = null;
    @JsonProperty("definitions")
    private List<String> definitions = null;
    @JsonProperty("domains")
    private List<String> domains = null;
    @JsonProperty("examples")
    private List<Example> examples = null;
    @JsonProperty("id")
    private String id;
    @JsonProperty("notes")
    private List<Note___> notes = null;
    @JsonProperty("pronunciations")
    private List<Pronunciation_> pronunciations = null;
    @JsonProperty("regions")
    private List<String> regions = null;
    @JsonProperty("registers")
    private List<String> registers = null;
    @JsonProperty("short_definitions")
    private List<String> shortDefinitions = null;
    @JsonProperty("subsenses")
    private List<Subsense> subsenses = null;
    @JsonProperty("thesaurusLinks")
    private List<ThesaurusLink> thesaurusLinks = null;
    @JsonProperty("translations")
    private List<Translation_> translations = null;
    @JsonProperty("variantForms")
    private List<VariantForm> variantForms = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("crossReferenceMarkers")
    public List<String> getCrossReferenceMarkers() {
        return crossReferenceMarkers;
    }

    @JsonProperty("crossReferenceMarkers")
    public void setCrossReferenceMarkers(List<String> crossReferenceMarkers) {
        this.crossReferenceMarkers = crossReferenceMarkers;
    }

    @JsonProperty("crossReferences")
    public List<CrossReference> getCrossReferences() {
        return crossReferences;
    }

    @JsonProperty("crossReferences")
    public void setCrossReferences(List<CrossReference> crossReferences) {
        this.crossReferences = crossReferences;
    }

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

    @JsonProperty("notes")
    public List<Note___> getNotes() {
        return notes;
    }

    @JsonProperty("notes")
    public void setNotes(List<Note___> notes) {
        this.notes = notes;
    }

    @JsonProperty("pronunciations")
    public List<Pronunciation_> getPronunciations() {
        return pronunciations;
    }

    @JsonProperty("pronunciations")
    public void setPronunciations(List<Pronunciation_> pronunciations) {
        this.pronunciations = pronunciations;
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

    @JsonProperty("short_definitions")
    public List<String> getShortDefinitions() {
        return shortDefinitions;
    }

    @JsonProperty("short_definitions")
    public void setShortDefinitions(List<String> shortDefinitions) {
        this.shortDefinitions = shortDefinitions;
    }

    @JsonProperty("subsenses")
    public List<Subsense> getSubsenses() {
        return subsenses;
    }

    @JsonProperty("subsenses")
    public void setSubsenses(List<Subsense> subsenses) {
        this.subsenses = subsenses;
    }

    @JsonProperty("thesaurusLinks")
    public List<ThesaurusLink> getThesaurusLinks() {
        return thesaurusLinks;
    }

    @JsonProperty("thesaurusLinks")
    public void setThesaurusLinks(List<ThesaurusLink> thesaurusLinks) {
        this.thesaurusLinks = thesaurusLinks;
    }

    @JsonProperty("translations")
    public List<Translation_> getTranslations() {
        return translations;
    }

    @JsonProperty("translations")
    public void setTranslations(List<Translation_> translations) {
        this.translations = translations;
    }

    @JsonProperty("variantForms")
    public List<VariantForm> getVariantForms() {
        return variantForms;
    }

    @JsonProperty("variantForms")
    public void setVariantForms(List<VariantForm> variantForms) {
        this.variantForms = variantForms;
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
