package com.aaomile.controllers;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.security.core.Authentication;
import com.aaomile.entities.Event;
import com.aaomile.entities.User;
import com.aaomile.helper.Helper;
import com.aaomile.service.EventService;
import com.aaomile.service.UserService;

@ControllerAdvice
public class RootController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired 
    private EventService eventService;
    
    @ModelAttribute
    public void addLoggedInUserInformation(Model model, Authentication authentication) {

        if(authentication == null){
            return;
        }
        logger.info("------------------------------------------------------------");
        logger.info("LOGGED IN USER INFO");
        String username = Helper.getEmailOfLoggedInUser(authentication);
        
        logger.info("User Logged in {}", username);
        User user = userService.getUserByEmail(username);
        logger.info("USER =>"+ user);
        logger.info("FULL NAME =>"+user.getFullName());
        logger.info("USER EMAIL =>"+user.getEmail());
        logger.info("PROFILE PIC =>"+user.getProfilePic());
        logger.info("User Id =>"+user.getId());
        model.addAttribute("loggedInUser", user);
    }

    @ModelAttribute
    public void eventByComedy(Model model){
        String genre = "Comedy";

        List<Event> events = eventService.getByGenre(genre);
        model.addAttribute("comedyEvent", events);
        // return"comedy";
    }

    @ModelAttribute
    public void eventByMusic(Model model){
        String genre = "Music";

        List<Event> events = eventService.getByGenre(genre);
        model.addAttribute("musicEvent", events);
        // return"comedy";
    }

    @ModelAttribute
    public void eventByWorkshop(Model model){
        String genre = "Workshop";

        List<Event> events = eventService.getByGenre(genre);
        model.addAttribute("workshopEvent", events);
        // return"comedy";
    }

    @ModelAttribute
    public void eventByExhibition(Model model){
        String genre = "Exhibition";

        List<Event> events = eventService.getByGenre(genre);
        model.addAttribute("exhibitionEvent", events);
        // return"comedy";
    }

    @ModelAttribute
    public void eventByTheater(Model model){
        String genre = "Theater";

        List<Event> events = eventService.getByGenre(genre);
        model.addAttribute("theaterEvent", events);
        // return"comedy";
    }

    @ModelAttribute
    public void eventByHackathon(Model model){
        String genre = "Hackathon";

        List<Event> events = eventService.getByGenre(genre);
        model.addAttribute("hackathonEvent", events);
        // return"comedy";
    }

    @ModelAttribute
    public void getallEvent(Model model){
        List<Event> events = eventService.getAll();
        model.addAttribute("allEvent", events);
    }

    @ModelAttribute
    public void getUserCreatedEvents(Model model,
                                    Authentication authentication){
        String email = Helper.getEmailOfLoggedInUser(authentication);
        User user = userService.getUserByEmail(email);
        List<Event> events = eventService.getByUserId(user);
        model.addAttribute("createdEvents", events);
    }



}
