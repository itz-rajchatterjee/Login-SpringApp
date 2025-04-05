package com.persistance.process;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.persistance.iprocess.ICreateUserProcess;
import com.persistance.persistance.entity.TUser;

import com.persistance.persistance.repo.TUserRepo;
import com.persistance.utilities.Utility;


@Component
public class CreateUserProcess implements ICreateUserProcess{

    @Autowired
    TUserRepo tUserRepo;

    private static final Logger log = LoggerFactory.getLogger(CreateUserProcess.class);
    
    @Override
    public String createUser(String username, String pass) throws Exception {

        log.info("Inside method createUser of CreateUserProcess with inputs :: "+username+" "+pass);

        TUser tUser = new TUser();
        if(null != username && username.length()>0 && null != pass && pass.length()>=8){
            tUser.setUserCode(username);
            tUser.setUserPass(Utility.encoder(pass));

            tUserRepo.saveAndFlush(tUser);

            return "User Created Successfully";
        }
        else{
            log.error("Error occured while saving inside method createUser of CreateUserProcess with inputs :: "+username+" "+pass);
            throw new Exception();
        }
    }

    @Override
    public String authenticateUser(String username, String pass) throws Exception {

        log.info("Inside method authenticateUser of CreateUserProcess with inputs :: "+username+" "+pass);

        List<TUser> lstTUser = tUserRepo.findByUserCode(username);
        boolean isAuthenticated = Boolean.FALSE;

        if(null != lstTUser && !lstTUser.isEmpty()){
            String password = Utility.decoder(lstTUser.get(0).getUserPass());
            if(password.equals(pass)){
                isAuthenticated = Boolean.TRUE;
            }
        }
        if(isAuthenticated)
            return "Welcome, Loggeed in!";
        else
            return "User Not Found";
    }
}
