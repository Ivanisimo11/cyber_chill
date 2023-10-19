package com.cyber_chill.controller;

import com.cyber_chill.fake.fakeDto.FakeUserDto;
import com.cyber_chill.entity.FakeUser;
import com.cyber_chill.fake.fakeService.FakeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private FakeUserService userService;

    @GetMapping("/")
    public List<FakeUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public FakeUser getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping("/")
    public FakeUser addUser(@RequestBody @Validated FakeUserDto user) {
        return userService.addUser(user);
    }

    @PutMapping("/{id}")
    public FakeUser updateUser(@PathVariable Long id, @RequestBody FakeUserDto user) {
        user.setId(id);
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.removeUser(id);
    }
}
