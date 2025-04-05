package com.persistance.tc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.persistance.iprocess.ICreateUserProcess;
import com.persistance.itc.ITCCreateUser;

import jakarta.transaction.Transactional;

@Component
@Transactional(rollbackOn = Exception.class)
public class TCCreateUser implements ITCCreateUser{

    @Autowired
    ICreateUserProcess createUserProcess;

    private static final Logger log = LoggerFactory.getLogger(TCCreateUser.class);

    @Override
    public String createUser(String username, String pass) {

        log.info("Inside method createUser of TCCreateUser with inputs :: "+username+" "+pass);
        String resultString = null;
        try{
            resultString = createUserProcess.createUser(username, pass);
        }
        catch(Exception ex){
            log.error("Exception occured in method createUser of TCCreateUser :: ", ex);
        }
        return resultString;
    }

    @Override
    public String authenticateUser(String username, String pass) {

        log.info("Inside method authenticateUser of TCCreateUser with inputs :: "+username+" "+pass);
        String resultString = null;
        try{
            resultString = createUserProcess.authenticateUser(username, pass);
        }
        catch(Exception ex){
            log.error("Exception occured in method authenticateUser of TCCreateUser :: ", ex);
        }
        return resultString;
    }
}
