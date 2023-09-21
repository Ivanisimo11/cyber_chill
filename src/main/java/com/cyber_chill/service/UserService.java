package com.cyber_chill.service;

import com.cyber_chill.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public User getUser(Long id);

    public void addOrUpdateUser(User user);

    public void removeUser(Long id);
}
