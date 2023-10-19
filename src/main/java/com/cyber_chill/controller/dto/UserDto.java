
package com.cyber_chill.controller.dto;

import com.cyber_chill.entity.User;
import com.cyber_chill.entity.UserLevel;
import com.cyber_chill.entity.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class UserDto {
    private Long id;

    @NotNull
    @NotBlank
    private String name;
    private UserRole role;
    @NotNull
    @NotBlank
    private String email;
    private String steamAcc;
    private List<ReserveDto> reservations;
    private UserLevel level;

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.role = user.getRole();
        this.email = user.getEmail();
        this.steamAcc = user.getSteamAcc();
        this.reservations = user.getReservations().stream()
                .map(ReserveDto::new)
                .collect(Collectors.toList());
        this.level = user.getLevel();
    }

    public UserDto(String name, UserRole role, String email, String steamAcc, List<ReserveDto> reservations) {
        this.name = name;
        this.role = role;
        this.email = email;
        this.steamAcc = steamAcc;
        this.reservations = reservations;
        this.level = UserLevel.STARTER;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", steamAcc='" + steamAcc + '\'' +
                ", reservations=" + reservations +
                ", level=" + level +
                '}';
    }

    public UserDto() {

    }

    public String getSteamAcc() {
        return steamAcc;
    }

    public void setSteamAcc(String steamAcc) {
        this.steamAcc = steamAcc;
    }

    public List<ReserveDto> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReserveDto> reservations) {
        this.reservations = reservations;
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

    public List<ReserveDto> getReservation() {
        return reservations;
    }

    public void setReservation(List<ReserveDto> reservation) {
        this.reservations = reservation;
    }

    public UserLevel getLevel() {
        return level;
    }

    public void setLevel(UserLevel level) {
        this.level = level;
    }
}

