package com.cyber_chill.controller;

import com.cyber_chill.fake.fakeEntity.FakeUser;
import com.cyber_chill.fake.fakeService.FakeDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/discount")
public class DiscountController {

    @Autowired
    private FakeDiscountService discountService;

    @GetMapping("/calculate")
    public double calculateDiscount(@RequestBody FakeUser user) {
        return discountService.getDiscount(user);
    }
}
