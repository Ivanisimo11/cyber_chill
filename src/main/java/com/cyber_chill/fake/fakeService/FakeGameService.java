package com.cyber_chill.fake.fakeService;

import com.cyber_chill.fake.fakeDto.FakeGameDto;
import com.cyber_chill.fake.fakeEntity.FakeGame;

import java.util.List;

public interface FakeGameService {

    public List<FakeGame> getAllGames();

    public FakeGame getGame(Long id);

    public FakeGame addOrUpdateGame(FakeGameDto game);

    public void removeGame(Long id);
}
