
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
    private List<DerivativeOf> derivativeOf = null;
    @JsonProperty("derivatives")
    private List<Derivative> derivatives = null;
    @JsonProperty("entries")
    private List<Entry> entries = null;
    @JsonProperty("grammaticalFeatures")
    private List<GrammaticalFeature___> grammaticalFeatures = null;
    @JsonProperty("language")
    private String language;
    @JsonProperty("lexicalCategory")
    private String lexicalCategory;
    @JsonProperty("notes")
    private List<Note_____> notes = null;
    @JsonProperty("pronunciations")
    private List<Pronunciation__> pronunciations = null;
    @JsonProperty("text")
    private String text;
    @JsonProperty("variantForms")
    private List<VariantForm__> variantForms = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("derivativeOf")
    public List<DerivativeOf> getDerivativeOf() {
        return derivativeOf;
    }

    @JsonProperty("derivativeOf")
    public void setDerivativeOf(List<DerivativeOf> derivativeOf) {
        this.derivativeOf = derivativeOf;
    }

    @JsonProperty("derivatives")
    public List<Derivative> getDerivatives() {
        return derivatives;
    }

    @JsonProperty("derivatives")
    public void setDerivatives(List<Derivative> derivatives) {
        this.derivatives = derivatives;
    }

    @JsonProperty("entries")
    public List<Entry> getEntries() {
        return entries;
    }

    @JsonProperty("entries")
    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    @JsonProperty("grammaticalFeatures")
    public List<GrammaticalFeature___> getGrammaticalFeatures() {
        return grammaticalFeatures;
    }

    @JsonProperty("grammaticalFeatures")
    public void setGrammaticalFeatures(List<GrammaticalFeature___> grammaticalFeatures) {
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

    @JsonProperty("lexicalCategory")
    public String getLexicalCategory() {
        return lexicalCategory;
    }

    @JsonProperty("lexicalCategory")
    public void setLexicalCategory(String lexicalCategory) {
        this.lexicalCategory = lexicalCategory;
    }

    @JsonProperty("notes")
    public List<Note_____> getNotes() {
        return notes;
    }

    @JsonProperty("notes")
    public void setNotes(List<Note_____> notes) {
        this.notes = notes;
    }

    @JsonProperty("pronunciations")
    public List<Pronunciation__> getPronunciations() {
        return pronunciations;
    }

    @JsonProperty("pronunciations")
    public void setPronunciations(List<Pronunciation__> pronunciations) {
        this.pronunciations = pronunciations;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("variantForms")
    public List<VariantForm__> getVariantForms() {
        return variantForms;
    }

    @JsonProperty("variantForms")
    public void setVariantForms(List<VariantForm__> variantForms) {
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
