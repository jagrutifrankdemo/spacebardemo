package com.example.frank.jpa.model;

import lombok.Data;

import javax.persistence.*;

/*
CREATE TABLE `demo`.`user` (
  `userid` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `usernotes` VARCHAR(45) NULL,
  PRIMARY KEY (`userid`));

*/
@Data
@Entity
@Table(name = "User")
public class UserEntity {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="userid",length=15, nullable=false)
    private int userID;

    @Column(name="name",length=25, nullable=false)
    private String name;

    @Column(name="usernotes",length=45, nullable=true)
    private String usernotes;

    public UserEntity() {
    }

    public UserEntity(int userID, String name, String usernotes) {
        this.userID = userID;
        this.name = name;
        this.usernotes = usernotes;
    }
    public UserEntity( String name, String usernotes) {
        this.userID = userID;
        this.name = name;
        this.usernotes = usernotes;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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
}
