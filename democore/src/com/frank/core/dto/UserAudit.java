package com.frank.core.dto;

import java.io.Serializable;

public class UserAudit implements Serializable {

    private String userID;
    private String gameID;
    private String uuid; // this is uniqueId for each session

}
