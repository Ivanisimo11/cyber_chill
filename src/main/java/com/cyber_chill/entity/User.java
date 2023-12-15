package com.cyber_chill.entity;

import com.cyber_chill.controller.dto.UserDto;
import jakarta.persistence.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private UserRole role;
    private String steamAcc;

    public User(UserDto user) {
        id = user.getId();
        name = user.getName();
        role = user.getRole();
        email = user.getEmail();
        steamAcc = user.getSteamAcc();
        if (reservations != null) {
            reservations = user.getReservations().stream()
                    .map(Reserve::new)
                    .collect(Collectors.toList());
        }
        level = user.getLevel();
    }

    public User(String name, UserRole role, String steamAcc, List<Reserve> reservations) {
        this.name = name;
        this.role = role;
        this.steamAcc = steamAcc;
        this.reservations = reservations;
        this.level = UserLevel.STARTER; // За замовчуванням встановлюємо рівень на STARTER
        checkSteamLevel(steamAcc); // Перевірка рівня Steam після створення користувача
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(unique = true)
    private String email;

    @OneToMany
    private List<Reserve> reservations;

    private UserLevel level;

    public User(String name, UserRole role, String email, String steamAcc, List<Reserve> reservations) {
        this.name = name;
        this.role = role;
        this.email = email;
        this.steamAcc = steamAcc;
        this.reservations = reservations;
        this.level = UserLevel.STARTER; // За замовчуванням встановлюємо рівень на STARTER
        checkSteamLevel(steamAcc); // Перевірка рівня Steam після створення користувача
    }

    private int getSteamLevelByLink(String steamAcc) {
        try {
            Document document = Jsoup.connect(steamAcc).get();
            Elements levelElements = document.select("#responsive_page_template_content > div.no_header.profile_page.has_profile_background > div.profile_header_bg > div > div > div > div.profile_header_badgeinfo > div.profile_header_badgeinfo_badge_area > a > div > div > span");

            if (!levelElements.isEmpty()) {
                Element levelElement = levelElements.first();
                assert levelElement != null;
                String levelText = levelElement.text();
                return Integer.parseInt(levelText);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Обробка помилок, якщо не вдається з'єднатися зі сторінкою Steam або знайти рівень
        }
        return 0; // Повертаємо 0, якщо не вдається отримати інформацію про рівень Steam
    }

    private void checkSteamLevel(String steamAcc) {
        int steamLevel = getSteamLevelByLink(steamAcc);

        if (steamLevel >= 10 && level != UserLevel.START_LEVEL && level != UserLevel.MIDDLE_LEVEL && level != UserLevel.VIP_LEVEL) {
            level = UserLevel.START_LEVEL;
        }
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

    public User() {

    }

    public String getSteamAcc() {
        return steamAcc;
    }

    public void setSteamAcc(String steamAcc) {
        this.steamAcc = steamAcc;
    }

    public List<Reserve> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reserve> reservations) {
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

    public List<Reserve> getReservation() {
        return reservations;
    }

    public void setReservation(List<Reserve> reservation) {
        this.reservations = reservation;
    }

    public UserLevel getLevel() {
        return level;
    }

    public void setLevel(UserLevel level) {
        this.level = level;
    }
}