package com.frank.core.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private String userID;
    private String name;
    private String usernotes;
}

