package com.cyber_chill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login"; // This tells Spring to return the login.html template when /login is accessed
    }

    @GetMapping("/logout")
    public String logout() {
        return "home"; // This tells Spring to return the logout.html template when /logout is accessed
    }

}
