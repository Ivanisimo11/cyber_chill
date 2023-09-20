package com.cyber_chill.dao;

import com.cyber_chill.entity.Computer;
import com.cyber_chill.entity.User;

import java.util.List;

public interface ComputerDAO {
    public List<Computer> getAllComputers();

    public Computer getComputer(Long id);

    public void addOrUpdateComputer(Computer computer);

    public void removeComputer(Long id);
}
