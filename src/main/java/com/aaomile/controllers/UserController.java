package com.aaomile.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aaomile.service.EventService;
import com.aaomile.service.UserService;

@Controller

@RequestMapping("/user")
public class UserController {

    // private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/after_login")
    public String after_login(Model model, Authentication authentication) {
        // return "user/after_login";
        return "home";
    }

    @RequestMapping("/CreateEvent")    //       user/create event
    public String createEvent(Model model) {
        return "user/CreateEvent";
    }

    @RequestMapping("/booking")    //       user/bookings
    public String book(Model model) {
        return "user/book";
    }

    // user/dashboard
    @RequestMapping("/dashboard")
    public String dashboard(Model model) {
        return "user/dashboard";
    }

    // user/bookevent 
    @RequestMapping("/user-booking")
    public String userBooking(Model model) {
        return "user/user-booking";
    }
    
    @RequestMapping("/eventFormApplication")
    public String eventFormApplication(Model model) {
        return "user/eventFormApplication";
    }

    @Autowired 
    private EventService eventService;
    
    @RequestMapping("/home/comedy")
    public String eventByComedy(Model model){
        return"comedy";
    }
    @RequestMapping("/home/music")
    public String eventByMusic(Model model){
        return"music";
    }
    @RequestMapping("/home/workshop")
    public String eventByWorkshop(Model model){
        return"workshop";
    }
    @RequestMapping("/home/exhibition")
    public String eventByExhibition(Model model){
        return"exhibition";
    }
    @RequestMapping("/home/theater")
    public String eventByTheater(Model model){
        return"theater";
    }
    @RequestMapping("/home/hackathon")
    public String eventByHackathon(Model model){
        return"hackathon";
    }

    // user/edit profile

}
