package com.cyber_chill.fake.fakeDto;

import com.cyber_chill.fake.fakeEntity.FakeUser;
import com.cyber_chill.fake.fakeEntity.FakeUserLevel;
import com.cyber_chill.fake.fakeEntity.FakeUserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class FakeUserDto {

    private Long id;

    @NotNull
    @NotBlank
    private String name;
    private FakeUserRole role;
    @NotNull
    @NotBlank
    private String email;
    private String steamAcc;
    private List<FakeReserveDto> reservations;
    private FakeUserLevel level;

    public FakeUserDto(FakeUser user) {
        this.id = user.getId();
        this.name = user.getName();
        this.role = user.getRole();
        this.email = user.getEmail();
        this.steamAcc = user.getSteamAcc();
        this.reservations = user.getReservations().stream()
                .map(FakeReserveDto::new)
                .collect(Collectors.toList());
        this.level = user.getLevel();
    }

    public FakeUserDto(String name, FakeUserRole role, String email, String steamAcc, List<FakeReserveDto> reservations) {
        this.name = name;
        this.role = role;
        this.email = email;
        this.steamAcc = steamAcc;
        this.reservations = reservations;
        this.level = FakeUserLevel.STARTER;
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

    public FakeUserDto() {

    }

    public String getSteamAcc() {
        return steamAcc;
    }

    public void setSteamAcc(String steamAcc) {
        this.steamAcc = steamAcc;
    }

    public List<FakeReserveDto> getReservations() {
        return reservations;
    }

    public void setReservations(List<FakeReserveDto> reservations) {
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

    public FakeUserRole getRole() {
        return role;
    }

    public void setRole(FakeUserRole role) {
        this.role = role;
    }

    public List<FakeReserveDto> getReservation() {
        return reservations;
    }

    public void setReservation(List<FakeReserveDto> reservation) {
        this.reservations = reservation;
    }

    public FakeUserLevel getLevel() {
        return level;
    }

    public void setLevel(FakeUserLevel level) {
        this.level = level;
    }
}
