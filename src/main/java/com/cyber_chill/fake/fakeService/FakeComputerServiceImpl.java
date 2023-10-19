package com.cyber_chill.fake.fakeService;

import com.cyber_chill.fake.fakeDto.FakeComputerDto;
import com.cyber_chill.fake.fakeRepository.FakeComputerRepository;
import com.cyber_chill.fake.fakeEntity.FakeComputer;
import com.cyber_chill.exception.ItemNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FakeComputerServiceImpl implements FakeComputerService{

    private FakeComputerRepository repository;

    public FakeComputerServiceImpl(FakeComputerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<FakeComputer> getAllComputers() {
        return repository.findAll();
    }

    @Override
    public FakeComputer getComputer(Long id) {
        Optional<FakeComputer> oComputer = repository.findById(id);
        if(oComputer.isPresent())
            return oComputer.get();
        else
            throw new ItemNotFoundException("Computer not found");
    }

    @Override
    public FakeComputer addOrUpdateComputer(FakeComputerDto computerDto) {
        return repository.save(new FakeComputer(computerDto));
    }

    @Override
    public void removeComputer(Long id) {
        repository.deleteById(id);

    }
}
