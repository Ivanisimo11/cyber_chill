package com.cyber_chill.entity;

import java.sql.Time;

public class Reserve {
    private Long id;
    private User user;
    private Computer computer;
    private Time time;

    public Reserve() {
    }

    public Reserve(Long id, User user, Computer computer, Time time) {
        this.id = id;
        this.user = user;
        this.computer = computer;
        this.time = time;
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

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
