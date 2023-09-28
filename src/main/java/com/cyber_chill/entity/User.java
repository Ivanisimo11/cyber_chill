package com.cyber_chill.entity;

public class User {
    private Long id;
    private String name;
    private UserRole role;
    private Reserve reservation;

    private UserLevel level;

    public User(Long id, String name, UserRole role, Reserve reservation) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", role=" + role +
                ", Reservation=" + reservation +
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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Reserve getReservation() {
        return reservation;
    }

    public void setReservation(Reserve reservation) {
        this.reservation = reservation;
    }

    public UserLevel getLevel() {
        return level;
    }

    public void setLevel(UserLevel level) {
        this.level = level;
    }
}
