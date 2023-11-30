package com.cyber_chill.dao;

import com.cyber_chill.entity.Reserve;
import com.cyber_chill.entity.User;

import java.util.List;

public interface ReserveDAO {
    public List<Reserve> getAllReserves();

    public Reserve getReserve(Long id);

    public void addOrUpdateReserve(Reserve reserve);

    public void removeReserve(Long id);
}
