package com.cyber_chill;

import com.cyber_chill.entity.Reserve;
import com.cyber_chill.entity.User;
import com.cyber_chill.entity.UserRole;
import com.cyber_chill.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.Arrays;

@EnableConfigurationProperties
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableJpaRepositories(basePackages = {"com.cyber_chill"})
public class CyberChillApplication  {
	public static void main(String[] args) {
		SpringApplication.run(CyberChillApplication.class, args);
	}


}
