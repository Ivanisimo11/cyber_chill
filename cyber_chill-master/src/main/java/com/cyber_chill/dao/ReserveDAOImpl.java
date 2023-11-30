package com.cyber_chill.dao;

import com.cyber_chill.entity.Reserve;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReserveDAOImpl implements ReserveDAO {
    @Override
    public List<Reserve> getAllReserves() {
        return null;
    }

    @Override
    public Reserve getReserve(Long id) {
        return null;
    }

    @Override
    public void addOrUpdateReserve(Reserve reserve) {

    }

    @Override
    public void removeReserve(Long id) {

    }
}
