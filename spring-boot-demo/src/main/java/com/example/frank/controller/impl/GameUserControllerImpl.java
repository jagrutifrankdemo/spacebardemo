package com.example.frank.controller.impl;

import com.example.frank.controller.GameUserController;
import com.example.frank.controller.model.UserRequest;
import com.example.frank.service.GameUserService;
import com.example.frank.task.CreateNewUserTask;
import com.example.frank.task.UpdateUserTask;
import com.example.frank.task.UserInfoTask;
import com.frank.core.dto.User;
import com.frank.core.dto.UserMaxGamesPlayed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

public class GameUserControllerImpl implements GameUserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GameUserControllerImpl.class);
    private static int taskId = 0;

    @Autowired
    GameUserService userService; // controller to provide service to task


    /*@Override
    public String getException() {
            LOGGER.debug("Get GameUser Exception");
        }*/

    @Override
    public Callable<UserMaxGamesPlayed> getUserPlayedMaxGames() {
        int id = ++taskId;
        LOGGER.debug("Get getUserPlayedMaxGames");
        UserInfoTask task=null;
        try{
            task= new UserInfoTask(userService); // to query JPA database via views
        }catch (Exception e){
            e.printStackTrace(); // I want to explicitly print exception for tracing the error - controller advice is useful
        }
        return task;
    }

    @Override
    public Callable<User> saveUser(UserRequest userdetails) {
        int id = ++taskId;
        LOGGER.debug("saveUser");
        CreateNewUserTask task=null;
        try{
            task= new CreateNewUserTask(userService, userdetails); //creates the user in d/b
        }catch (Exception e){
            e.printStackTrace();
        }
        return task;
    }

    @Override
    public Callable<User> updateUser(User userdetails, int userid) {
        int id = ++taskId;
        LOGGER.debug(" updateUser");
        UpdateUserTask task=null;
        try{
            task= new UpdateUserTask(userService, userdetails); //Updates the user in redis cache
        }catch (Exception e){
            e.printStackTrace();
        }
        return task;
    }

    @Override
    public String testing(UserRequest u) {
        String s= "hi";
        return  "Hello, testing controller" ;
    }

    private long toMillis(String myDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = sdf.parse(myDate);
        long millis = date.getTime();
        return millis;
    }
}
