package com.cyber_chill.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DAOConfig {

    @Bean
    public UserDAO createUserDAO(){
        return new UserDAOImpl();
    }
}
