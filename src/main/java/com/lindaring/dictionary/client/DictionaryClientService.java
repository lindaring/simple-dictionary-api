package com.lindaring.dictionary.client;

import com.lindaring.dictionary.annotation.LogMethod;
import com.lindaring.dictionary.client.model.meaning.Meaning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class DictionaryClientService {

    @Value("${simple.dictionary.api.id}")
    private String apiId;

    @Value("${simple.dictionary.api.key}")
    private String apiKey;

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
        return client.getMeaning(apiId, apiKey, lang.toLowerCase(), word.toLowerCase());
    }

    @FeignClient(
            name = "DictionaryClient",
            url = "${simple.dictionary.clients.dictionary.url}"
    )
    public interface DictionaryClient {

        @RequestMapping(method = RequestMethod.GET, value = "/entries/{lang}/{word}")
        Meaning getMeaning(@RequestHeader("app_id") String appId,
                           @RequestHeader("app_key") String appKey,
                           @RequestParam("lang") String lang,
                           @RequestParam("word") String word);

    }

}