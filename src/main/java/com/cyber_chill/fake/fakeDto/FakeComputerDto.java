package com.cyber_chill.fake.fakeDto;

import com.cyber_chill.fake.fakeEntity.FakeComputer;
import jakarta.validation.constraints.Min;

import java.util.List;
import java.util.stream.Collectors;

public class FakeComputerDto {

    private Long id;

    @Min(0)
    private Double price;
    private List<FakeReserveDto> reservations;
    private List<FakeGameDto> games;

    public FakeComputerDto(FakeComputer computer) {
        this.id = computer.getId();
        this.price = computer.getPrice();
        this.reservations = computer.getReservation().stream()
                .map(FakeReserveDto::new)
                .collect(Collectors.toList());
        this.games = computer.getGames().stream()
                .map(FakeGameDto::new)
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<FakeReserveDto> getReservations() {
        return reservations;
    }

    public void setReservations(List<FakeReserveDto> reservations) {
        this.reservations = reservations;
    }

    public List<FakeGameDto> getGames() {
        return games;
    }

    public void setGames(List<FakeGameDto> games) {
        this.games = games;
    }
}
