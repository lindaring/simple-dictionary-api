package com.lindaring.dictionary.configuration;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

    public static final String WORD_DEFINITION_CACHE = "WORD_DEFINITION_CACHE";

    @Bean
    public CacheManager cacheManager() {
        CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(7, TimeUnit.DAYS);

        GuavaCacheManager cacheManager = new GuavaCacheManager(WORD_DEFINITION_CACHE);
        cacheManager.setCacheBuilder(cacheBuilder);

        return cacheManager;
    }

}
