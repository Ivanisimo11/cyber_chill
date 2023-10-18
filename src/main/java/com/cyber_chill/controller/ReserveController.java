package com.cyber_chill.controller;

import com.cyber_chill.entity.Reserve;
import com.cyber_chill.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserve")
public class ReserveController {

    @Autowired
    private ReserveService reserveService;

    @GetMapping("/")
    public List<Reserve> getAllReserves() {
        return reserveService.getAllReserves();
    }

    @GetMapping("/{id}")
    public Reserve getReserve(@PathVariable Long id) {
        return reserveService.getReserve(id);
    }

    @PostMapping("/")
    public Reserve addReserve(@RequestBody Reserve reserve) {
        return reserveService.addOrUpdateReserve(reserve);
    }

    @PutMapping("/{id}")
    public Reserve updateReserve(@PathVariable Long id, @RequestBody Reserve reserve) {
        reserve.setId(id);
        return reserveService.addOrUpdateReserve(reserve);
    }

    @DeleteMapping("/{id}")
    public void deleteReserve(@PathVariable Long id) {
        reserveService.removeReserve(id);
    }
}
