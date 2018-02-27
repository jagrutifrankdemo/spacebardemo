package com.example.frank.redis.model;

import lombok.Data;

import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.io.Serializable;

@RedisHash("Game")
public class Game implements Serializable {
    @Id
    private String id;
    private String name;
    private String gameDetails;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGameDetails() {
        return gameDetails;
    }

    public void setGameDetails(String gameDetails) {
        this.gameDetails = gameDetails;
    }
}


