package com.cyber_chill.controller.dto;

import com.cyber_chill.entity.Computer;
import jakarta.validation.constraints.Min;

import java.util.List;
import java.util.stream.Collectors;

public class ComputerDto {
    private Long id;

    @Min(0)
    private Double price;
    private List<ReserveDto> reservations;
    private List<GameDto> games;

    public ComputerDto(Computer computer) {
        this.id = computer.getId();
        this.price = computer.getPrice();
        this.reservations = computer.getReservation().stream()
                .map(ReserveDto::new)
                .collect(Collectors.toList());
        this.games = computer.getGames().stream()
                .map(GameDto::new)
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

    public List<ReserveDto> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReserveDto> reservations) {
        this.reservations = reservations;
    }

    public List<GameDto> getGames() {
        return games;
    }

    public void setGames(List<GameDto> games) {
        this.games = games;
    }
}