package com.aaomile.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/event")
public class EventController {


    @RequestMapping("/create")
    public String addEventView(){
        return "user/eventFormApplication";
    }

}
