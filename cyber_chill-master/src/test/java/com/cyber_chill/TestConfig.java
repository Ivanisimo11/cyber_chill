package com.cyber_chill;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.cyber_chill.repositories.GameRepository;

@Configuration
public class TestConfig {

    @Bean
    public GameRepository gameRepository() {
        return Mockito.mock(GameRepository.class);
    }
}