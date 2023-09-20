package com.cyber_chill.service;

import com.cyber_chill.dao.UserDAO;
import com.cyber_chill.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService{

    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getUser(Long id) {
        return userDAO.getUser(id);
    }

    @Override
    public void addOrUpdateUser(User user) {
        userDAO.addOrUpdateUser(user);
    }

    @Override
    public void removeUser(Long id) {
        userDAO.removeUser(id);
    }
}
