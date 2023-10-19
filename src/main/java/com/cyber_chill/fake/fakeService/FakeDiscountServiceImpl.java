package com.cyber_chill.fake.fakeService;

import com.cyber_chill.fake.fakeEntity.FakeUser;
import com.cyber_chill.service.DiscountProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FakeDiscountServiceImpl implements FakeDiscountService {

    @Autowired
    private DiscountProperties properties;
    @Override
    public double getDiscount(FakeUser user) {
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
