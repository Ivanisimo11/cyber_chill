package com.cyber_chill.configuration;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GameCacheManager implements CacheManager {

    private final Map<String, Cache> cacheMap = new HashMap<>();

    @Override
    public Cache getCache(String name) {
        return cacheMap.computeIfAbsent(name, k -> (Cache) new GameCacheManager());
    }

    @Override
    public Collection<String> getCacheNames() {
        return cacheMap.keySet();
    }

    public void addCache(String name, Cache cache) {
        cacheMap.put(name, cache);
    }

    public void clearCache(String cacheName) {
        Cache cache = cacheMap.get(cacheName);
        if (cache != null) {
            cache.clear();
        }
    }
}