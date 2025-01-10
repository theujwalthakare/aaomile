package com.aaomile.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import com.aaomile.entities.User;
import com.aaomile.repository.UserRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.var;

@Component
public class OAuthAthenticationSuccessHandler implements AuthenticationSuccessHandler {
    
    Logger logger = LoggerFactory.getLogger(OAuthAthenticationSuccessHandler.class);

    @Autowired
    private UserRepo userRepo;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request, 
            HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {


            logger.info("OAuthAthenticationSuccessHandler");

            var oauth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;
            
            String authorizedClientRegistrationId = oauth2AuthenticationToken.getAuthorizedClientRegistrationId();
            
            logger.info(authorizedClientRegistrationId);

            var oauthUser = (DefaultOAuth2User)authentication.getPrincipal();
            
            oauthUser.getAttributes().forEach((key, value) -> {
                logger.info(key + " => " + value);
            });

            User user = new User();
            
            if(authorizedClientRegistrationId.equalsIgnoreCase("google")){
                
                String firstName = oauthUser.getAttribute("given_name");
                String lastName = oauthUser.getAttribute("family_name");
                String email = oauthUser.getAttribute("email");
                String picture = oauthUser.getAttribute("picture").toString();
                
                user.setEmail(email);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setFullName(firstName+" "+lastName);
                user.setEmail(email);
                user.setEmailVerified(true);
                user.setProfilePic(picture);
                user.setPassword("defaultPassword");
                user.setProvider("GOOGLE");

            }
            else{
                logger.info("OAuthAthenticationSuccessHandler: Unknown Provider");
            }

            // logger.info(user.getAuthorities().toString());


            //create user and save in databse
            // User user1 = new User();

            // user1.setFirstName(firstName);
            // user1.setLastName(lastName);
            // user1.setFullName(firstName+" "+lastName);
            // user1.setEmail(email);
            // user1.setProfilePic(picture);
            // user1.setPassword("defaultPassword");


            User user2 = userRepo.findByEmail(user.getEmail()).orElse(null);
            if(user2 == null){
                userRepo.save(user);
                logger.info("User saved");
            }
            else{
                logger.info("User already exists");
            }
            new DefaultRedirectStrategy().sendRedirect(request, response,"/user/after_login");
    }

}
