package com.cyber_chill.service;

import com.cyber_chill.dao.UserDAO;
import com.cyber_chill.entity.User;
import com.cyber_chill.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getUser(Long id) {
        Optional<User> oUser = repository.findById(id);
        if(oUser.isPresent())
            return oUser.get();
        else
            throw new RuntimeException("User not found");
    }

    @Override
    public User addOrUpdateUser(User user) {
        return repository.save(user);
    }

    @Override
    public void removeUser(Long id) {
        repository.deleteById(id);
    }
    //    private UserDAO userDAO;
//
//    @Autowired
//    public void setUserDAO(UserDAO userDAO) {
//        this.userDAO = userDAO;
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        return userDAO.getAllUsers();
//    }
//
//    @Override
//    public User getUser(Long id) {
//        return userDAO.getUser(id);
//    }
//
//    @Override
//    public void addOrUpdateUser(User user) {
//        userDAO.addOrUpdateUser(user);
//    }
//
//    @Override
//    public void removeUser(Long id) {
//        userDAO.removeUser(id);
//    }
}
