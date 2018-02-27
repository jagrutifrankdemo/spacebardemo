package com.example.frank.jpa.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user_max_played")
public class UserMaxGamesPlayedJPA {


    @Id
    @Column(name = "id", length = 15, nullable = false)
    private int id;

    @Column(name = "uuid", length = 45, nullable = false)
    private String uuid;

    @Column(name = "userid", length = 15, nullable = false)
    private String userID;

    @Column(name = "numbergamesplayed", length = 15, nullable = false)
    private int numbergamesplayed;

    public UserMaxGamesPlayedJPA() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getNumbergamesplayed() {
        return numbergamesplayed;
    }

    public void setNumbergamesplayed(int numbergamesplayed) {
        this.numbergamesplayed = numbergamesplayed;
    }

    public UserMaxGamesPlayedJPA(int id, String uuid, String userID, int numbergamesplayed) {
        this.id = id;
        this.uuid = uuid;
        this.userID = userID;

        this.numbergamesplayed = numbergamesplayed;
    }
}
