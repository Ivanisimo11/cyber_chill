package com.cyber_chill.service;

import com.cyber_chill.controller.dto.ComputerDto;
import com.cyber_chill.entity.Computer;
import com.cyber_chill.exception.ItemNotFoundException;
import com.cyber_chill.repositories.ComputerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerServiceImpl implements ComputerService{

    private ComputerRepository repository;

    public ComputerServiceImpl(ComputerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Computer> getAllComputers() {
        return repository.findAll();
    }

    @Override
    public Computer getComputer(Long id) {
        Optional<Computer> oComputer = repository.findById(id);
        if(oComputer.isPresent())
            return oComputer.get();
        else
            throw new ItemNotFoundException("Computer not found");
    }

    @Override
    public Computer addOrUpdateComputer(ComputerDto computerDto) {
        return repository.save(new Computer(computerDto));
    }

    @Override
    public void removeComputer(Long id) {
        repository.deleteById(id);

    }
}
