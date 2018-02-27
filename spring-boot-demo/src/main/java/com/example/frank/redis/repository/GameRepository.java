package com.example.frank.redis.repository;

import com.example.frank.redis.model.Game;

import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, String> {
}
