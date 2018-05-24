package com.lindaring.dictionary.client;

import com.lindaring.dictionary.annotation.LogMethod;
import com.lindaring.dictionary.client.model.meaning.Meaning;
import com.lindaring.dictionary.client.model.translation.Translation;
import com.lindaring.dictionary.properties.OxfordApiProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class DictionaryClientService {

    @Autowired
    private OxfordApiProperties oxfordApi;

    @Autowired
    private DictionaryClient client;

    /**
     * Get the meaning of the provided word.
     * @param lang the language.
     * @param word the word.
     * @return the meaning.
     */
    @LogMethod
    public Meaning getMeaning(String lang, String word) {
        return client.getMeaning(oxfordApi.getId(), oxfordApi.getKey(), lang.toLowerCase(), word.toLowerCase());
    }

    /**
     * Get the meaning of the provided word.
     * @param sourceLang the language to translate from.
     * @param word the word to translate.
     * @param targetLang the language to translate to.
     * @return the meaning.
     */
    @LogMethod
    public Translation getTranslation(String sourceLang, String word, String targetLang) {
        return client.getTranslation(oxfordApi.getId(), oxfordApi.getKey(), sourceLang.toLowerCase(), word.toLowerCase(), targetLang);
    }

    @FeignClient(
        name = "DictionaryClient",
        url = "${simple.dictionary.clients.dictionary.url}"
    )
    private interface DictionaryClient {

        @RequestMapping(method = RequestMethod.GET, value = "/entries/{lang}/{word}")
        Meaning getMeaning(@RequestHeader("app_id") String appId,
                           @RequestHeader("app_key") String appKey,
                           @RequestParam("lang") String lang,
                           @RequestParam("word") String word);

        @RequestMapping(method = RequestMethod.GET, value = "/entries/{sourceLang}/{word}/translations={targetLang}")
        Translation getTranslation(@RequestHeader("app_id") String appId,
                           @RequestHeader("app_key") String appKey,
                           @RequestParam("sourceLang") String sourceLang,
                           @RequestParam("word") String word,
                           @RequestParam("targetLang") String targetLang);

    }

}