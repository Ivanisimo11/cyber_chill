package com.cyber_chill.controller;

import com.cyber_chill.fake.fakeDto.FakeGameDto;
import com.cyber_chill.fake.fakeEntity.FakeGame;
import com.cyber_chill.fake.fakeService.FakeGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private FakeGameService gameService;

    @GetMapping("/")
    public List<FakeGame> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/{id}")
    public FakeGame getGame(@PathVariable Long id) {
        return gameService.getGame(id);
    }

    @PostMapping("/")
    public FakeGame addGame(@RequestBody @Validated FakeGameDto game) {
        return gameService.addOrUpdateGame(game);
    }

    @PutMapping("/{id}")
    public FakeGame updateGame(@PathVariable Long id, @Validated @RequestBody FakeGameDto game) {
        game.setId(id);
        return gameService.addOrUpdateGame(game);
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable Long id) {
        gameService.removeGame(id);
    }

}
