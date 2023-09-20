package com.cyber_chill.dao;

import com.cyber_chill.entity.Game;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameDAOImpl implements GameDAO {
    @Override
    public List<Game> getAllGames() {
        return null;
    }

    @Override
    public Game getGame(Long id) {
        return null;
    }

    @Override
    public void addOrUpdateGame(Game game) {

    }

    @Override
    public void removeGame(Long id) {

    }
}
