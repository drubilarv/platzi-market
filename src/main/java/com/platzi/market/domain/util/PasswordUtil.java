package com.platzi.market.domain.util;


import org.springframework.context.annotation.Bean;

public class PasswordUtil {

    public static enum SecurityLevel
    {
        WEAK,MEDIUM,STRONG
    }


    public static SecurityLevel assessPassword(String password){

        if( password.length()<8 ){
            return SecurityLevel.WEAK;
        }
        if( password.matches("[a-zA-z]+") ){
            return SecurityLevel.WEAK;
        }

        if( password.matches("[0-9]+") ) {
            return SecurityLevel.WEAK;
        }

        if( password.matches("[0-9a-zA-Z]+") && password.length()>8 ){
            return SecurityLevel.MEDIUM;
        }


        return SecurityLevel.STRONG;

    }

}
