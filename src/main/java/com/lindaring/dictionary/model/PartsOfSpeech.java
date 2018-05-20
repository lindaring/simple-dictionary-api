package com.lindaring.dictionary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PartsOfSpeech {
    private String name;
    private Definitions definitions;
}
