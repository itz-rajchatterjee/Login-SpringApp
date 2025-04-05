package com.persistance.iprocess;

public interface ICreateUserProcess {
    
    public String createUser(String username, String pass) throws Exception;
    public String authenticateUser(String username, String pass) throws Exception;
}
