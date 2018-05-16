package com.lindaring.dictionary.service;

import com.lindaring.dictionary.annotation.LogMethod;
import com.lindaring.dictionary.client.DictionaryClientService;
import com.lindaring.dictionary.client.model.meaning.Meaning;
import com.lindaring.dictionary.client.model.meaning.Result;
import com.lindaring.dictionary.model.Definition;
import com.lindaring.dictionary.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DictionaryService {

    @Value("${simple.dictionary.language}")
    private String lang;

    @Autowired
    private DictionaryClientService dictionaryClientService;

    /**
     * Get the meaning of the provided word.
     * @param word the word.
     * @return the meaning.
     */
    @LogMethod
    public Word getWordMeaning(String word) {
        //Todo - implemet cache
        Meaning meaning = dictionaryClientService.getMeaning(lang, word);

        List<Definition> meanings = new ArrayList<>();

        Optional<Result> result = meaning.getResults().stream().findFirst();

        //Todo - refactor section
        if (result.isPresent()) {
            result.get().getLexicalEntries().forEach(lexicalEntry -> {
                List<String> listOfDefinitions = new ArrayList<>();

                lexicalEntry.getEntries().forEach(x ->
                    x.getSenses().forEach(y -> listOfDefinitions.addAll(y.getDefinitions()))
                );

                meanings.add(new Definition(lexicalEntry.getLexicalCategory(), listOfDefinitions));
            });
        }

        return new Word(word.toLowerCase(), meanings);
    }
}
