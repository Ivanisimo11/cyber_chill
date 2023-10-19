package com.cyber_chill.fake.fakeService;

import com.cyber_chill.fake.fakeDto.FakeUserDto;
import com.cyber_chill.fake.fakeEntity.FakeUser;

import java.util.List;

public interface FakeUserService {

    public List<FakeUser> getAllUsers();

    public FakeUser getUser(Long id);

    public void removeUser(Long id);

    FakeUser addUser(FakeUserDto user);

    FakeUser updateUser(Long id, FakeUserDto user);
}
