package com.cyber_chill.dao;

import com.cyber_chill.entity.Computer;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ComputerDAOImpl implements ComputerDAO {
    @Override
    public List<Computer> getAllComputers() {
        return null;
    }

    @Override
    public Computer getComputer(Long id) {
        return null;
    }

    @Override
    public void addOrUpdateComputer(Computer computer) {

    }

    @Override
    public void removeComputer(Long id) {

    }
}
