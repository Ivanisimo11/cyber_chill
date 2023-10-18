package com.cyber_chill.controller;

import com.cyber_chill.dto.ComputerDto;
import com.cyber_chill.entity.Computer;
import com.cyber_chill.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/computer")
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    @GetMapping("/")
    public List<Computer> getAllComputers() {
        return computerService.getAllComputers();
    }

    @GetMapping("/{id}")
    public Computer getComputer(@PathVariable Long id) {
        return computerService.getComputer(id);
    }

    @PostMapping("/")
    public Computer addComputer(@RequestBody @Validated ComputerDto computer) {
        return computerService.addOrUpdateComputer(computer);
    }

    @PutMapping("/{id}")
    public Computer updateComputer(@PathVariable Long id, @Validated @RequestBody ComputerDto computer) {
        computer.setId(id);
        return computerService.addOrUpdateComputer(computer);
    }

    @DeleteMapping("/{id}")
    public void deleteComputer(@PathVariable Long id) {
        computerService.removeComputer(id);
    }
}
