package com.cyber_chill.bean;

import com.cyber_chill.TestConfig;
import com.cyber_chill.repositories.GameRepository;
import com.cyber_chill.service.GameService;
import com.cyber_chill.service.GameServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.cyber_chill.entity.Game;
import com.cyber_chill.exception.ItemNotFoundException;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = TestConfig.class)
public class GameServiceTest {

    @Autowired
    private GameServiceImpl gameService;

    @Autowired
    private GameRepository gameRepository; // Inject the mocked repository

    @Test
    public void testGetGame() {
        // Arrange
        Game game = new Game();
        game.setId(1L);
        Mockito.when(gameRepository.findById(1L)).thenReturn(Optional.of(game));

        // Act
        Game result = gameService.getGame(1L);

        // Assert
        Assert.assertEquals(game, result);
    }

}
