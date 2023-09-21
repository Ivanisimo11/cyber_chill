package com.cyber_chill.dao;

import com.cyber_chill.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAOImpl implements UserDAO{

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUser(Long id) {
        return null;
    }

    @Override
    public void addOrUpdateUser(User user) {

    }

    @Override
    public void removeUser(Long id) {

    }
}
