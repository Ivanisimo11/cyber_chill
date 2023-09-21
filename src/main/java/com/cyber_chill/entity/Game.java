package com.cyber_chill.entity;


public class Game {
    private Long id;
    private String Name;

    public Game() {
    }

    public Game(Long id, String name) {
        this.id = id;
        Name = name;
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

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                '}';
    }
}
