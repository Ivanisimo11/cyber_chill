package com.cyber_chill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;

@EnableConfigurationProperties
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.cyber_chill"})
public class CyberChillApplication  {

	public static void main(String[] args) {
		SpringApplication.run(CyberChillApplication.class, args);
	}


}
