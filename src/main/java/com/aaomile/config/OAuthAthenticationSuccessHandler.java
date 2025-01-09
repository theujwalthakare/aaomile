package com.aaomile.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import com.aaomile.entities.User;
import com.aaomile.repository.UserRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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

            DefaultOAuth2User user = (DefaultOAuth2User) authentication.getPrincipal();
            logger.info(user.getName());
            user.getAttributes().forEach((key,value)->{
                logger.info("{} => {}",key,value);
            });
            logger.info(user.getAuthorities().toString());

            String firstName = user.getAttribute("given_name").toString();
            String lastName = user.getAttribute("family_name").toString();
            String email = user.getAttribute("email").toString();
            // String name = user.getAttribute("name").toString();
            String picture = user.getAttribute("picture").toString();

            //create user and save in databse
            User user1 = new User();

            user1.setFirstName(firstName);
            user1.setLastName(lastName);
            user1.setFullName(firstName+" "+lastName);
            user1.setEmail(email);
            user1.setProfilePic(picture);

            user1.setPassword("defaultPassword");
            user1.setEmailVerified(true);


            User user2 = userRepo.findByEmail(email).orElse(null);
            if(user2 == null){
                userRepo.save(user1);
                logger.info("User saved");
            }
            else{
                logger.info("User already exists");
            }
            new DefaultRedirectStrategy().sendRedirect(request, response,"/user/after_login");
    }

}
