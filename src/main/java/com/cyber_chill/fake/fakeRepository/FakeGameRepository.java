package com.cyber_chill.fake.fakeRepository;

import com.cyber_chill.fake.fakeEntity.FakeGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FakeGameRepository extends JpaRepository<FakeGame, Long> {
}
