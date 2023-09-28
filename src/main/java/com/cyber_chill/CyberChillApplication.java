package com.cyber_chill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@EnableConfigurationProperties
@SpringBootApplication
public class CyberChillApplication  {

	public static void main(String[] args) {
		SpringApplication.run(CyberChillApplication.class, args);
	}


}
