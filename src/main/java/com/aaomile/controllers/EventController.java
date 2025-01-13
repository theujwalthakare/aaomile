package com.aaomile.controllers;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aaomile.entities.Event;
import com.aaomile.entities.User;
import com.aaomile.forms.EventFrom;
import com.aaomile.helper.Helper;
import com.aaomile.helper.Message;
import com.aaomile.helper.MessageType;
import com.aaomile.service.EventService;
import com.aaomile.service.ImageService;
import com.aaomile.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/user/event")
public class EventController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @Autowired
    private ImageService imageService;

    @RequestMapping("/create")
    public String addEventView(Model model){
        Logger logger = LoggerFactory.getLogger(this.getClass());

        EventFrom eventFrom = new EventFrom();
        model.addAttribute("eventForm", eventFrom);
        
        return "user/eventFormApplication";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String saveEvent(@Valid @ModelAttribute EventFrom eventFrom,BindingResult result ,Authentication authentication, HttpSession session){

        String email = Helper.getEmailOfLoggedInUser(authentication);
        User user = userService.getUserByEmail(email);

        // String email = Helper.getEmailOfLoggedInUser(authentication);
// 
        // User uname = userService.getUserByEmail(email);


        // //validation
        if(result.hasErrors()){
            
            return "user/eventFormApplication";
        }

        //process image

        // String fileName = UUID.randomUUID().toString();   //this creates a random 128 bits ID 
        String bannerName = eventFrom.getEventName();        // this takes the event name as id for to store at cloudinary
        //banner upload programm
        String bannerURL =  imageService.uploadImage(eventFrom.getEventBanner(),bannerName);


        Event event = new Event();
        event.setEventName(eventFrom.getEventName());
        event.setEventDiscription(eventFrom.getEventDiscription());
        event.setEventGenre(eventFrom.getEventGenre());
        event.setEventType(eventFrom.getEventType());
        event.setEventBanner(bannerURL);  //banner url to DB
        event.setCloudBannerId(bannerName); //random generated file
        event.setEventDate(eventFrom.getEventDate());
        event.setEventTime(eventFrom.getEventTime());
        event.setEventVenue(eventFrom.getEventVenue());
        event.setEventAddress(eventFrom.getEventAddress());
        event.setEventCity(eventFrom.getEventCity());
        event.setEventState(eventFrom.getEventState());
        event.setEventPincode(eventFrom.getEventPincode());
        event.setTicketType(eventFrom.getTicketType());
        event.setTicketPrice(eventFrom.getTicketPrice());
        event.setSeates(eventFrom.getSeates());
        event.setEventDuration(eventFrom.getHours()+":"+eventFrom.getMinutes()+":"+eventFrom.getSeconds());
        event.setUser(user);
        event.setCreatorEmail(email); 

        eventService.save(event);
        logger.info("EVENT CREATTION STARTED");
        logger.info("EVENT CREATED AND SAVED");
        logger.info("CREATOR USER ID => {}",user);
        logger.info("CREATOR USER EMAIL => {}",email);
        logger.info(eventFrom.toString());
        logger.info("EVENT CREATTION ENDED");


        session.setAttribute("message", Message.builder()
        .content("Event Created Successfully ")
        .type(MessageType.green)
        .build());
        return "redirect:/user/event/create";

    }

}