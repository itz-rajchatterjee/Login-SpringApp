package com.persistance.itc;

public interface ITCCreateUser {
    public String createUser(String username, String pass);
    public String authenticateUser(String username, String pass);
}
