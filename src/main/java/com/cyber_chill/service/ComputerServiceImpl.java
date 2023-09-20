package com.cyber_chill.service;

import com.cyber_chill.dao.ComputerDAO;
import com.cyber_chill.entity.Computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerServiceImpl implements ComputerService{

    @Autowired
    private ComputerDAO computerDAO;

    @Override
    public List<Computer> getAllComputers() {
        return computerDAO.getAllComputers();
    }

    @Override
    public Computer getComputer(Long id) {
        return computerDAO.getComputer(id);
    }

    @Override
    public void addOrUpdateComputer(Computer computer) {
        computerDAO.addOrUpdateComputer(computer);
    }

    @Override
    public void removeComputer(Long id) {
        computerDAO.removeComputer(id);
    }
}
