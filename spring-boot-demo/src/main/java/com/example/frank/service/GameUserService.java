package com.example.frank.service;

import com.example.frank.controller.model.UserRequest;
import com.example.frank.redis.model.RedisUser;
import com.frank.core.dto.User;
import com.frank.core.dto.UserMaxGamesPlayed;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface GameUserService {

     RedisUser updateUser(String userid, RedisUser User); //save and updates to RedisCache

     RedisUser cacheUser(RedisUser userdetails); //creates new to Redis Cache

     void purge(String userID); //delete from cache

     UserMaxGamesPlayed getUserMaxGamesPlayed(); // this will query mysql database via JPA - assuming data is store in mysql using another service

     User saveUserdatabase(UserRequest userdetails); //saves to sql database

     public UserMaxGamesPlayed getUserPlayedMaxGamesbetween(Date startdate, Date endDate);
}
