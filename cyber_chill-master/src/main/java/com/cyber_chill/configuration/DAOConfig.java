package com.cyber_chill.configuration;

import com.cyber_chill.dao.ReserveDAO;
import com.cyber_chill.dao.ReserveDAOImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DAOConfig {

    @Bean
    public ReserveDAO createReserveDAO(){
        return new ReserveDAOImpl();
    }
}
