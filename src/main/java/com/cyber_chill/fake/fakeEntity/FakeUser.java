package com.cyber_chill.fake.fakeEntity;

import com.cyber_chill.fake.fakeDto.FakeUserDto;
import jakarta.persistence.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "_user")
public class FakeUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private FakeUserRole role;

    public FakeUser(FakeUserDto user) {
        id = user.getId();
        name = user.getName();
        role = user.getRole();
        email = user.getEmail();
        steamAcc = user.getSteamAcc();
        if (reservations != null) {
            reservations = user.getReservations().stream()
                    .map(FakeReserve::new)
                    .collect(Collectors.toList());
        }
        level = user.getLevel();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(unique = true)
    private String email;
    private String steamAcc;

    @OneToMany
    private List<FakeReserve> reservations;

    private FakeUserLevel level;

    public FakeUser(String name, FakeUserRole role, String email, String steamAcc, List<FakeReserve> reservations) {
        this.name = name;
        this.role = role;
        this.email = email;
        this.steamAcc = steamAcc;
        this.reservations = reservations;
        this.level = FakeUserLevel.STARTER; // За замовчуванням встановлюємо рівень на STARTER
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

        if (steamLevel >= 10 && level != FakeUserLevel.START_LEVEL && level != FakeUserLevel.MIDDLE_LEVEL && level != FakeUserLevel.VIP_LEVEL) {
            level = FakeUserLevel.START_LEVEL;
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

    public FakeUser() {

    }

    public String getSteamAcc() {
        return steamAcc;
    }

    public void setSteamAcc(String steamAcc) {
        this.steamAcc = steamAcc;
    }

    public List<FakeReserve> getReservations() {
        return reservations;
    }

    public void setReservations(List<FakeReserve> reservations) {
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

    public List<FakeReserve> getReservation() {
        return reservations;
    }

    public void setReservation(List<FakeReserve> reservation) {
        this.reservations = reservation;
    }

    public FakeUserLevel getLevel() {
        return level;
    }

    public void setLevel(FakeUserLevel level) {
        this.level = level;
    }
}
