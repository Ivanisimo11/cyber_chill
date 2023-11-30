package com.cyber_chill.dao;

import com.cyber_chill.entity.Game;

import java.util.List;

public interface GameDAO {
    public List<Game> getAllGames();

    public Game getGame(Long id);

    public void addOrUpdateGame(Game game);

    public void removeGame(Long id);
}
