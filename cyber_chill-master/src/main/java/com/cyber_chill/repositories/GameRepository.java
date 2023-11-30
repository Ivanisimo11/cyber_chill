package com.cyber_chill.repositories;

import com.cyber_chill.entity.Computer;
import com.cyber_chill.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
