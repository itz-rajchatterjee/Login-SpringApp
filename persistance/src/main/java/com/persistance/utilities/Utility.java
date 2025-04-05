package com.persistance.utilities;

import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utility {

    private static final Logger log = LoggerFactory.getLogger(Utility.class);

    public static String encoder(String str){
        
        log.info("Inside method encoder of Utility with input :: "+str);

        byte[] encodedByteArray = null;
        try{
            encodedByteArray = Base64.getEncoder().encode(str.getBytes());
            log.info("Encoded password :: "+new String(encodedByteArray));
        }catch(Exception ex){
            log.error("Exception occured while encoding :: ", ex);
        }
        return new String(encodedByteArray);
    }

    public static String decoder(String str){

        log.info("Inside method decoder of Utility with input :: "+str);

        byte[] decodedByteArray = null;
        try{
            decodedByteArray = Base64.getDecoder().decode(str);
            log.info("Decoded password :: "+new String(decodedByteArray));
        }catch(Exception ex){
            log.error("Exception occured while decoding :: ", ex);
        }
        return new String(decodedByteArray);
    }
}
