package com.cyber_chill.fake.fakeService;

import com.cyber_chill.fake.fakeDto.FakeReserveDto;
import com.cyber_chill.fake.fakeEntity.FakeReserve;
import com.cyber_chill.exception.ItemNotFoundException;
import com.cyber_chill.fake.fakeRepository.FakeReserveRepository;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class FakeReserveServiceImpl implements FakeReserveService {
    private final FakeReserveRepository repository;
    private final FakeDiscountService discountService;

    public FakeReserveServiceImpl(FakeReserveRepository repository, FakeDiscountService discountService) {
        this.repository = repository;
        this.discountService = discountService;
    }
    @Override
    public List<FakeReserve> getAllReserves() {
        return repository.findAll();
    }
    @Override
    public FakeReserve getReserve(Long id) {
        Optional<FakeReserve> oReserve = repository.findById(id);
        if(oReserve.isPresent())
            return oReserve.get();
        else
            throw new ItemNotFoundException("Reserve not found");
    }
    @Override
    public FakeReserve addOrUpdateReserve(FakeReserveDto reserveDto) {
        var reserve = repository.save(new FakeReserve(reserveDto));
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
}
