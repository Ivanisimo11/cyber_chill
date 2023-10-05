package com.cyber_chill.service;

import com.cyber_chill.dao.ComputerDAO;
import com.cyber_chill.entity.Computer;
import com.cyber_chill.entity.User;
import com.cyber_chill.repositories.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
            throw new RuntimeException("Computer not found");
    }

    @Override
    public Computer addOrUpdateComputer(Computer computer) {
        return repository.save(computer);
    }

    @Override
    public void removeComputer(Long id) {
        repository.deleteById(id);

    }


    //@Autowired
    //private ComputerDAO computerDAO;

//    @Override
//    public List<Computer> getAllComputers() {
//        return computerDAO.getAllComputers();
//    }
//
//    @Override
//    public Computer getComputer(Long id) {
//        return computerDAO.getComputer(id);
//    }
//
//    @Override
//    public void addOrUpdateComputer(Computer computer) {
//        computerDAO.addOrUpdateComputer(computer);
//    }
//
//    @Override
//    public void removeComputer(Long id) {
//        computerDAO.removeComputer(id);
//    }
}
