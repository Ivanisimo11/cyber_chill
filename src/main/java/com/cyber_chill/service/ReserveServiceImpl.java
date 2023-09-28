package com.cyber_chill.service;

import com.cyber_chill.dao.ReserveDAO;
import com.cyber_chill.entity.Reserve;
import org.springframework.stereotype.Component;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
public class ReserveServiceImpl implements ReserveService {
    ReserveDAO reserveDAO;


    private DiscountService discountService;

    @Override
    public List<Reserve> getAllReserves() {
        return reserveDAO.getAllReserves();
    }

    @Override
    public Reserve getReserve(Long id) {
        return reserveDAO.getReserve(id);
    }

    @Override
    public void addOrUpdateReserve(Reserve reserve) {
        double computerPricePerHour = reserve.getComputer().getPrice();
        long hours = reserve.getTime().get(ChronoUnit.HOURS);
        double userDiscount = discountService.getDiscount(reserve.getUser()) / 100;

        reserve.setPrice(computerPricePerHour * hours * userDiscount);
        reserveDAO.addOrUpdateReserve(reserve);
    }

    @Override
    public void removeReserve(Long id) {
        reserveDAO.removeReserve(id);
    }
}
