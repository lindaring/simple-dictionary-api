package com.lindaring.dictionary.enumerator;

import com.lindaring.dictionary.exception.LanguageNotSupportedException;
import com.lindaring.dictionary.properties.MessageProperties;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Optional;

import static com.lindaring.dictionary.utils.SimpleUtils.ucWord;

@AllArgsConstructor
public enum Language {
    ENGLISH("en", "English"),
    ZULU("zu", "isiZulu"),
    SOTHO("nso", "Nothorn Sotho"),
    TSWANA("tn", "Setswana");

    private String id;
    private String name;

    public static String getId(Language lang) {
        return lang.id;
    }

    public static Language get(String searchName, MessageProperties messages) throws LanguageNotSupportedException {
        Optional<Language> result = Arrays.stream(values())
                .filter(x -> x.name.toLowerCase().contains(searchName.toLowerCase()))
                .findFirst();

        if (result.isPresent())
            return result.get();
        else
            throw new LanguageNotSupportedException(ucWord(searchName) + messages.getLanguage().getNotSupported());
    }

}
