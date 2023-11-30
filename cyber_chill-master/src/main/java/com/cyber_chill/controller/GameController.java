package com.cyber_chill.controller;


import com.cyber_chill.controller.dto.GameDto;
import com.cyber_chill.entity.Game;
import com.cyber_chill.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/")
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}")
    public Game getGame(@PathVariable Long id) {
        return gameService.getGame(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public Game addGame(@RequestBody @Validated GameDto game) {
        return gameService.addOrUpdateGame(game);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public Game updateGame(@PathVariable Long id, @Validated @RequestBody GameDto game) {
        game.setId(id);
        return gameService.addOrUpdateGame(game);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable Long id) {
        gameService.removeGame(id);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}/details")
    public String showGameDetails(@PathVariable Long id, Model model) {
        Game game = gameService.getGame(id);
        model.addAttribute("game", game); // Передача об'єкта гри у модель
        return "game"; // Назва HTML-шаблону
    }

}
