package com.cyber_chill.configuration;

import com.config.StarterCyberChillProperties;
import com.cyber_chill.dao.ReserveDAO;
import com.cyber_chill.dao.ReserveDAOImpl;
import com.service.ContactService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContactConfig {

    @Bean
    @ConditionalOnMissingBean(ContactService.class)
    public ContactService createContactService(){
        StarterCyberChillProperties properties = new StarterCyberChillProperties();
        properties.setContacts("CyberChil@gmail.com");
        return new ContactService(properties);
    }
}
