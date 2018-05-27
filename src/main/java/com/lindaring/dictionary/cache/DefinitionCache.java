package com.lindaring.dictionary.cache;

import com.lindaring.dictionary.model.Word;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.lindaring.dictionary.configuration.CacheConfig.WORD_DEFINITION_CACHE;

@Service
public class DefinitionCache extends SimpleBaseCache {

    @CachePut(value = WORD_DEFINITION_CACHE, key = "#key")
    public Word cache(String key, Word value) {
        return value;
    }

    @Cacheable(value = WORD_DEFINITION_CACHE, key = "#key")
    public Optional<Word> get(String key) {
        return Optional.empty();
    }

}