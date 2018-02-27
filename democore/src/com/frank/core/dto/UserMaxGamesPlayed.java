package com.frank.core.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserMaxGamesPlayed implements Serializable {
        private String userName;
        private int numbergamesplayed;

        public UserMaxGamesPlayed() {
        }

        public UserMaxGamesPlayed(String userName, int numbergamesplayed) {
                this.userName = userName;
                this.numbergamesplayed = numbergamesplayed;
        }
}
