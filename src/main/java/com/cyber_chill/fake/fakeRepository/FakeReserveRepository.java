package com.cyber_chill.fake.fakeRepository;

import com.cyber_chill.fake.fakeEntity.FakeReserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FakeReserveRepository extends JpaRepository<FakeReserve, Long> {
}
