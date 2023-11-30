package com.cyber_chill.service;

import com.cyber_chill.controller.dto.GameDto;
import com.cyber_chill.entity.Game;
import com.cyber_chill.exception.ItemNotFoundException;
import com.cyber_chill.repositories.GameRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class GameServiceImpl implements GameService {

    private GameRepository repository;

    public GameServiceImpl(GameRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Game> getAllGames() {
        return repository.findAll();
    }

    @Override
    public Game getGame(Long id) {
        Optional<Game> oGame = repository.findById(id);
        if(oGame.isPresent())
            return oGame.get();
        else
            throw new ItemNotFoundException("Game not found");
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
