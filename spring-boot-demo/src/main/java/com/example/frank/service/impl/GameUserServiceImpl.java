package com.example.frank.service.impl;

import com.example.frank.controller.UserNotFoundException;
import com.example.frank.controller.model.UserRequest;
import com.example.frank.jpa.AuditRepository;
import com.example.frank.jpa.GameUserRepository;
import com.example.frank.jpa.model.UserEntity;
import com.example.frank.jpa.model.UserMaxGamesPlayedJPA;
import com.example.frank.redis.model.RedisUser;
import com.example.frank.redis.repository.UserRepository;
import com.example.frank.service.GameUserService;
import com.frank.core.dto.User;
import com.frank.core.dto.UserMaxGamesPlayed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

public class GameUserServiceImpl implements GameUserService {
    @Autowired
    private UserRepository userRepository; // Redis repo

    @Autowired
    private GameUserRepository gameUserRepository; // mysql repo


    @Autowired
    private AuditRepository auditRepository; //mysql repo


    @PersistenceContext
    EntityManager em; //to execute Query

    @Override
    public RedisUser updateUser(String userid, RedisUser userdetails) {
        RedisUser requiredUSer = userRepository.findOne(userid);
        if (requiredUSer != null) {
            requiredUSer.setName(userdetails.getName()); //assuming only name needs updating
            //else based on flag fields can be updated in similar fashion
            requiredUSer.setUsernotes(userdetails.getUsernotes());
        }
        return userRepository.findOne(userid);
    }

    @Override
    public RedisUser cacheUser(RedisUser userdetails) {
        //cache it in redis and return the object
        RedisUser user = userRepository.save(userdetails);
        return user; //can check the ID

        // return  null;
    }

    @Override
    public void purge(String userID) {
        userRepository.delete(userID); // this should be not available / only Super USEr should be allowed
    }

    @Override
    public UserMaxGamesPlayed getUserMaxGamesPlayed() {
        Iterable<UserMaxGamesPlayedJPA> userMaxGamesPlayeds = auditRepository.findAll();
        if (userMaxGamesPlayeds != null) {// this will give the list( but sql will return only one record)
            for (UserMaxGamesPlayedJPA userMaxGamesPlayed : userMaxGamesPlayeds) {
                UserEntity userEntity = gameUserRepository.findOne(Integer.parseInt(userMaxGamesPlayed.getUserID()));
                // convert toDAO to return name and number of Games played from entity using helper
                if (userEntity != null) {
                    UserMaxGamesPlayed userMaxGamesPlayedDao = new UserMaxGamesPlayed();
                    userMaxGamesPlayedDao.setNumbergamesplayed(userMaxGamesPlayed.getNumbergamesplayed());
                    userMaxGamesPlayedDao.setUserName(userEntity.getName());
                    return userMaxGamesPlayedDao;
                }
            }
        }
        //incase no user is found then
        throw new UserNotFoundException("Unable to find USEr"); //custom Exception via ControllerAdvice
    }

    @Override
    public User saveUserdatabase(UserRequest userdetails) {
        User user = null;
        //TODO convert to database entity using helper
       // UserEntity userEntity = new UserEntity(1, "name", "testing");
        //gameUserRepository.save(userEntity);

        UserEntity userEntitySave = new UserEntity(userdetails.getName(),userdetails.getUsernotes());
        user= new User();
        UserEntity userEntity=  gameUserRepository.save(userEntitySave);
        user.setName(userEntity.getName());
        user.setUsernotes(userEntity.getUsernotes());
        user.setUserID(userEntity.getUserID()+"");
        return user; //can check the ID
    }


    //Service to get the sql between dates- this needs to be called from controller

    // this is to query database via sql between clause
    @Transactional(
            propagation = Propagation.REQUIRES_NEW,
            readOnly = true
    )
    public UserMaxGamesPlayed getUserPlayedMaxGamesbetween(Date startdate, Date endDate) {
        java.text.SimpleDateFormat simpleDateFormat =
                new java.text.SimpleDateFormat("yyyy-MM-dd 00:00:00");
        String startTime = simpleDateFormat.format(startdate);

        java.text.SimpleDateFormat simpleEndDateFormat =
                new java.text.SimpleDateFormat("yyyy-MM-dd 23:00:00");
        String endTime = simpleEndDateFormat.format(endDate);


        Query q = this.em.createNativeQuery("\n" +
                "select   u.name,  count(ua.uuid) numbergamesplayed\n" +
                "\tfrom useraudit ua\n" +
                "\tleft join user_login_audit ula\n" +
                "\t on ua.uuid= ula.uuid\n" +
                "     and ula.logintime BETWEEN \"" + startTime + "\" AND \"" + endTime +
                " \"    left join user u\n" +
                "     on ua.userid= u.userid\n" +
                "group by ua.uuid,ua.userid order by numbergamesplayed  desc LIMIT 1;\n");
        List results = q.getResultList();
        // results.forEach(UserPlay);
        for (Iterator i = results.iterator(); i.hasNext(); ) {
            UserMaxGamesPlayed userMaxGamesPlayed = new UserMaxGamesPlayed();

            Object object = i.next();
            Object[] objectArr = (Object[])((Object[])object);
          /*  String ss = (String)objectArr[0];
            String ss2 = objectArr[1] +"";*/
            userMaxGamesPlayed.setUserName((String)objectArr[0]);
            userMaxGamesPlayed.setNumbergamesplayed(Integer.parseInt(objectArr[1] +""));
            return userMaxGamesPlayed; //returns the first object as sql limits to 1

        }
        //incase no user is found then
        throw new UserNotFoundException("Unable to find USEr"); //custom Exception via ControllerAdvice
    }

}