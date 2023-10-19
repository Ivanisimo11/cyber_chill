package com.cyber_chill.controller;

import com.cyber_chill.fake.fakeDto.FakeReserveDto;
import com.cyber_chill.fake.fakeEntity.FakeReserve;
import com.cyber_chill.fake.fakeService.FakeReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserve")
public class ReserveController {

    @Autowired
    private FakeReserveService reserveService;

    @GetMapping("/")
    public List<FakeReserve> getAllReserves() {
        return reserveService.getAllReserves();
    }

    @GetMapping("/{id}")
    public FakeReserve getReserve(@PathVariable Long id) {
        return reserveService.getReserve(id);
    }

    @PostMapping("/")
    public FakeReserve addReserve(@RequestBody @Validated FakeReserveDto reserve) {
        return reserveService.addOrUpdateReserve(reserve);
    }

    @PutMapping("/{id}")
    public FakeReserve updateReserve(@PathVariable Long id, @Validated @RequestBody FakeReserveDto reserve) {
        reserve.setId(id);
        return reserveService.addOrUpdateReserve(reserve);
    }

    @DeleteMapping("/{id}")
    public void deleteReserve(@PathVariable Long id) {
        reserveService.removeReserve(id);
    }
}
