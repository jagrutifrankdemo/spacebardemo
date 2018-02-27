package com.example.frank.controller;

import com.example.frank.controller.model.UserRequest;
import com.frank.core.dto.User;
import com.frank.core.dto.UserMaxGamesPlayed;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Callable;
@RestController
@RequestMapping("/public/info")
public interface GameUserController {

    /*@ExceptionHandler(Exception.class) //custom exception for class level incase different than custom advice is required
    @ResponseBody
    String getException();*/

    @RequestMapping(value="getMax", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    Callable<UserMaxGamesPlayed> getUserPlayedMaxGames(); //it should return DTO of User from core library and not the redis cache model
    //Callable<User> getUserPlayedMaxGames(@RequestBody final Date date); // can be parametersed

    @RequestMapping(value="saveuser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    Callable<User> saveUser(@RequestBody final UserRequest userdetails);


    @RequestMapping(value="update", method= RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    Callable<User> updateUser(@RequestBody final User userdetails, int userid); //it should return DTO of User from core library and not the redis cache model

 /*   @RequestMapping(value="jagrutfi", method= RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    String getBooking(@RequestBody final  User user); //it should return html
*/
    @RequestMapping(value="jagruti", method= RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    @ResponseBody
    String testing( @RequestBody UserRequest request);

}
