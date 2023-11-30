package com.cyber_chill.controller;

import com.cyber_chill.controller.dto.UserDto;
import com.cyber_chill.entity.User;
import com.cyber_chill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PreAuthorize("isAnonymous()")
    @PostMapping("/")
    public User addUser(@RequestBody @Validated UserDto user) {
        return userService.addUser(user);
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UserDto user) {
        user.setId(id);
        return userService.updateUser(id, user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.removeUser(id);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}/details")
    public String showUserDetails(@PathVariable Long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user); // Передача об'єкта користувача у модель
        return "user"; // Повертаємо назву HTML-шаблону
    }
}
