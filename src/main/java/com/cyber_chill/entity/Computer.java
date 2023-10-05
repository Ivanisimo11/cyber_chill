package com.cyber_chill.entity;

import jakarta.persistence.*;

import javax.naming.Name;
import java.util.List;

@Entity
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double price;
    @OneToMany
    private List<Reserve> reservations;

    @ManyToMany
    private List<Game> games;

    public Computer() {
    }


    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public Computer(Double price, List<Reserve> reservations, List<Game> games) {
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

    public List<Reserve> getReservation() {
        return reservations;
    }

    public void setReservation(List<Reserve> reservation) {
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
