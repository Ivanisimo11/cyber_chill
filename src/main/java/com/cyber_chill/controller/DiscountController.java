package com.cyber_chill.controller;


import com.cyber_chill.entity.User;
import com.cyber_chill.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/discount")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @GetMapping("/calculate")
    public double calculateDiscount(@RequestBody User user) {
        return discountService.getDiscount(user);
    }
}
