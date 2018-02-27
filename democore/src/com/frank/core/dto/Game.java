package com.frank.core.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Game implements Serializable {
    private String gameID;
    private String name;
    private String gameDetails;

}
