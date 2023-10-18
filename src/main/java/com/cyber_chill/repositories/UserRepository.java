package com.cyber_chill.repositories;

import com.cyber_chill.entity.Computer;
import com.cyber_chill.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    boolean existsByIdIsNotAndEmail(Long id, String email);
}
