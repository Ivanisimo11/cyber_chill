package com.cyber_chill.fake.fakeEntity;

import com.cyber_chill.fake.fakeDto.FakeGameDto;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class FakeGame {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany
    private List<FakeComputer> computers;

    public FakeGame() {
    }

    public FakeGame(String name, List<FakeComputer> computers) {
        this.name = name;
        this.computers = computers;
    }

    public FakeGame(FakeGameDto game) {
        id = game.getId();
        name = game.getName();
    }

    public List<FakeComputer> getComputers() {
        return computers;
    }

    public void setComputers(List<FakeComputer> computers) {
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
