package com.cyber_chill.service;

import com.cyber_chill.dao.GameDAO;
import com.cyber_chill.entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameServiceImpl implements GameService {

    private GameDAO gameDAO;

    public GameServiceImpl(GameDAO gameDAO) {
        this.gameDAO = gameDAO;
    }

    @Override
    public List<Game> getAllGames() {
        return gameDAO.getAllGames();
    }

    @Override
    public Game getGame(Long id) {
        return gameDAO.getGame(id);
    }

    @Override
    public void addOrUpdateGame(Game game) {
        gameDAO.addOrUpdateGame(game);
    }

    @Override
    public void removeGame(Long id) {
        gameDAO.removeGame(id);
    }
}
