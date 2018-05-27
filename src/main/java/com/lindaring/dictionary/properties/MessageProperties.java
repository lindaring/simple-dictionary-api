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
    private Language language = new Language();
    private Translation translation = new Translation();
    private Word word = new Word();
    private Cache cache = new Cache();

    @Data
    public static class Language {
        private String notSupported;
    }

    @Data
    public static class Translation {
        private String notFound;
        private String sourceNotProvided;
        private String targetNotProvided;
    }

    @Data
    public static class Word {
        private String notFound;
        private String wordNotProvided;
        private String sourceLangNotProvided;
    }

    @Data
    public static class Cache {
        private String namesNotFound;
        private String keysNotFound;
    }
}
