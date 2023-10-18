package com.cyber_chill.service;

import com.cyber_chill.dto.ComputerDto;
import com.cyber_chill.entity.Computer;

import java.util.List;

public interface ComputerService {
    List<Computer> getAllComputers();

    Computer getComputer(Long id);

    Computer addOrUpdateComputer(ComputerDto computerDto);

    void removeComputer(Long id);
}
