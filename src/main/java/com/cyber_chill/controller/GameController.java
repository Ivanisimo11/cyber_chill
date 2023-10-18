package com.cyber_chill.controller;

import com.cyber_chill.dto.GameDto;
import com.cyber_chill.entity.Game;
import com.cyber_chill.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/")
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/{id}")
    public Game getGame(@PathVariable Long id) {
        return gameService.getGame(id);
    }

    @PostMapping("/")
    public Game addGame(@RequestBody @Validated GameDto game) {
        return gameService.addOrUpdateGame(game);
    }

    @PutMapping("/{id}")
    public Game updateGame(@PathVariable Long id, @Validated @RequestBody GameDto game) {
        game.setId(id);
        return gameService.addOrUpdateGame(game);
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable Long id) {
        gameService.removeGame(id);
    }

}
