package com.cyber_chill.service;

import com.cyber_chill.entity.User;
import com.cyber_chill.entity.UserRole;
import com.cyber_chill.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @MockBean
    private UserRepository userRepository; //реп керований моком

    @Test
    public void testGetAllUsers() {
        // Створюємо моковані дані для репа
        User user1 = new User("Niva", UserRole.ADMIN,"niva@gmail.com","https://steamcommunity.com/id/bak4",new ArrayList<>());
        User user2 = new User("Ivan",UserRole.CLIENT,"ivan@gmail.com","https://steamcommunity.com/id/bak3",new ArrayList<>());
        List<User> users = Arrays.asList(user1, user2);

        // мок імітує роботу
        when(userRepository.findAll()).thenReturn(users);
        List<User> userList = userService.getAllUsers();

        // перевірка чи все сходиться
        assertEquals(2, userList.size());
    }
}