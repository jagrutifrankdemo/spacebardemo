package com.example.frank.redis.repository;

import com.example.frank.redis.model.RedisUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<RedisUser, String> {
}
