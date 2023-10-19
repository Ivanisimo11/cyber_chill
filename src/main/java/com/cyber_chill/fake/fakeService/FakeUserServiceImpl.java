package com.cyber_chill.fake.fakeService;

import com.cyber_chill.fake.fakeDto.FakeUserDto;
import com.cyber_chill.fake.fakeEntity.FakeUser;
import com.cyber_chill.exception.ItemAlreadyExists;
import com.cyber_chill.exception.ItemNotFoundException;
import com.cyber_chill.fake.fakeRepository.FakeUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FakeUserServiceImpl implements FakeUserService {

    private final FakeUserRepository repository;

    public FakeUserServiceImpl(FakeUserRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<FakeUser> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public FakeUser getUser(Long id) {
        Optional<FakeUser> oUser = repository.findById(id);
        if(oUser.isPresent())
            return oUser.get();
        else
            throw new ItemNotFoundException("User not found");
    }

    @Override
    public void removeUser(Long id) {
        repository.deleteById(id);
    }

    @Override
    public FakeUser addUser(FakeUserDto user) {
        if (repository.existsByEmail(user.getEmail())) {
            throw new ItemAlreadyExists("User with such email already exists");
        }
        return repository.save(new FakeUser(user));
    }

    @Override
    public FakeUser updateUser(Long id, FakeUserDto user) {
        if (repository.existsByIdIsNotAndEmail(id, user.getEmail())) {
            throw new ItemAlreadyExists("User with such email already exists");
        }
        user.setId(id);
        return repository.save(new FakeUser(user));
    }


//    private final FakeUserRepository repository;
//
//    public FakeUserServiceImpl(FakeUserRepository repository) {
//        this.repository = repository;
//    }
//
//
//    public List<FakeUser> getAllUsers() {
//        return repository.findAll();
//    }
//
//
//    public FakeUser getUser(Long id) {
//        Optional<FakeUser> oUser = repository.findById(id);
//        if(oUser.isPresent())
//            return oUser.get();
//        else
//            throw new ItemNotFoundException("User not found");
//    }
//
//    @Override
//    public FakeUser addUser(FakeUserDto user) {
//        if (repository.existsByEmail(user.getEmail())) {
//            throw new ItemAlreadyExists("User with such email already exists");
//        }
//        return repository.save(new FakeUser(user));
//    }
//    @Override
//    public FakeUser updateUser(Long id, FakeUserDto user) {
//        if (repository.existsByIdIsNotAndEmail(id, user.getEmail())) {
//            throw new ItemAlreadyExists("User with such email already exists");
//        }
//        user.setId(id);
//        return repository.save(new FakeUser(user));
//    }
//
//    public void removeUser(Long id) {
//        repository.deleteById(id);
//    }
}
