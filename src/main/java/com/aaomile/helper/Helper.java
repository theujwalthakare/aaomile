package com.aaomile.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.aaomile.controllers.UserController;

public class Helper {

    
    public static String getEmailOfLoggedInUser(Authentication authentication){
        
        Logger logger = LoggerFactory.getLogger(Helper.class);

        if (authentication instanceof OAuth2AuthenticationToken) {

            var aOAuth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;
            var clientId = aOAuth2AuthenticationToken.getAuthorizedClientRegistrationId();

            var oauth2User = (OAuth2User) authentication.getPrincipal();
            String username = "";

            if (clientId.equalsIgnoreCase("google")) {

                // sign with google
                logger.info("GOOGLE LOGIN");
                username = oauth2User.getAttribute("email").toString();

            }
            return username;
        }
        else{
            logger.info("LOGIN THROUGH DATABASE");
            return authentication.getName();
        }
    }
}
