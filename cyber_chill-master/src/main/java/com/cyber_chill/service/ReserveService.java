package com.cyber_chill.service;

import com.cyber_chill.controller.dto.ReserveDto;
import com.cyber_chill.entity.Reserve;


import java.util.List;

public interface ReserveService {
    public List<Reserve> getAllReserves();

    public Reserve getReserve(Long id);

    public Reserve addOrUpdateReserve(ReserveDto reserve);

    public void removeReserve(Long id);
}

