package com.aaomile.controllers;

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
import com.aaomile.service.EventService;
import com.aaomile.service.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/user/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @RequestMapping("/create")
    public String addEventView(Model model){

        EventFrom eventFrom = new EventFrom();
        model.addAttribute("eventForm", eventFrom);
        return "user/eventFormApplication";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String saveEvent(@Valid @ModelAttribute EventFrom eventFrom,BindingResult result ,Authentication authentication){

        String username = Helper.getEmailOfLoggedInUser(authentication);
        User user = userService.getUserByEmail(username);

        String email = Helper.getEmailOfLoggedInUser(authentication);
// 
        // User uname = userService.getUserByEmail(email);


        //validation
        if(result.hasErrors()){
            
            return "user/eventFormApplication";
        }

        //process image

        Event event = new Event();
        event.setEventName(eventFrom.getEventName());
        event.setEventDiscription(eventFrom.getEventDiscription());
        event.setEventGenre(eventFrom.getEventGenre());
        event.setEventType(eventFrom.getEventType());
        // event.setEventBanner(eventFrom.getEventBanner());
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
        // event.setEventDuration(eventFrom.getHours()+"hr"+eventFrom.getMinutes()+"min"+eventFrom.getSeconds()+"sec");
        event.setEventDuration(eventFrom.getHours()+":"+eventFrom.getMinutes()+":"+eventFrom.getSeconds());
        event.setUser(user);
        event.setCreatorEmail(email); 

        eventService.save(event);
        System.out.println(eventFrom);
        return "redirect:/user/event/create";

    }

}
