package com.cyber_chill.service;

import com.cyber_chill.dto.UserDto;
import com.cyber_chill.entity.User;
import com.cyber_chill.exception.ItemAlreadyExists;
import com.cyber_chill.exception.ItemNotFoundException;
import com.cyber_chill.repositories.UserRepository;
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
            throw new ItemNotFoundException("User not found");
    }

    @Override
    public User addUser(UserDto user) {
        if (repository.existsByEmail(user.getEmail())) {
            throw new ItemAlreadyExists("User with such email already exists");
        }
        return repository.save(new User(user));
    }

    @Override
    public User updateUser(Long id, UserDto user) {
        if (repository.existsByIdIsNotAndEmail(id, user.getEmail())) {
            throw new ItemAlreadyExists("User with such email already exists");
        }
        user.setId(id);
        return repository.save(new User(user));
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
