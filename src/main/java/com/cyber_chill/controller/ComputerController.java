package com.cyber_chill.controller;

import com.cyber_chill.controller.dto.ComputerDto;
import com.cyber_chill.entity.Computer;
import com.cyber_chill.service.ComputerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Computer", description = "Computer CRUD")
@RestController
@RequestMapping("/computer")
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    @Operation(
            summary = "Fetch all computers",
            description = "fetches all computer entities and their data from data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/")
    public List<Computer> getAllComputers() {
        return computerService.getAllComputers();
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}")
    public Computer getComputer(@PathVariable Long id) {
        return computerService.getComputer(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public Computer addComputer(@RequestBody @Validated ComputerDto computer) {
        return computerService.addOrUpdateComputer(computer);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public Computer updateComputer(@PathVariable Long id, @Validated @RequestBody ComputerDto computer) {
        computer.setId(id);
        return computerService.addOrUpdateComputer(computer);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteComputer(@PathVariable Long id) {
        computerService.removeComputer(id);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}/details")
    public String showComputerDetails(@PathVariable Long id, Model model) {
        Computer computer = computerService.getComputer(id);
        model.addAttribute("computer", computer); // Передача об'єкта комп'ютера у модель
        return "computer"; // Назва HTML-шаблону
    }
}
