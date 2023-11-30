package com.cyber_chill.entity;

import com.cyber_chill.controller.dto.ReserveDto;
import jakarta.persistence.*;

import java.time.Duration;
@Entity
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Computer computer;
    private Duration time;

    private Double price;

    public Reserve() {

    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }



    public Reserve(ReserveDto reserveDto) {
        id = reserveDto.getId();
        user = new User();
        user.setId(reserveDto.getUserID());
        computer = new Computer();
        computer.setId(reserveDto.getComputerID());
        time = reserveDto.getTime();
        price = reserveDto.getPrice();
    }

    public Reserve(Long id, User user, Computer computer, Duration time, Double price) {
        this.id = id;
        this.user = user;
        this.computer = computer;
        this.time = time;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Reserve{" +
                "id=" + id +
                ", user=" + user +
                ", computer=" + computer +
                ", time=" + time +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Duration getTime() {
        return time;
    }

    public void setTime(Duration time) {
        this.time = time;
    }
}
