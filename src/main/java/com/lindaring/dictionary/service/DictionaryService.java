package com.lindaring.dictionary.service;

import com.lindaring.dictionary.annotation.LogMethod;
import com.lindaring.dictionary.aspect.LogAspect;
import com.lindaring.dictionary.client.DictionaryClientService;
import com.lindaring.dictionary.client.model.meaning.LexicalEntry;
import com.lindaring.dictionary.client.model.meaning.Meaning;
import com.lindaring.dictionary.client.model.meaning.Result;
import com.lindaring.dictionary.client.model.meaning.Sense;
import com.lindaring.dictionary.enumerator.Languages;
import com.lindaring.dictionary.exception.WordNotFoundException;
import com.lindaring.dictionary.model.Definitions;
import com.lindaring.dictionary.model.PartsOfSpeech;
import com.lindaring.dictionary.model.Word;
import com.lindaring.dictionary.properties.MessageProperties;
import com.lindaring.dictionary.utils.SimpleUtils;
import feign.FeignException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class DictionaryService {

    private static final Logger log = Logger.getLogger(LogAspect.class);

    @Autowired
    private DictionaryClientService dictionaryClientService;

    @Autowired
    private CacheService cacheService;

    @Autowired
    private MessageProperties messages;

    /**
     * Get the meaning of the provided word.
     * @param word the word.
     * @return the meaning.
     */
    @LogMethod
    public Word getWord(String word) throws WordNotFoundException {
        Optional<Word> optionalResponse = cacheService.get(word.toLowerCase());

        if (optionalResponse.isPresent())
            return optionalResponse.get();

        try {
            Word response = getWordFromService(word);
            cacheService.cache(response.getWord(), response);
            return response;

        } catch (FeignException e) {
            if (e.status() == HttpStatus.NOT_FOUND.value())
                throw new WordNotFoundException(messages.getWordNotFound());

            throw e;
        }
    }

    @LogMethod
    private Word getWordFromService(String word) throws WordNotFoundException {
        Meaning meaning = dictionaryClientService.getMeaning(Languages.getId(Languages.ENGLISH), word);
        Optional<Result> result = meaning.getResults().stream().findFirst();

        if (result.isPresent())
            return new Word(word.toLowerCase(), getPartsOfSpeech(result.get().getLexicalEntries()));

        throw new WordNotFoundException(messages.getWordNotFound());
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
        popMeaning.forEach(x -> SimpleUtils.addAllNotNull(list, x.getDefinitions()));
        return new Definitions(list);
    }

}
