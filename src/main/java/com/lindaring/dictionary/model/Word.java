package com.lindaring.dictionary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Word {
    private String word;
    private List<PartsOfSpeech> partsOfSpeech;
}
