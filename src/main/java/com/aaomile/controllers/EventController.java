package com.aaomile.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aaomile.entities.Event;
import com.aaomile.forms.EventFrom;

@Controller
@RequestMapping("/user/event")
public class EventController {


    @RequestMapping("/create")
    public String addEventView(Model model){

        EventFrom eventFrom = new EventFrom();

        model.addAttribute("eventForm", eventFrom);
        return "user/eventFormApplication";
    }

    @RequestMapping(value = "/add", method =  RequestMethod.POST)
    public String createEvent(Event event){

        return "";
    }

}
