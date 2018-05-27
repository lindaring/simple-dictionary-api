package com.lindaring.dictionary.service;

import com.lindaring.dictionary.annotation.LogMethod;
import com.lindaring.dictionary.cache.TranslationCache;
import com.lindaring.dictionary.client.DictionaryClientService;
import com.lindaring.dictionary.client.model.translation.LexicalEntry;
import com.lindaring.dictionary.client.model.translation.Result;
import com.lindaring.dictionary.client.model.translation.Sense;
import com.lindaring.dictionary.client.model.translation.Translation;
import com.lindaring.dictionary.client.model.translation.Translation__;
import com.lindaring.dictionary.enumerator.Language;
import com.lindaring.dictionary.exception.WordNotFoundException;
import com.lindaring.dictionary.model.Definitions;
import com.lindaring.dictionary.model.PartsOfSpeech;
import com.lindaring.dictionary.model.Word;
import com.lindaring.dictionary.properties.MessageProperties;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.util.StringUtils.isEmpty;

@Service
public class TranslationService {

    @Autowired
    private DictionaryClientService dictionaryClientService;

    @Autowired
    private TranslationCache translationCache;

    @Autowired
    private MessageProperties messages;

    @LogMethod
    public Word getTranslation(String word, Language source, Language target) throws WordNotFoundException {
        Optional<Word> optionalResponse = translationCache.get(String.format("%s_%s", word.toLowerCase(), target));

        if (optionalResponse.isPresent())
            return optionalResponse.get();

        try {
            Word response = getTranslationFromService(word, source, target);
            translationCache.cache(String.format("%s_%s", response.getWord().toLowerCase(), target), response);
            return response;

        } catch (FeignException e) {
            if (e.status() == HttpStatus.NOT_FOUND.value())
                throw new WordNotFoundException(messages.getWord().getNotFound());

            throw e;
        }
    }

    @LogMethod
    private Word getTranslationFromService(String word, Language source, Language target) throws WordNotFoundException {
        Translation translation = dictionaryClientService.getTranslation(word, Language.getId(source), Language.getId(target));
        Optional<Result> result = translation.getResults().stream().findFirst();

        if (result.isPresent())
            return new Word(word.toLowerCase(), getPartsOfSpeech(result.get().getLexicalEntries()));

        throw new WordNotFoundException(messages.getTranslation().getNotFound());
    }

    @LogMethod
    private List<PartsOfSpeech> getPartsOfSpeech(List<LexicalEntry> lexicalEntries) {
        List<PartsOfSpeech> list = new ArrayList<>();
        lexicalEntries.forEach(lexical ->
                lexical.getEntries().forEach(x ->
                        list.add(new PartsOfSpeech(lexical.getLexicalCategory(), getTranslations(x.getSenses())))
                )
        );
        return list;
    }

    @LogMethod
    private Definitions getTranslations(List<Sense> popMeaning) {
        Definitions definitions = new Definitions();
        popMeaning.forEach(x -> definitions.setDefinitions(getTransaltionsAsList(x.getTranslations())));
        return definitions;
    }

    @LogMethod
    private List<String> getTransaltionsAsList(List<Translation__> translations) {
        List<String> list = new ArrayList<>();
        translations.forEach(x -> {
            if (x != null && !isEmpty(x.getText())) list.add(x.getText());
        });
        return list;
    }

}
