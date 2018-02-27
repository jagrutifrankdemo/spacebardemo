package com.example.frank.controller;

public class UserNotFoundException extends RuntimeException  {
    public UserNotFoundException(String message) {
        super(message);
    }
}
