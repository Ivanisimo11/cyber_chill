package com.cyber_chill.service;

import com.cyber_chill.controller.dto.UserDto;
import com.cyber_chill.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public User getUser(Long id);

    public void removeUser(Long id);

    User addUser(UserDto user);

    User updateUser(Long id, UserDto user);
}
