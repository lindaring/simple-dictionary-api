package com.lindaring.dictionary.service;

import com.lindaring.dictionary.exception.CacheException;
import com.lindaring.dictionary.model.SimpleCache;
import com.lindaring.dictionary.model.Word;
import com.lindaring.dictionary.properties.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.lindaring.dictionary.configuration.CacheConfig.WORD_DEFINITION_CACHE;

@Service
public class CacheService {

    @Autowired
    private GuavaCacheManager cacheManager;

    @Autowired
    private MessageProperties messages;

    @CachePut(value = WORD_DEFINITION_CACHE, key = "#key")
    public Word cache(String key, Word value) {
        return value;
    }

    @CacheEvict(value = WORD_DEFINITION_CACHE, key = "#key")
    public void remove(String key) {
        return;
    }

    @CacheEvict(value = WORD_DEFINITION_CACHE, allEntries = true)
    public void removeAll () {
        return;
    }

    @Cacheable(value = WORD_DEFINITION_CACHE, key = "#key")
    public Optional<Word> get(String key) {
        return Optional.empty();
    }

    public SimpleCache getKeys(String name) throws CacheException {
        GuavaCache cache = (GuavaCache) cacheManager.getCache(name);

        List<String> keys = new ArrayList<>();
        cache.getNativeCache().asMap().values().forEach(word -> keys.add(((Word) word).getWord()));

        if (!keys.isEmpty())
            return SimpleCache.builder()
                    .names(Collections.singletonList(name))
                    .keys(keys)
                    .build();

        throw new CacheException(messages.getCache().getKeysNotFound());
    }

    public SimpleCache getNames() throws CacheException {
        Collection<String> names = cacheManager.getCacheNames();

        if (!names.isEmpty())
            return SimpleCache.builder()
                    .names(names)
                    .build();

        throw new CacheException(messages.getCache().getNamesNotFound());
    }
}
