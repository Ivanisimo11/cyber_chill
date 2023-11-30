package com.cyber_chill.dao;

import com.cyber_chill.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();

    public User getUser(Long id);

    public void addOrUpdateUser(User user);

    public void removeUser(Long id);
}
