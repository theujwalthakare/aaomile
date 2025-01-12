package com.aaomile.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.security.core.Authentication;
import com.aaomile.entities.User;
import com.aaomile.helper.Helper;
import com.aaomile.service.UserService;

@ControllerAdvice
public class RootController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;
    
    @ModelAttribute
    public void addLoggedInUserInformation(Model model, Authentication authentication) {

        if(authentication == null){
            return;
        }
        logger.info("------------------------------------------------------------");
        logger.info("GOOGLE LOGIN INITIATED");
        logger.info("LOGGED IN USER INFO");
        String username = Helper.getEmailOfLoggedInUser(authentication);
        
        logger.info("User Logged in {}", username);
        User user = userService.getUserByEmail(username);
        // System.out.println(user.toString());
        // System.out.println(user.getFullName());
        // System.out.println(user.getEmail());
        // System.out.println(user.getProfilePic());
        logger.info("USER =>"+user.toString());
        logger.info("FULL NAME =>"+user.getFullName());
        logger.info("USER EMAIL =>"+user.getEmail());
        logger.info("PROFILE PIC =>"+user.getProfilePic());
        model.addAttribute("loggedInUser", user);
    }

}
