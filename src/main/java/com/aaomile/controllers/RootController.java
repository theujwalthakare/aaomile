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
        System.out.println("Adding LOGGED IN USER INFO");
        String username = Helper.getEmailOfLoggedInUser(authentication);
        
        logger.info("User Logged in {}", username);
        User user = userService.getUserByEmail(username);
        System.out.println(user);
        System.out.println(user.getFullName());
        System.out.println(user.getEmail());
        model.addAttribute("loggedInUser", user);
    }

}
