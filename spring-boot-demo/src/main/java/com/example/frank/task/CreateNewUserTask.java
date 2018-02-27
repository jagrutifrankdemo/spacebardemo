package com.example.frank.task;

//import com.example.frank.helper.UserHelper;
import com.example.frank.controller.model.UserRequest;
import com.example.frank.service.GameUserService;
import com.frank.core.dto.User;

import java.util.concurrent.Callable;

public class CreateNewUserTask implements Callable<User> {
    private GameUserService userService;
    private  UserRequest userdetails;

    public CreateNewUserTask(GameUserService userService, UserRequest userdetails){
        this.userService=userService;
        this.userdetails=userdetails;
    }


    @Override
    public User call() throws Exception {
        //user HelperClass to convert user to RUser


       // this is to store in redis cache return
        // UserHelper.toDaoUser(userService.cacheUser(UserHelper.toRedisUser(userdetails)));
       // return  userService.saveUserdatabase(userdetails);
        return userService.saveUserdatabase(userdetails);
        //return  userService.saveUserdatabase(userdetails); // this is to save in database

    }
}
