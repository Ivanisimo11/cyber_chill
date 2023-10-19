package com.cyber_chill.fake.fakeEntity;

import com.cyber_chill.fake.fakeDto.FakeReserveDto;
import jakarta.persistence.*;

import java.time.Duration;

@Entity
public class FakeReserve {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private FakeUser user;
    @ManyToOne
    private FakeComputer computer;
    private Duration time;

    private Double price;

    public FakeReserve() {

    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }



    public FakeReserve(FakeReserveDto reserveDto) {
        id = reserveDto.getId();
        user = new FakeUser();
        user.setId(reserveDto.getUserID());
        computer = new FakeComputer();
        computer.setId(reserveDto.getComputerID());
        time = reserveDto.getTime();
        price = reserveDto.getPrice();
    }

    public FakeReserve(Long id, FakeUser user, FakeComputer computer, Duration time, Double price) {
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

    public FakeUser getUser() {
        return user;
    }

    public void setUser(FakeUser user) {
        this.user = user;
    }

    public FakeComputer getComputer() {
        return computer;
    }

    public void setComputer(FakeComputer computer) {
        this.computer = computer;
    }

    public Duration getTime() {
        return time;
    }

    public void setTime(Duration time) {
        this.time = time;
    }
}
