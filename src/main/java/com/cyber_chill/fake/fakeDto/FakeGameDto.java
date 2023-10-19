package com.cyber_chill.fake.fakeDto;

import com.cyber_chill.fake.fakeEntity.FakeGame;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FakeGameDto {

    private Long id;

    @NotNull
    @NotBlank
    private String name;


    public FakeGameDto(FakeGame game) {
        this.id = game.getId();
        this.name = game.getName();
    }

    public FakeGameDto() {
    }

    public FakeGameDto(String name) {
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
