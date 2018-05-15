package com.lindaring.dictionary.client;

import com.lindaring.dictionary.client.model.meaning.Meaning;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
    name = "DictionaryClient",
    url = "https://od-api.oxforddictionaries.com:443/api/v1"
)
public interface DictionaryClient {

    @RequestMapping(method = RequestMethod.GET, value = "/entries/en/ace")
    Meaning getMeaning(@RequestHeader(name = "app_id") String appId, @RequestHeader(name = "app_key") String appKey);

}
