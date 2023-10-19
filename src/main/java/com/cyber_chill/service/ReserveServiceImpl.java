package com.cyber_chill.service;

import com.cyber_chill.controller.dto.ReserveDto;
import com.cyber_chill.entity.Reserve;
import com.cyber_chill.exception.ItemNotFoundException;
import com.cyber_chill.repositories.ReserveRepository;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class ReserveServiceImpl implements ReserveService {

    private final ReserveRepository repository;
    private final DiscountService discountService;

    public ReserveServiceImpl(ReserveRepository repository, DiscountService discountService) {
        this.repository = repository;
        this.discountService = discountService;
    }

    @Override
    public List<Reserve> getAllReserves() {
        return repository.findAll();
    }

    @Override
    public Reserve getReserve(Long id) {
        Optional<Reserve> oReserve = repository.findById(id);
        if(oReserve.isPresent())
            return oReserve.get();
        else
            throw new ItemNotFoundException("Reserve not found");
    }

    @Override
    public Reserve addOrUpdateReserve(ReserveDto reserveDto) {
        var reserve = repository.save(new Reserve(reserveDto));
        double computerPricePerHour = reserve.getComputer().getPrice();
        long hours = reserve.getTime().get(ChronoUnit.HOURS);
        double userDiscount = discountService.getDiscount(reserve.getUser()) / 100;

        reserve.setPrice(computerPricePerHour * hours * userDiscount);
        return repository.save(reserve);
    }

    @Override
    public void removeReserve(Long id) {
        repository.deleteById(id);

    }
    //    ReserveDAO reserveDAO;
//
//
//    private DiscountService discountService;
//
//    @Override
//    public List<Reserve> getAllReserves() {
//        return reserveDAO.getAllReserves();
//    }
//
//    @Override
//    public Reserve getReserve(Long id) {
//        return reserveDAO.getReserve(id);
//    }
//
//    @Override
//    public void addOrUpdateReserve(Reserve reserve) {
//        double computerPricePerHour = reserve.getComputer().getPrice();
//        long hours = reserve.getTime().get(ChronoUnit.HOURS);
//        double userDiscount = discountService.getDiscount(reserve.getUser()) / 100;
//
//        reserve.setPrice(computerPricePerHour * hours * userDiscount);
//        reserveDAO.addOrUpdateReserve(reserve);
//    }
//
//    @Override
//    public void removeReserve(Long id) {
//        reserveDAO.removeReserve(id);
//    }
}
