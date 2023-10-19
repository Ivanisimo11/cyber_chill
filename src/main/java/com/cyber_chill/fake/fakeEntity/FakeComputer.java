package com.cyber_chill.fake.fakeEntity;

import com.cyber_chill.fake.fakeDto.FakeComputerDto;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class FakeComputer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double price;
    @OneToMany
    private List<FakeReserve> reservations;

    @ManyToMany
    private List<FakeGame> games;

    public FakeComputer() {
    }

    public FakeComputer(FakeComputerDto computerDto) {
        id = computerDto.getId();
        price = computerDto.getPrice();
    }


    public List<FakeGame> getGames() {
        return games;
    }

    public void setGames(List<FakeGame> games) {
        this.games = games;
    }

    public FakeComputer(Double price, List<FakeReserve> reservations, List<FakeGame> games) {
        this.price = price;
        this.reservations = reservations;
        this.games = games;
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

    public List<FakeReserve> getReservation() {
        return reservations;
    }

    public void setReservation(List<FakeReserve> reservation) {
        this.reservations = reservation;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", price=" + price +
                ", Reservation=" + reservations +
                '}';
    }
}
