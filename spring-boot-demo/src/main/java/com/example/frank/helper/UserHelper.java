package com.example.frank.helper;

import com.example.frank.redis.model.RedisUser;
import com.frank.core.dto.User;
import org.springframework.stereotype.Component;

@Component
public class UserHelper {

    //All required conversation for user should be placed in this class
    public static RedisUser toRedisUser(User user) {
        return new RedisUser(user);
    }


    //All required conversation for user should be placed in this class
    public static User toDaoUser(RedisUser user) {
        User daoUser = new User();
        daoUser.setName(user.getName());
        daoUser.setUsernotes(user.getUsernotes());
        daoUser.setUserID(user.getId());
        return daoUser;
    }
}
