package com.lindaring.dictionary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Definition {
    private String partsOfSpeech;
    private List<String> definitions;
}
