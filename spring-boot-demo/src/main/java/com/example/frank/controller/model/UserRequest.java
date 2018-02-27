package com.example.frank.controller.model;

import java.io.Serializable;

public class UserRequest implements Serializable {
    private String name;
    private String usernotes;

    public UserRequest() {
    }

    public UserRequest(String name, String usernotes) {
        this.name = name;
        this.usernotes = usernotes;
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
