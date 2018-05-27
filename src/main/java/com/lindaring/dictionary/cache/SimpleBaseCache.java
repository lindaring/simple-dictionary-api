package com.lindaring.dictionary.cache;

import com.lindaring.dictionary.exception.CacheException;
import com.lindaring.dictionary.model.SimpleCache;
import com.lindaring.dictionary.model.Word;
import com.lindaring.dictionary.properties.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class SimpleBaseCache {

    @Autowired
    protected GuavaCacheManager cacheManager;

    @Autowired
    protected MessageProperties messages;

    public void removeAll() {
        Collection<String> names = cacheManager.getCacheNames();
        names.forEach(this::removeCacheByName);
    }

    public void removeCacheByName(String cacheName) {
        GuavaCache cache = (GuavaCache) cacheManager.getCache(cacheName);
        cache.clear();
    }

    public Word getValue(String cacheName, String key) throws CacheException {
        GuavaCache cache = (GuavaCache) cacheManager.getCache(cacheName);
        Cache.ValueWrapper value = cache.get(key);
        if (value != null)
            return (Word) value.get();
        else
            throw new CacheException(messages.getCache().getKeysNotFound());
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
