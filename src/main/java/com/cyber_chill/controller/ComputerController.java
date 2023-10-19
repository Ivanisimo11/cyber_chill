package com.cyber_chill.controller;

import com.cyber_chill.fake.fakeDto.FakeComputerDto;
import com.cyber_chill.entity.FakeComputer;
import com.cyber_chill.fake.fakeService.FakeComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/computer")
public class ComputerController {

    @Autowired
    private FakeComputerService computerService;

    @GetMapping("/")
    public List<FakeComputer> getAllComputers() {
        return computerService.getAllComputers();
    }

    @GetMapping("/{id}")
    public FakeComputer getComputer(@PathVariable Long id) {
        return computerService.getComputer(id);
    }

    @PostMapping("/")
    public FakeComputer addComputer(@RequestBody @Validated FakeComputerDto computer) {
        return computerService.addOrUpdateComputer(computer);
    }

    @PutMapping("/{id}")
    public FakeComputer updateComputer(@PathVariable Long id, @Validated @RequestBody FakeComputerDto computer) {
        computer.setId(id);
        return computerService.addOrUpdateComputer(computer);
    }

    @DeleteMapping("/{id}")
    public void deleteComputer(@PathVariable Long id) {
        computerService.removeComputer(id);
    }
}
