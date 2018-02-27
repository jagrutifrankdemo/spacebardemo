package com.example.frank.task;

import com.example.frank.service.GameUserService;
import com.frank.core.dto.User;
import com.frank.core.dto.UserMaxGamesPlayed;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

public class UserInfoTask implements Callable<UserMaxGamesPlayed> {


    private GameUserService userService;
   // private final long date;
    public UserInfoTask(GameUserService userService){
        this.userService=userService;
     //   this.date=date; //can pass parameter to narrow it down
    }

    @Override
    public UserMaxGamesPlayed call() throws Exception {
        //call the service to do the task User service to get user played Max number of Games
        // return userService.getUserMaxGamesPlayed(); // this gets user played in last 7 days
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateInString = "20-02-2018 00:20:56";
        Date date = sdf.parse(dateInString);
        //System.out.println(date);
      return userService.getUserPlayedMaxGamesbetween(date,new java.util.Date() );
    }
}
