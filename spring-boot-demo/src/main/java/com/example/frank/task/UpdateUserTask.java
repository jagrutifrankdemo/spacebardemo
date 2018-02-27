package com.example.frank.task;

import com.example.frank.helper.UserHelper;
import com.example.frank.service.GameUserService;
import com.frank.core.dto.User;

import java.util.concurrent.Callable;

public class UpdateUserTask implements Callable<User> {
    private GameUserService userService;
    private  User userdetails;

    public UpdateUserTask(GameUserService userService, User userdetails){
        this.userService=userService;
        this.userdetails=userdetails;
    }

    @Override
    public User call() throws Exception {
      return  UserHelper.toDaoUser(userService.updateUser(userdetails.getUserID(),UserHelper.toRedisUser(userdetails)));
   }
}
