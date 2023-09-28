package com.cyber_chill.entity;

public class Computer {
    private Long id;
    private Double price;
    private Reserve reservation;

    public Computer() {
    }

    public Computer(Long id, Double price, Reserve reservation) {
        this.id = id;
        this.price = price;
        this.reservation = reservation;
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
        return reservation;
    }

    public void setReservation(Reserve reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", price=" + price +
                ", Reservation=" + reservation +
                '}';
    }

}
