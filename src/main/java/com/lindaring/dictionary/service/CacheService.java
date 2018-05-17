package com.lindaring.dictionary.service;

import com.lindaring.dictionary.model.Word;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CacheService {

    private final String WORD_DEFINITION_CACHE = "WORD_DEFINITION_CACHE";

    @CachePut(value = WORD_DEFINITION_CACHE, key = "#key")
    public Word cache(String key, Word value) {
        return value;
    }

    @Cacheable(value = WORD_DEFINITION_CACHE, key = "#key")
    public Optional<Word> get(String key) {
        return Optional.empty();
    }

    @CacheEvict(value = WORD_DEFINITION_CACHE, key = "#key")
    public void remove(String key) {
        return;
    }

    @CacheEvict(value = WORD_DEFINITION_CACHE, allEntries = true)
    public void removeAll () {
        return;
    }
}
