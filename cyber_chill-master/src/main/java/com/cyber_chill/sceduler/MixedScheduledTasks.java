package com.cyber_chill.scheduler;

import com.cyber_chill.controller.dto.GameDto;
import com.cyber_chill.entity.Game;
import com.cyber_chill.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class MixedScheduledTasks {

    private final GameService gameService;

    @Autowired
    public MixedScheduledTasks(GameService gameService) {
        this.gameService = gameService;
    }

    @Scheduled(cron = "0 0 0 */1 * ?") // Метод з кроном, що викликається щодня о 00:00 (кожні 24 години)
    public void scheduledTaskWithCron() {
        gameService.getAllGames();
    }

    @Scheduled(fixedRate = 3600000) // Метод, що викликається кожну 1 годину
    public void scheduledTaskWithoutCron() {
        long lastGame = (long) gameService.getAllGames().size();
        gameService.removeGame(lastGame);
        gameService.addOrUpdateGame(new GameDto(new Game("Game A", new ArrayList<>())));
    }
}
