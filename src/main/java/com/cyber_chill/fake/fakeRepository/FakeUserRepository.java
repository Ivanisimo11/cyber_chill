package com.cyber_chill.fake.fakeRepository;

import com.cyber_chill.fake.fakeEntity.FakeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FakeUserRepository extends JpaRepository<FakeUser, Long> {
    boolean existsByEmail(String email);

    boolean existsByIdIsNotAndEmail(Long id, String email);
}
