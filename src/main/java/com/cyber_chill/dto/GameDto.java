package com.cyber_chill.dto;


import com.cyber_chill.entity.Game;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class GameDto {
    private Long id;

    @NotNull
    @NotBlank
    private String name;


    public GameDto(Game game) {
        this.id = game.getId();
        this.name = game.getName();
    }

    public GameDto() {
    }

    public GameDto(String name) {
        this.name = name;
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
