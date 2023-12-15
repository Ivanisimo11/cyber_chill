package com.cyber_chill.controller;

import com.cyber_chill.controller.dto.ReserveDto;
import com.cyber_chill.entity.Reserve;
import com.cyber_chill.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reserve/")
public class ReserveController {

    @Autowired
    private ReserveService reserveService;

//    @PreAuthorize("isAuthenticated()")
//    @GetMapping("/")
//    public List<Reserve> getAllReserves() {
//        return reserveService.getAllReserves();
//    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/")
    public String rev()
    {
        return "reserve";
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}")
    public Reserve getReserve(@PathVariable Long id) {
        return reserveService.getReserve(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public Reserve addReserve(@RequestBody @Validated ReserveDto reserve) {
        return reserveService.addOrUpdateReserve(reserve);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public Reserve updateReserve(@PathVariable Long id, @Validated @RequestBody ReserveDto reserve) {
        reserve.setId(id);
        return reserveService.addOrUpdateReserve(reserve);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteReserve(@PathVariable Long id) {
        reserveService.removeReserve(id);
    }
}
