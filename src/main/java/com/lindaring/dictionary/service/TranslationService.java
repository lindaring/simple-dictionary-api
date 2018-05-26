package com.lindaring.dictionary.service;

import com.lindaring.dictionary.annotation.LogMethod;
import com.lindaring.dictionary.client.DictionaryClientService;
import com.lindaring.dictionary.client.model.translation.LexicalEntry;
import com.lindaring.dictionary.client.model.translation.Result;
import com.lindaring.dictionary.client.model.translation.Sense;
import com.lindaring.dictionary.client.model.translation.Translation;
import com.lindaring.dictionary.client.model.translation.Translation__;
import com.lindaring.dictionary.enumerator.Languages;
import com.lindaring.dictionary.exception.WordNotFoundException;
import com.lindaring.dictionary.model.Definitions;
import com.lindaring.dictionary.model.PartsOfSpeech;
import com.lindaring.dictionary.model.Word;
import com.lindaring.dictionary.properties.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
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
    private MessageProperties messages;

    @LogMethod
    public Word getTranslation(String word) throws WordNotFoundException {
        return getTranslationFromService(word);
    }

    @LogMethod
    private Word getTranslationFromService(String word) throws WordNotFoundException {
        Translation translation = dictionaryClientService.getTranslation(Languages.getId(Languages.ENGLISH), word, Languages.getId(Languages.ZULU));
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

    //TODO - Implement cache for translation
    //TODO - Put dictionary cache inside dictionary service
    //TODO - Refactor service code
    //TODO - Refactor dictionary models
}
