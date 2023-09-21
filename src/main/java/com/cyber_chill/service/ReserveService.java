package com.cyber_chill.service;

import com.cyber_chill.entity.Reserve;


import java.util.List;

public interface ReserveService {
    public List<Reserve> getAllReserves();

    public Reserve getReserve(Long id);

    public void addOrUpdateReserve(Reserve reserve);

    public void removeReserve(Long id);
}

