package com.cyber_chill.fake.fakeService;

import com.cyber_chill.fake.fakeDto.FakeComputerDto;
import com.cyber_chill.fake.fakeEntity.FakeComputer;

import java.util.List;

public interface FakeComputerService {

    List<FakeComputer> getAllComputers();

    FakeComputer getComputer(Long id);

    FakeComputer addOrUpdateComputer(FakeComputerDto computerDto);

    void removeComputer(Long id);
}
