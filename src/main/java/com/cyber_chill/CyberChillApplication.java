package com.cyber_chill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableConfigurationProperties
@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories(basePackages = {"com.cyber_chill"})
public class CyberChillApplication  {
	public static void main(String[] args) {
		SpringApplication.run(CyberChillApplication.class, args);
	}


}
