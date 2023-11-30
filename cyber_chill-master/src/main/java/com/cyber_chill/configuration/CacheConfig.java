package com.cyber_chill.configuration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cache.CacheManager;

@Configuration
@EnableCaching
public class CacheConfig {

//    @Bean
//    public GameCacheManager gameCacheManager() {
//        return new GameCacheManager();
//    }
//
//    @Bean
//    public CacheInterceptor cacheInterceptor() {
//        CacheInterceptor interceptor = new CacheInterceptor();
//        interceptor.setCacheManager(gameCacheManager());
//        return interceptor;
//    }

}