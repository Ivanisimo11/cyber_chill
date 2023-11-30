package com.cyber_chill.controller.dto;

import com.cyber_chill.entity.Reserve;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.Duration;
public class ReserveDto {
    private Long id;
    @NotNull
    private Long userID;
    @NotNull
    private Long computerID;
    private Duration time;

    @Min(0)
    private Double price;

    public ReserveDto(Reserve reserve) {
        id = reserve.getId();
        userID = new UserDto(reserve.getUser()).getId();
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



    public ReserveDto() {
    }

    public ReserveDto(Long id, Duration time, Double price) {
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
