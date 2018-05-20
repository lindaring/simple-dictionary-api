package com.lindaring.dictionary.enumerator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Languages {
    ENGLISH("en", "English"),
    ZULU("zu", "isiZulu"),
    SOTHO("nso", "Nothorn Sotho"),
    TSWANA("tn", "Setswana");

    private String id;
    private String name;

    public static String getId(Languages lang) {
        return lang.id;
    }
}
