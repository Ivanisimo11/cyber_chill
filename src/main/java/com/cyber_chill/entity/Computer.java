package com.cyber_chill.entity;

import java.sql.Time;

public class Computer {
    private Long id;
    private Double price;
    private Reserve Reservation;

    public Computer() {
    }

    public Computer(Long id, Double price, Reserve reservation) {
        this.id = id;
        this.price = price;
        Reservation = reservation;
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

    public Reserve getReservation() {
        return Reservation;
    }

    public void setReservation(Reserve reservation) {
        Reservation = reservation;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", price=" + price +
                ", Reservation=" + Reservation +
                '}';
    }

}
