package com.aaomile.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aaomile.service.UserService;

@Controller

@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/after_login")
    public String after_login(Model model, Authentication authentication) {
        return "user/after_login";
    }

    @RequestMapping("/CreateEvent")    //       user/create event
    public String createEvent(Model model) {
        return "user/CreateEvent";
    }

    @RequestMapping("/book")
    public String book(Model model) {
        return "user/book";
    }

    // @RequestMapping("/book")
    // public String book(Model model) {
    //     return "user/book";
    // }
    // user/dashboard
    // user/edit profile
    // user/bookevent 
}
