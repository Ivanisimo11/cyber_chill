package com.cyber_chill.service;

import com.cyber_chill.configuration.GameCacheManager;
import com.cyber_chill.controller.dto.GameDto;
import com.cyber_chill.entity.Game;
import com.cyber_chill.exception.ItemNotFoundException;
import com.cyber_chill.repositories.GameRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class GameServiceImpl implements GameService {

    private GameRepository repository;
    private final GameCacheManager gameCacheManager = new GameCacheManager();

    public GameServiceImpl(GameRepository repository) {
        this.repository = repository;
    }

    @Override
    @Cacheable(value = "games")
    public List<Game> getAllGames() {
        return repository.findAll();
    }

    @Override
    @Cacheable(value = "games", key = "#id")
    public Game getGame(Long id) {
        Optional<Game> oGame = repository.findById(id);
        if(oGame.isPresent())
            return oGame.get();
        else
            throw new ItemNotFoundException("Game not found");
    }

    @CacheEvict(value = "games", allEntries = true, beforeInvocation = true)
    public void removeALl() {
        repository.deleteAll();
    }

    @Override
    public Game addOrUpdateGame(GameDto game) {
        return repository.save(new Game(game));
    }

    @Override
    public void removeGame(Long id) {
        repository.deleteById(id);
    }
}