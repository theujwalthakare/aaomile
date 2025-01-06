package com.aaomile.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/user")
public class UserController {

    @RequestMapping("/after_login")
    public String after_login() {
        return "user/after_login";
    }

    @RequestMapping("/CreateEvent")    //user/create event
    public String creatEvent(Model model) {
        return "user/CreateEvent";
    }

    // user/dashboard
    // user/edit profile
    // user/bookevent 
}
