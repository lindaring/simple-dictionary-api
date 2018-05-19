package com.lindaring.dictionary.service;

import com.lindaring.dictionary.exception.CacheException;
import com.lindaring.dictionary.model.Cache;
import com.lindaring.dictionary.model.Word;
import com.lindaring.dictionary.properties.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.lindaring.dictionary.configuration.CacheConfig.WORD_DEFINITION_CACHE;

@Service
public class CacheService {

    @Autowired
    private MessageProperties messages;

    @CachePut(value = WORD_DEFINITION_CACHE, key = "#key")
    public Word cache(String key, Word value) {
        return value;
    }

    @Cacheable(value = WORD_DEFINITION_CACHE, key = "#key")
    public Optional<Word> get(String key) {
        return Optional.empty();
    }

    public Cache  getAllKeys() throws CacheException {
        List<String> keys = getKeys();
        if (!keys.isEmpty()) {
            return Cache.builder()
                    .keys(keys)
                    .build();
        } else {
            throw new CacheException(messages.getCache().getKeysNotFound());
        }
    }

    @CacheEvict(value = WORD_DEFINITION_CACHE, key = "#key")
    public void remove(String key) {
        return;
    }

    @CacheEvict(value = WORD_DEFINITION_CACHE, allEntries = true)
    public void removeAll () {
        return;
    }

    private List<String> getKeys() {
        return Collections.singletonList(WORD_DEFINITION_CACHE);
    }
}
