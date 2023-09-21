package com.cyber_chill.entity;

import java.sql.Time;

public class User {
    private Long id;
    private String Name;
    private UserRole role;
    private Reserve Reservation;

    public User(Long id, String name, UserRole role, Reserve reservation) {
        this.id = id;
        Name = name;
        this.role = role;
        Reservation = reservation;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", role=" + role +
                ", Reservation=" + Reservation +
                '}';
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Reserve getReservation() {
        return Reservation;
    }

    public void setReservation(Reserve reservation) {
        Reservation = reservation;
    }
}
