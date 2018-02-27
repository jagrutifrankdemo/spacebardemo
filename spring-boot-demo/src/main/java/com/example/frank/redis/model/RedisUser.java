package com.example.frank.redis.model;

import com.frank.core.dto.User;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.io.Serializable;

@RedisHash("User")
public class RedisUser implements Serializable {
       @Id
        private String id;

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getUsernotes() {
                return usernotes;
        }

        public void setUsernotes(String usernotes) {
                this.usernotes = usernotes;
        }

        private String name;
        private String usernotes;


        public RedisUser(String userID, String name, String usernotes) {
                this.id = userID;
                this.name = name;
                this.usernotes = usernotes;
        }
        public RedisUser(User userdetail) {
                this.id = userdetail.getUserID();
                this.name = userdetail.getName();
                this.usernotes = userdetail.getUsernotes();
        }

}