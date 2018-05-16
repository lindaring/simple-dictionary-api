
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
    private List<String> etymologies = null;
    @JsonProperty("grammaticalFeatures")
    private List<GrammaticalFeature> grammaticalFeatures = null;
    @JsonProperty("homographNumber")
    private String homographNumber;
    @JsonProperty("notes")
    private List<Note> notes = null;
    @JsonProperty("pronunciations")
    private List<Pronunciation> pronunciations = null;
    @JsonProperty("senses")
    private List<Sense> senses = null;
    @JsonProperty("variantForms")
    private List<VariantForm_> variantForms = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("etymologies")
    public List<String> getEtymologies() {
        return etymologies;
    }

    @JsonProperty("etymologies")
    public void setEtymologies(List<String> etymologies) {
        this.etymologies = etymologies;
    }

    @JsonProperty("grammaticalFeatures")
    public List<GrammaticalFeature> getGrammaticalFeatures() {
        return grammaticalFeatures;
    }

    @JsonProperty("grammaticalFeatures")
    public void setGrammaticalFeatures(List<GrammaticalFeature> grammaticalFeatures) {
        this.grammaticalFeatures = grammaticalFeatures;
    }

    @JsonProperty("homographNumber")
    public String getHomographNumber() {
        return homographNumber;
    }

    @JsonProperty("homographNumber")
    public void setHomographNumber(String homographNumber) {
        this.homographNumber = homographNumber;
    }

    @JsonProperty("notes")
    public List<Note> getNotes() {
        return notes;
    }

    @JsonProperty("notes")
    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @JsonProperty("pronunciations")
    public List<Pronunciation> getPronunciations() {
        return pronunciations;
    }

    @JsonProperty("pronunciations")
    public void setPronunciations(List<Pronunciation> pronunciations) {
        this.pronunciations = pronunciations;
    }

    @JsonProperty("senses")
    public List<Sense> getSenses() {
        return senses;
    }

    @JsonProperty("senses")
    public void setSenses(List<Sense> senses) {
        this.senses = senses;
    }

    @JsonProperty("variantForms")
    public List<VariantForm_> getVariantForms() {
        return variantForms;
    }

    @JsonProperty("variantForms")
    public void setVariantForms(List<VariantForm_> variantForms) {
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
