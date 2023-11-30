package com.cyber_chill.service;

import com.cyber_chill.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountProperties properties;

    @Override
    public double getDiscount(User user) {
        switch (user.getLevel()) {
            case STARTER -> {
                return properties.getFirstTime();
            }
            case START_LEVEL -> {
                return properties.getStartRegular();
            }
            case MIDDLE_LEVEL -> {
                return properties.getMiddleRegular();
            }
            case VIP_LEVEL -> {
                return properties.getVipRegular();
            }
            default -> {
                return 100;
            }
        }
    }
}
