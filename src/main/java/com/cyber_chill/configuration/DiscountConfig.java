package com.cyber_chill.configuration;

import com.cyber_chill.entity.User;
import com.cyber_chill.service.DiscountService;
import com.cyber_chill.service.DiscountServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiscountConfig {

    @Bean
    @ConditionalOnProperty(name = "is_discount", prefix = "discount.service", havingValue = "false")
    public DiscountService notDiscountService() {
        return new DiscountService() {
            @Override
            public double getDiscount(User user) {
                return 100;
            }
        };
    }

    @Bean
    @ConditionalOnProperty(name = "is_discount", prefix = "discount.service", havingValue = "true")
    public DiscountService discountService() {
        return new DiscountServiceImpl();
    }


}
