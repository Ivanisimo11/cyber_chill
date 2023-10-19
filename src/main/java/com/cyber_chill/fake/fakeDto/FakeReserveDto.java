package com.cyber_chill.fake.fakeDto;

import com.cyber_chill.fake.fakeEntity.FakeReserve;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.Duration;

public class FakeReserveDto {

    private Long id;
    @NotNull
    private Long userID;
    @NotNull
    private Long computerID;
    private Duration time;

    @Min(0)
    private Double price;

    public FakeReserveDto(FakeReserve reserve) {
        id = reserve.getId();
        userID = new FakeUserDto(reserve.getUser()).getId();
        computerID = reserve.getComputer().getId();
        time = reserve.getTime();
        price = reserve.getPrice();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }



    public FakeReserveDto() {
    }

    public FakeReserveDto(Long id, Duration time, Double price) {
        this.id = id;
        this.time = time;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Reserve{" +
                "id=" + id +
                ", time=" + time +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Duration getTime() {
        return time;
    }

    public void setTime(Duration time) {
        this.time = time;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getComputerID() {
        return computerID;
    }

    public void setComputerID(Long computerID) {
        this.computerID = computerID;
    }
}
