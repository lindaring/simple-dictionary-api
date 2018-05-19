package com.lindaring.dictionary.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "simple.dictionary.messages")
public class MessageProperties {
    private Word word = new Word();
    private Cache cache = new Cache();

    @Data
    public static class Word {
        private String notFound;
    }

    @Data
    public static class Cache {
        private String keysNotFound;
    }
}
