package com.cyber_chill.fake.fakeRepository;

import com.cyber_chill.fake.fakeEntity.FakeComputer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FakeComputerRepository extends JpaRepository<FakeComputer, Long> {

}
