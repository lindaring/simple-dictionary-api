package com.lindaring.dictionary.service;

import com.lindaring.dictionary.annotation.LogMethod;
import com.lindaring.dictionary.client.DictionaryClientService;
import com.lindaring.dictionary.client.model.meaning.LexicalEntry;
import com.lindaring.dictionary.client.model.meaning.Meaning;
import com.lindaring.dictionary.client.model.meaning.Result;
import com.lindaring.dictionary.client.model.meaning.Sense;
import com.lindaring.dictionary.enumerator.Languages;
import com.lindaring.dictionary.model.Definitions;
import com.lindaring.dictionary.model.PartsOfSpeech;
import com.lindaring.dictionary.model.Word;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DictionaryService {

    @Autowired
    private DictionaryClientService dictionaryClientService;

    /**
     * Get the meaning of the provided word.
     * @param word the word.
     * @return the meaning.
     */
    @LogMethod
    public Word getWord(String word) throws NotFoundException {
        //Todo - get word from cache

        //Todo - if word is present from cache return word otherwise get from service

        return getWordFromService(word);
    }

    @LogMethod
    private Word getWordFromService(String word) throws NotFoundException {
        Meaning meaning = dictionaryClientService.getMeaning(Languages.getId(Languages.ENGLISH), word);
        Optional<Result> result = meaning.getResults().stream().findFirst();

        if (result.isPresent()) {
            return new Word(word.toLowerCase(), getPartsOfSpeech(result.get().getLexicalEntries()));
        }
        throw new NotFoundException("Word not found");
    }

    @LogMethod
    private List<PartsOfSpeech> getPartsOfSpeech(List<LexicalEntry> lexicalEntries) {
        List<PartsOfSpeech> list = new ArrayList<>();
        lexicalEntries.forEach(lexical ->
            lexical.getEntries().forEach(x ->
                list.add(new PartsOfSpeech(lexical.getLexicalCategory(), getDefinitions(x.getSenses())))
            )
        );
        return list;
    }

    @LogMethod
    private Definitions getDefinitions(List<Sense> popMeaning) {
        List<String> list = new ArrayList<>();
        popMeaning.forEach(x -> list.addAll(x.getDefinitions()));
        return new Definitions(list);
    }
}
