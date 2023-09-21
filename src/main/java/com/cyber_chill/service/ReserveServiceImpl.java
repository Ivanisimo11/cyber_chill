package com.cyber_chill.service;

import com.cyber_chill.dao.ReserveDAO;
import com.cyber_chill.entity.Reserve;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReserveServiceImpl implements ReserveService {
    ReserveDAO reserveDAO;

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
        reserveDAO.addOrUpdateReserve(reserve);
    }

    @Override
    public void removeReserve(Long id) {
        reserveDAO.removeReserve(id);
    }
}
