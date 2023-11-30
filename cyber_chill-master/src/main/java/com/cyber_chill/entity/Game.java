package com.cyber_chill.entity;


import com.cyber_chill.controller.dto.GameDto;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany
    private List<Computer> computers;

    public Game() {
    }

    public Game(String name, List<Computer> computers) {
        this.name = name;
        this.computers = computers;
    }

    public Game(GameDto game) {
        id = game.getId();
        name = game.getName();
    }

    public List<Computer> getComputers() {
        return computers;
    }

    public void setComputers(List<Computer> computers) {
        this.computers = computers;
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

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                '}';
    }
}
