package com.example.frank.jpa;

import com.example.frank.jpa.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameUserRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity findOne(Integer id);
    UserEntity findByName(String name);

}

