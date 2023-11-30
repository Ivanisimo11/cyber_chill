package com.cyber_chill.service;

import com.cyber_chill.controller.dto.GameDto;
import com.cyber_chill.entity.Game;

import java.util.List;

public interface GameService {
    public List<Game> getAllGames();

    public Game getGame(Long id);

    public Game addOrUpdateGame(GameDto game);

    public void removeGame(Long id);
}
