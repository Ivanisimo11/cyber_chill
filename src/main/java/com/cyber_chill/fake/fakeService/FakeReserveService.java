package com.cyber_chill.fake.fakeService;

import com.cyber_chill.fake.fakeDto.FakeReserveDto;
import com.cyber_chill.fake.fakeEntity.FakeReserve;

import java.util.List;

public interface FakeReserveService {

    public List<FakeReserve> getAllReserves();

    public FakeReserve getReserve(Long id);

    public FakeReserve addOrUpdateReserve(FakeReserveDto reserve);

    public void removeReserve(Long id);
}
