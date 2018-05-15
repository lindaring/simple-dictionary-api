
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
    "id",
    "language",
    "lexicalEntries",
    "pronunciations",
    "type",
    "word"
})
public class Result {

    @JsonProperty("id")
    public String id;
    @JsonProperty("language")
    public String language;
    @JsonProperty("lexicalEntries")
    public List<LexicalEntry> lexicalEntries = null;
    @JsonProperty("pronunciations")
    public List<Pronunciation___> pronunciations = null;
    @JsonProperty("type")
    public String type;
    @JsonProperty("word")
    public String word;
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
