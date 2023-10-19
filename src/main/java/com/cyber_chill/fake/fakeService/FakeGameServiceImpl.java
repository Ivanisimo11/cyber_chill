package com.cyber_chill.fake.fakeService;

import com.cyber_chill.fake.fakeDto.FakeGameDto;
import com.cyber_chill.fake.fakeEntity.FakeGame;
import com.cyber_chill.exception.ItemNotFoundException;
import com.cyber_chill.fake.fakeRepository.FakeGameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FakeGameServiceImpl implements FakeGameService {

    private FakeGameRepository repository;

    public FakeGameServiceImpl(FakeGameRepository repository) {
        this.repository = repository;
    }
    @Override
    public List<FakeGame> getAllGames() {
        return repository.findAll();
    }

    @Override
    public FakeGame getGame(Long id) {
        Optional<FakeGame> oGame = repository.findById(id);
        if(oGame.isPresent())
            return oGame.get();
        else
            throw new ItemNotFoundException("Game not found");
    }
    @Override
    public FakeGame addOrUpdateGame(FakeGameDto game) {
        return repository.save(new FakeGame(game));
    }

    @Override
    public void removeGame(Long id) {
        repository.deleteById(id);

    }
}
